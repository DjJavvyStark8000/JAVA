CREATE DATABASE CAPAS_JAVA_WEB_2023
GO

USE CAPAS_JAVA_WEB_2023
GO

CREATE TABLE CLIENTES(
	ID_CLIENTE int IDENTITY(1,1) NOT NULL PRIMARY KEY,
	NOMBRE varchar(80) NOT NULL,
	TELEFONO varchar(11) NULL,
	DIRECCION varchar(80) NULL,
)


CREATE TABLE PRODUCTOS(
	ID_PRODUCTO int IDENTITY(1,1) NOT NULL PRIMARY KEY,
	DESCRIPCION varchar(80) NOT NULL,
	PRECIOCOMPRA decimal(10,2) NOT NULL,
	PRECIOVENTA decimal(10,2) NOT NULL,
)

CREATE TABLE ENCABEZADO_FACTURA(
	ID_FACTURA int IDENTITY(1,1) NOT NULL PRIMARY KEY,
	FECHA DATETIME DEFAULT GETDATE(),
	ID_CLIENTE int NOT NULL,
	SUBTOTAL decimal(10,2) NOT NULL,
	IMPUESTO decimal(10,2) NOT NULL,
	MONTODESCUENTO decimal(10,2) NOT NULL,
	ESTADO VARCHAR(20) DEFAULT('PENDIENTE')
)

ALTER TABLE ENCABEZADO_FACTURA ADD CONSTRAINT CHK_ESTADO
CHECK(ESTADO IN('PENDIENTE','CANCELADA','VENCIDA','ANULADA'))

CREATE TABLE DETALLE_FACTURA(
	ID_FACTURA int NOT NULL,
	ID_PRODUCTO int NOT NULL,
	CANTIDAD INT,
	CONSTRAINT PK_DETALLE_FACTURA PRIMARY KEY (ID_FACTURA,ID_PRODUCTO)
)

ALTER TABLE ENCABEZADO_FACTURA ADD CONSTRAINT FK_ENCABEZADO_FACTURA
FOREIGN KEY (ID_CLIENTE) REFERENCES CLIENTES(ID_CLIENTE)

ALTER TABLE DETALLE_FACTURA ADD CONSTRAINT FK_DETALLE_FACTURA
FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTOS(ID_PRODUCTO)

ALTER TABLE DETALLE_FACTURA ADD CONSTRAINT FK_DETALLE_FACTURA_ENCABEZADO
FOREIGN KEY (ID_FACTURA) REFERENCES ENCABEZADO_FACTURA(ID_FACTURA)

/*Datos*/

insert into CLIENTES(NOMBRE,TELEFONO,DIRECCION)
				VALUES	('JOSEGE','8888-8888','SAN MIGUEL'),
						('MARIA','2222-2222','SAN RAMION'),
						('KARLA','3333-3333','PALMARES')


insert into PRODUCTOS(DESCRIPCION,PRECIOCOMPRA,PRECIOVENTA)
				VALUES	('AROOZ',1000,1200),
						('AZUCAR',900,1100),
						('MANTECA',600,750),
						('CAFE',1600,1750)

insert into ENCABEZADO_FACTURA(ID_CLIENTE,SUBTOTAL, IMPUESTO,MONTODESCUENTO,ESTADO)
				VALUES	(1,0,5,5,'CANCELADA'),
						(2,0,5,5,'PENDIENTE'),
						(1,0,5,5,'VENCIDA')


insert into DETALLE_FACTURA(ID_FACTURA,ID_PRODUCTO, CANTIDAD)
				VALUES	(3,1,5),
						(3,2,5),
						(3,3,5)

select * from DETALLE_FACTURA
select * from PRODUCTOS
select * from ENCABEZADO_FACTURA
select * from CLIENTES


/************* procedimientos almacenados */

--Procedimiento # 1: Crear un procedimiento almacenado que permita ANULAR una factura, 
--las facturas solo se pueden anular si esta cancelada.

GO
CREATE OR ALTER PROCEDURE AnularFactura
    @idFactura INT,
    @message NVARCHAR(100) OUTPUT
AS
BEGIN
    -- Verificar si la factura está cancelada
    DECLARE @estado VARCHAR(20)

    SELECT @estado = ESTADO
    FROM ENCABEZADO_FACTURA
    WHERE ID_FACTURA = @idFactura

    IF @estado = 'CANCELADA'
    BEGIN
        -- Actualizar el estado de la factura a 'ANULADA'
        UPDATE ENCABEZADO_FACTURA
        SET ESTADO = 'ANULADA'
        WHERE ID_FACTURA = @idFactura

        SET @message = 'Factura anulada correctamente.'
    END
    ELSE
    BEGIN
        SET @message = 'La factura no puede ser anulada. Solo se pueden anular facturas canceladas.'
    END

    RETURN 0; -- You can return an integer value, such as 0, to indicate success
END

DECLARE @outputMessage NVARCHAR(100);

EXEC AnularFactura @idFactura = 2, @message = @outputMessage OUTPUT;

PRINT @outputMessage;


--Procedimiento # 2: Crear un procedimiento almacenado para buscar un cliente, 
--devolver un mensaje si el cliente existe o no existe.

GO
CREATE OR ALTER PROCEDURE BuscarCliente
    @idCliente INT,
    @message NVARCHAR(100) OUTPUT
AS
BEGIN
    DECLARE @clienteExiste BIT;

    -- Verificar si el cliente existe
    SELECT @clienteExiste = CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END
    FROM CLIENTES
    WHERE ID_CLIENTE = @idCliente;

    IF @clienteExiste = 1
    BEGIN
        SET @message = 'El cliente existe.';
    END
    ELSE
    BEGIN
        SET @message = 'El cliente no existe.';
    END
END

DECLARE @outputMessage NVARCHAR(100);

EXEC BuscarCliente @idCliente = 10, @message = @outputMessage OUTPUT;

PRINT @outputMessage;

--Procedimiento # 3: Crear un procedimiento almacenado para eliminar un cliente. 
--El cliente no se puede eliminar si tiene facturas.

GO
CREATE OR ALTER PROCEDURE EliminarCliente
    @idCliente INT,
    @message NVARCHAR(100) OUTPUT
AS
BEGIN
    DECLARE @tieneFacturas BIT;

    -- Verificar si el cliente tiene facturas
    SELECT @tieneFacturas = CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END
    FROM ENCABEZADO_FACTURA
    WHERE ID_CLIENTE = @idCliente;

    IF @tieneFacturas = 0
    BEGIN
        -- No tiene facturas, se puede eliminar
        DELETE FROM CLIENTES
        WHERE ID_CLIENTE = @idCliente;

        SET @message = 'Cliente eliminado correctamente.';
    END
    ELSE
    BEGIN
        -- Tiene facturas, no se puede eliminar
        SET @message = 'El cliente tiene facturas pendientes y no se puede eliminar.';
    END
END

DECLARE @outputMessage NVARCHAR(100);

EXEC EliminarCliente @idCliente = 2, @message = @outputMessage OUTPUT;

PRINT @outputMessage;

--Procedimiento # 4: Eliminar un detalle de factura, primero debe verificar que la factura existe, 
--solo puede eliminar un detalle de factura si la factura se encuentra pendiente, si elimina todos los 
--detalles de la factura también la factura se debe eliminar de forma automática.

GO
CREATE OR ALTER PROCEDURE EliminarDetalleFactura
    @idFactura INT,
    @idProducto INT,
    @message NVARCHAR(100) OUTPUT
AS
BEGIN
    DECLARE @facturaExiste BIT;
    DECLARE @facturaEstaPendiente BIT;

    -- Verificar si la factura existe
    SELECT @facturaExiste = CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END
    FROM ENCABEZADO_FACTURA
    WHERE ID_FACTURA = @idFactura;

    -- Verificar si la factura está en estado "PENDIENTE"
    SELECT @facturaEstaPendiente = CASE WHEN ESTADO = 'PENDIENTE' THEN 1 ELSE 0 END
    FROM ENCABEZADO_FACTURA
    WHERE ID_FACTURA = @idFactura;

    IF @facturaExiste = 1
    BEGIN
        IF @facturaEstaPendiente = 1
        BEGIN
            -- Eliminar el detalle de la factura
            DELETE FROM DETALLE_FACTURA
            WHERE ID_FACTURA = @idFactura AND ID_PRODUCTO = @idProducto;

            -- Verificar si la factura no tiene más detalles, y si es así, eliminar la factura
            IF NOT EXISTS (SELECT 1 FROM DETALLE_FACTURA WHERE ID_FACTURA = @idFactura)
            BEGIN
                DELETE FROM ENCABEZADO_FACTURA
                WHERE ID_FACTURA = @idFactura;
            END

            SET @message = 'Detalle de factura eliminado correctamente.';
        END
        ELSE
        BEGIN
            SET @message = 'No se puede eliminar el detalle de la factura. La factura no está en estado "PENDIENTE".';
        END
    END
    ELSE
    BEGIN
        SET @message = 'La factura no existe.';
    END
END

DECLARE @outputMessage NVARCHAR(100);

EXEC EliminarDetalleFactura @idFactura = 100, @idProducto = 1, @message = @outputMessage OUTPUT;

PRINT @outputMessage;

--Procedimiento # 5: Eliminar una factura: Solo se pueden eliminar las facturas pendientes, 
--debe también eliminar los detalles de dicha factura

GO
CREATE OR ALTER PROCEDURE EliminarFactura
    @idFactura INT,
    @message NVARCHAR(100) OUTPUT
AS
BEGIN
    DECLARE @facturaEstaPendiente BIT;

    -- Verificar si la factura está en estado "PENDIENTE"
    SELECT @facturaEstaPendiente = CASE WHEN ESTADO = 'PENDIENTE' THEN 1 ELSE 0 END
    FROM ENCABEZADO_FACTURA
    WHERE ID_FACTURA = @idFactura;

    IF @facturaEstaPendiente = 1
    BEGIN
        -- Eliminar los detalles de la factura
        DELETE FROM DETALLE_FACTURA
        WHERE ID_FACTURA = @idFactura;

        -- Eliminar la factura
        DELETE FROM ENCABEZADO_FACTURA
        WHERE ID_FACTURA = @idFactura;

        SET @message = 'Factura eliminada correctamente.';
    END
    ELSE
    BEGIN
        SET @message = 'No se puede eliminar la factura. La factura no está en estado "PENDIENTE".';
    END
END;

DECLARE @outputMessage NVARCHAR(100);

EXEC EliminarFactura @idFactura = 100, @message = @outputMessage OUTPUT;

PRINT @outputMessage;

--Procedimiento # 6: Insertar un cliente: Si el cliente existe debe modificar los datos, 
--si el cliente no existe debe ingresar el cliente.

GO
CREATE OR ALTER PROCEDURE InsertarCliente
    @idCliente INT OUTPUT,
    @nombre VARCHAR(80),
    @telefono VARCHAR(11) = NULL,
    @direccion VARCHAR(80) = NULL,
    @message NVARCHAR(100) OUTPUT
AS
BEGIN
    -- Verificar si el cliente ya existe
    SELECT @idCliente = ID_CLIENTE
    FROM CLIENTES
    WHERE NOMBRE = @nombre;

    IF @idCliente IS NOT NULL
    BEGIN
        -- El cliente ya existe, actualizar los datos
        UPDATE CLIENTES
        SET TELEFONO = @telefono,
            DIRECCION = @direccion
        WHERE ID_CLIENTE = @idCliente;

        SET @message = 'Cliente existente. Datos actualizados correctamente.';
    END
    ELSE
    BEGIN
        -- El cliente no existe, insertar el nuevo cliente
        INSERT INTO CLIENTES (NOMBRE, TELEFONO, DIRECCION)
        VALUES (@nombre, @telefono, @direccion);

        -- Obtener el ID del cliente recién insertado
        SET @idCliente = SCOPE_IDENTITY();

        SET @message = 'Nuevo cliente ingresado correctamente.';
    END
END;

DECLARE @outputMessage NVARCHAR(100);
DECLARE @clienteID INT;

EXEC InsertarCliente 
    @idCliente = @clienteID OUTPUT, 
    @nombre = 'Nuevo Cliente', 
    @telefono = '1234567890', 
    @direccion = 'Dirección del Nuevo Cliente', 
    @message = @outputMessage OUTPUT;

PRINT @outputMessage;

--Procedimiento # 7: AGREGAR UN DETALLE DE FACTURA: Tome en cuenta que un detalle de factura solo 
--se puede agregar una factura pendiente, también debe tomar en cuenta que si un detalle ya fue agregado 
--a una factura no se puede agregar de nuevo registro, en este caso lo que debe hacer es modificar la cantidad. 
--Ejemplo: Si intenta agregar 10 unidades de arroz y en esa misma factura ya hay 5 unidades debe guardar 
--15 unidades de arroz

GO
CREATE OR ALTER PROCEDURE AgregarDetalleFactura
    @idFactura INT,
    @idProducto INT,
    @cantidad INT,
    @message NVARCHAR(100) OUTPUT
AS
BEGIN
    DECLARE @facturaEstaPendiente BIT;
    DECLARE @productoExisteEnFactura BIT;
    DECLARE @cantidadExistente INT;

    -- Verificar si la factura está en estado "PENDIENTE"
    SELECT @facturaEstaPendiente = CASE WHEN ESTADO = 'PENDIENTE' THEN 1 ELSE 0 END
    FROM ENCABEZADO_FACTURA
    WHERE ID_FACTURA = @idFactura;

    -- Verificar si el producto ya existe en la factura
    SELECT @productoExisteEnFactura = CASE WHEN EXISTS (
        SELECT 1
        FROM DETALLE_FACTURA
        WHERE ID_FACTURA = @idFactura AND ID_PRODUCTO = @idProducto
    ) THEN 1 ELSE 0 END;

    IF @facturaEstaPendiente = 1
    BEGIN
        IF @productoExisteEnFactura = 1
        BEGIN
            -- Modificar la cantidad si el producto ya existe
            UPDATE DETALLE_FACTURA
            SET CANTIDAD = CANTIDAD + @cantidad
            WHERE ID_FACTURA = @idFactura AND ID_PRODUCTO = @idProducto;

            SET @message = 'Cantidad de producto actualizada en la factura.';
        END
        ELSE
        BEGIN
            -- Agregar un nuevo detalle a la factura
            INSERT INTO DETALLE_FACTURA (ID_FACTURA, ID_PRODUCTO, CANTIDAD)
            VALUES (@idFactura, @idProducto, @cantidad);

            SET @message = 'Detalle de factura agregado correctamente.';
        END
    END
    ELSE
    BEGIN
        SET @message = 'No se puede agregar un detalle a la factura. La factura no está en estado "PENDIENTE".';
    END
END;

DECLARE @outputMessage NVARCHAR(100);

-- Ejemplo: Agregar un detalle a la factura
EXEC AgregarDetalleFactura
    @idFactura = 1,
    @idProducto = 1,
    @cantidad = 10,
    @message = @outputMessage OUTPUT;

PRINT @outputMessage;


--Procedimiento # 8: Guardar un producto nuevo si el producto existe debe modificarlo.

GO
CREATE OR ALTER PROCEDURE GuardarProducto
    @idProducto INT,
    @descripcion VARCHAR(80),
    @precioCompra DECIMAL(10, 2),
    @precioVenta DECIMAL(10, 2),
    @message NVARCHAR(100) OUTPUT
AS
BEGIN
    DECLARE @productoExiste BIT;

    -- Verificar si el producto existe
    SELECT @productoExiste = CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END
    FROM PRODUCTOS
    WHERE ID_PRODUCTO = @idProducto;

    IF @productoExiste = 1
    BEGIN
        -- Modificar los datos del producto existente
        UPDATE PRODUCTOS
        SET DESCRIPCION = @descripcion,
            PRECIOCOMPRA = @precioCompra,
            PRECIOVENTA = @precioVenta
        WHERE ID_PRODUCTO = @idProducto;

        SET @message = 'Datos del producto modificados correctamente.';
    END
    ELSE
    BEGIN
        -- Insertar un nuevo producto
        INSERT INTO PRODUCTOS (DESCRIPCION, PRECIOCOMPRA, PRECIOVENTA)
        VALUES (@descripcion, @precioCompra, @precioVenta);

        SET @message = 'Producto ingresado correctamente.';
    END
END;

DECLARE @outputMessage NVARCHAR(100);

-- Ejemplo: Guardar un producto nuevo o modificar uno existente
EXEC GuardarProducto
    @idProducto = 1,
    @descripcion = 'Nuevo Producto',
    @precioCompra = 10.00,
    @precioVenta = 20.00,
    @message = @outputMessage OUTPUT;

PRINT @outputMessage;


--Procedimiento # 9: Guardar o modificar una factura, solo puede modificar las facturas pendientes.

GO
CREATE OR ALTER PROCEDURE GuardarModificarFactura
    @idFactura INT,
    @idCliente INT,
    @subtotal DECIMAL(10, 2),
    @impuesto DECIMAL(10, 2),
    @montoDescuento DECIMAL(10, 2),
    @estado VARCHAR(20),
    @message NVARCHAR(100) OUTPUT
AS
BEGIN
    DECLARE @facturaExiste BIT;
    DECLARE @facturaEstaPendiente BIT;

    -- Verificar si la factura existe
    SELECT @facturaExiste = CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END
    FROM ENCABEZADO_FACTURA
    WHERE ID_FACTURA = @idFactura;

    -- Verificar si la factura está en estado "PENDIENTE"
    SELECT @facturaEstaPendiente = CASE WHEN ESTADO = 'PENDIENTE' THEN 1 ELSE 0 END
    FROM ENCABEZADO_FACTURA
    WHERE ID_FACTURA = @idFactura;

    IF @facturaExiste = 1
    BEGIN
        IF @facturaEstaPendiente = 1
        BEGIN
            -- Modificar los datos de la factura pendiente
            UPDATE ENCABEZADO_FACTURA
            SET ID_CLIENTE = @idCliente,
                SUBTOTAL = @subtotal,
                IMPUESTO = @impuesto,
                MONTODESCUENTO = @montoDescuento,
                ESTADO = @estado
            WHERE ID_FACTURA = @idFactura;

            SET @message = 'Datos de la factura modificados correctamente.';
        END
        ELSE
        BEGIN
            SET @message = 'No se puede modificar la factura. La factura no está en estado "PENDIENTE".';
        END
    END
    ELSE
    BEGIN
        -- Insertar una nueva factura
        INSERT INTO ENCABEZADO_FACTURA (ID_CLIENTE, SUBTOTAL, IMPUESTO, MONTODESCUENTO, ESTADO)
        VALUES (@idCliente, @subtotal, @impuesto, @montoDescuento, @estado);

        SET @message = 'Factura ingresada correctamente.';
    END
END;

DECLARE @outputMessage NVARCHAR(100);

-- Ejemplo: Guardar o modificar una factura
EXEC GuardarModificarFactura
    @idFactura = 1,
    @idCliente = 2,
    @subtotal = 100.00,
    @impuesto = 10.00,
    @montoDescuento = 5.00,
    @estado = 'PENDIENTE',
    @message = @outputMessage OUTPUT;

PRINT @outputMessage;
