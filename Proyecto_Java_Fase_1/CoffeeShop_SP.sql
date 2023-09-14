USE COFFEE_SHOP_DB
GO

-----------------------------------------------CLIENTES----------------------------------------------------
-----------------------------------------------CLIENTES----------------------------------------------------
-----------------------------------------------CLIENTES----------------------------------------------------
--INSERTAR CLIENTE
CREATE OR ALTER PROCEDURE InsertarCliente (
    @NombreCliente VARCHAR(255),
    @Direccion VARCHAR(255),
    @NumeroTelefono VARCHAR(15),
    @CorreoElectronico VARCHAR(255),
    @Mensaje VARCHAR(255) OUTPUT
)
AS
BEGIN
    BEGIN TRY
        INSERT INTO CLIENTES (NOMBRE_CLIENTE, DIRECCION, NUMERO_TELEFONO, CORREO_ELECTRONICO)
        VALUES (@NombreCliente, @Direccion, @NumeroTelefono, @CorreoElectronico);
        SET @Mensaje = 'Inserción exitosa';
    END TRY
    BEGIN CATCH
        SET @Mensaje = 'Error al insertar el cliente. Detalle: ' + ERROR_MESSAGE();
    END CATCH
END;
GO


--OBTENER UN CLIENTE
CREATE OR ALTER PROCEDURE ObtenerClientePorID (
    @IDCliente INT,
    @Mensaje VARCHAR(255) OUTPUT
)
AS
BEGIN
    BEGIN TRY
        SELECT * FROM CLIENTES WHERE ID_CLIENTE = @IDCliente;
        SET @Mensaje = 'Consulta exitosa';
    END TRY
    BEGIN CATCH
        SET @Mensaje = 'Error al obtener el cliente. Detalle: ' + ERROR_MESSAGE();
    END CATCH
END;
GO

--ACTUALIZAR CLIENTE
CREATE OR ALTER PROCEDURE ActualizarCliente (
    @IDCliente INT,
    @NombreCliente VARCHAR(255),
    @Direccion VARCHAR(255),
    @NumeroTelefono VARCHAR(15),
    @CorreoElectronico VARCHAR(255),
    @Mensaje VARCHAR(255) OUTPUT
)
AS
BEGIN
    BEGIN TRY
        UPDATE CLIENTES
        SET
            NOMBRE_CLIENTE = @NombreCliente,
            DIRECCION = @Direccion,
            NUMERO_TELEFONO = @NumeroTelefono,
            CORREO_ELECTRONICO = @CorreoElectronico
        WHERE ID_CLIENTE = @IDCliente;
        SET @Mensaje = 'Actualización exitosa';
    END TRY
    BEGIN CATCH
        SET @Mensaje = 'Error al actualizar el cliente. Detalle: ' + ERROR_MESSAGE();
    END CATCH
END;
GO

--ELIMINAR CLIENTE
CREATE OR ALTER PROCEDURE EliminarCliente (
    @IDCliente INT,
    @Mensaje VARCHAR(255) OUTPUT
)
AS
BEGIN
    BEGIN TRY
        DELETE FROM CLIENTES WHERE ID_CLIENTE = @IDCliente;
        SET @Mensaje = 'Eliminación exitosa';
    END TRY
    BEGIN CATCH
        SET @Mensaje = 'Error al eliminar el cliente. Detalle: ' + ERROR_MESSAGE();
    END CATCH
END;
GO

--CANTIDAD DE CLIENTES
CREATE OR ALTER PROCEDURE ObtenerCantidadDeClientes
AS
BEGIN
    DECLARE @CantidadClientes INT;

    SELECT @CantidadClientes = COUNT(*) FROM CLIENTES;

    SELECT @CantidadClientes AS CantidadDeClientes;
END;
GO

DECLARE @Contador INT;
EXEC ObtenerCantidadDeClientes;
GO

-----------------------------------------------EMPLEADOS----------------------------------------------------
-----------------------------------------------EMPLEADOS----------------------------------------------------
-----------------------------------------------EMPLEADOS----------------------------------------------------

CREATE OR ALTER PROCEDURE InsertarEmpleado (
    @NombreEmpleado VARCHAR(255),
    @Direccion VARCHAR(255),
    @NumeroTelefono VARCHAR(15),
    @CorreoElectronico VARCHAR(255),
    @Cargo VARCHAR(255),
    @Mensaje VARCHAR(255) OUTPUT
)
AS
BEGIN
    BEGIN TRY
        INSERT INTO EMPLEADOS (NOMBRE_EMPLEADO, DIRECCION, NUMERO_TELEFONO, CORREO_ELECTRONICO, CARGO)
        VALUES (@NombreEmpleado, @Direccion, @NumeroTelefono, @CorreoElectronico, @Cargo);
        SET @Mensaje = 'Inserción exitosa';
    END TRY
    BEGIN CATCH
        SET @Mensaje = 'Error al insertar el empleado. Detalle: ' + ERROR_MESSAGE();
    END CATCH
END;
GO

CREATE OR ALTER PROCEDURE ObtenerEmpleadoPorID (
    @IDEmpleado INT,
    @Mensaje VARCHAR(255) OUTPUT
)
AS
BEGIN
    BEGIN TRY
        SELECT * FROM EMPLEADOS WHERE ID_EMPLEADO = @IDEmpleado;
        SET @Mensaje = 'Consulta exitosa';
    END TRY
    BEGIN CATCH
        SET @Mensaje = 'Error al obtener el empleado. Detalle: ' + ERROR_MESSAGE();
    END CATCH
END;
GO

CREATE OR ALTER PROCEDURE ActualizarEmpleado (
    @IDEmpleado INT,
    @NombreEmpleado VARCHAR(255),
    @Direccion VARCHAR(255),
    @NumeroTelefono VARCHAR(15),
    @CorreoElectronico VARCHAR(255),
    @Cargo VARCHAR(255),
    @Mensaje VARCHAR(255) OUTPUT
)
AS
BEGIN
    BEGIN TRY
        UPDATE EMPLEADOS
        SET
            NOMBRE_EMPLEADO = @NombreEmpleado,
            DIRECCION = @Direccion,
            NUMERO_TELEFONO = @NumeroTelefono,
            CORREO_ELECTRONICO = @CorreoElectronico,
            CARGO = @Cargo
        WHERE ID_EMPLEADO = @IDEmpleado;
        SET @Mensaje = 'Actualización exitosa';
    END TRY
    BEGIN CATCH
        SET @Mensaje = 'Error al actualizar el empleado. Detalle: ' + ERROR_MESSAGE();
    END CATCH
END;
GO

CREATE OR ALTER PROCEDURE EliminarEmpleado (
    @IDEmpleado INT,
    @Mensaje VARCHAR(255) OUTPUT
)
AS
BEGIN
    BEGIN TRY
        DELETE FROM EMPLEADOS WHERE ID_EMPLEADO = @IDEmpleado;
        SET @Mensaje = 'Eliminación exitosa';
    END TRY
    BEGIN CATCH
        SET @Mensaje = 'Error al eliminar el empleado. Detalle: ' + ERROR_MESSAGE();
    END CATCH
END;
GO

-----------------------------------------------PRODUCTOS----------------------------------------------------
-----------------------------------------------PRODUCTOS----------------------------------------------------
-----------------------------------------------PRODUCTOS----------------------------------------------------


CREATE OR ALTER PROCEDURE InsertarProducto (
    @NombreProducto VARCHAR(255),
    @Descripcion VARCHAR(255),
    @CantidadEnStock INT,
    @PrecioUnitario DECIMAL(10, 2),
    @Mensaje VARCHAR(255) OUTPUT
)
AS
BEGIN
    BEGIN TRY
        INSERT INTO PRODUCTOS (NOMBRE_PRODUCTO, DESCRIPCION, CANTIDAD_EN_STOCK, PRECIO_UNITARIO)
        VALUES (@NombreProducto, @Descripcion, @CantidadEnStock, @PrecioUnitario);
        SET @Mensaje = 'Inserción exitosa';
    END TRY
    BEGIN CATCH
        SET @Mensaje = 'Error al insertar el producto. Detalle: ' + ERROR_MESSAGE();
    END CATCH
END;
GO


CREATE OR ALTER PROCEDURE ObtenerProductoPorID (
    @IDProducto INT,
    @Mensaje VARCHAR(255) OUTPUT
)
AS
BEGIN
    BEGIN TRY
        SELECT * FROM PRODUCTOS WHERE ID_PRODUCTO = @IDProducto;
        SET @Mensaje = 'Consulta exitosa';
    END TRY
    BEGIN CATCH
        SET @Mensaje = 'Error al obtener el producto. Detalle: ' + ERROR_MESSAGE();
    END CATCH
END;
GO


CREATE OR ALTER PROCEDURE ActualizarProducto (
    @IDProducto INT,
    @NombreProducto VARCHAR(255),
    @Descripcion VARCHAR(255),
    @CantidadEnStock INT,
    @PrecioUnitario DECIMAL(10, 2),
    @Mensaje VARCHAR(255) OUTPUT
)
AS
BEGIN
    BEGIN TRY
        UPDATE PRODUCTOS
        SET
            NOMBRE_PRODUCTO = @NombreProducto,
            DESCRIPCION = @Descripcion,
            CANTIDAD_EN_STOCK = @CantidadEnStock,
            PRECIO_UNITARIO = @PrecioUnitario
        WHERE ID_PRODUCTO = @IDProducto;
        SET @Mensaje = 'Actualización exitosa';
    END TRY
    BEGIN CATCH
        SET @Mensaje = 'Error al actualizar el producto. Detalle: ' + ERROR_MESSAGE();
    END CATCH
END;
GO

CREATE OR ALTER PROCEDURE EliminarProducto (
    @IDProducto INT,
    @Mensaje VARCHAR(255) OUTPUT
)
AS
BEGIN
    BEGIN TRY
        DELETE FROM PRODUCTOS WHERE ID_PRODUCTO = @IDProducto;
        SET @Mensaje = 'Eliminación exitosa';
    END TRY
    BEGIN CATCH
        SET @Mensaje = 'Error al eliminar el producto. Detalle: ' + ERROR_MESSAGE();
    END CATCH
END;
GO


-----------------------------------------------PEDIDOS----------------------------------------------------
-----------------------------------------------PEDIDOS----------------------------------------------------
-----------------------------------------------PEDIDOS----------------------------------------------------

CREATE OR ALTER PROCEDURE InsertarPedido (
    @IDProducto INT,
    @Cantidad INT,
    @Fecha DATE,
	@Hora TIME,
    @EstadoPedido VARCHAR(255),
    @Mensaje VARCHAR(255) OUTPUT
)
AS
BEGIN
    BEGIN TRY
        INSERT INTO PEDIDOS (ID_PRODUCTO, CANTIDAD, FECHA, HORA, ESTADO_PEDIDO)
        VALUES (@IDProducto, @Cantidad, @Fecha, @Hora, @EstadoPedido);
        SET @Mensaje = 'Inserción exitosa';
    END TRY
    BEGIN CATCH
        SET @Mensaje = 'Error al insertar el pedido. Detalle: ' + ERROR_MESSAGE();
    END CATCH
END;
GO


CREATE OR ALTER PROCEDURE ObtenerPedidoPorID (
    @IDPedido INT,
    @Mensaje VARCHAR(255) OUTPUT
)
AS
BEGIN
    BEGIN TRY
        SELECT * FROM PEDIDOS WHERE ID_PEDIDO = @IDPedido;
        SET @Mensaje = 'Consulta exitosa';
    END TRY
    BEGIN CATCH
        SET @Mensaje = 'Error al obtener el pedido. Detalle: ' + ERROR_MESSAGE();
    END CATCH
END;
GO


CREATE OR ALTER PROCEDURE ActualizarPedido (
    @IDPedido INT,
    @IDProducto INT,
    @Cantidad INT,
    @Fecha DATE,
	@Hora TIME,
    @EstadoPedido VARCHAR(255),
    @Mensaje VARCHAR(255) OUTPUT
)
AS
BEGIN
    BEGIN TRY
        UPDATE PEDIDOS
        SET
            ID_PRODUCTO = @IDProducto,
            CANTIDAD = @Cantidad,
            FECHA = @Fecha,
			HORA = @Hora,
            ESTADO_PEDIDO = @EstadoPedido
        WHERE ID_PEDIDO = @IDPedido;
        SET @Mensaje = 'Actualización exitosa';
    END TRY
    BEGIN CATCH
        SET @Mensaje = 'Error al actualizar el pedido. Detalle: ' + ERROR_MESSAGE();
    END CATCH
END;
GO


CREATE OR ALTER PROCEDURE EliminarPedido (
    @IDPedido INT,
    @Mensaje VARCHAR(255) OUTPUT
)
AS
BEGIN
    BEGIN TRY
        DELETE FROM PEDIDOS WHERE ID_PEDIDO = @IDPedido;
        SET @Mensaje = 'Eliminación exitosa';
    END TRY
    BEGIN CATCH
        SET @Mensaje = 'Error al eliminar el pedido. Detalle: ' + ERROR_MESSAGE();
    END CATCH
END;
GO

-----------------------------------------------FACTURACION----------------------------------------------------
-----------------------------------------------FACTURACION----------------------------------------------------
-----------------------------------------------FACTURACION----------------------------------------------------


-- Create (INSERT)
CREATE OR ALTER PROCEDURE InsertarFactura (
    @Fecha DATE,
	@Hora TIME,
    @TotalFactura DECIMAL(10, 2),
    @Mensaje VARCHAR(255) OUTPUT
)
AS
BEGIN
    BEGIN TRY
        INSERT INTO FACTURACION (FECHA, HORA, TOTAL_FACTURA)
        VALUES (@Fecha, @Hora, @TotalFactura);
        SET @Mensaje = 'Inserción exitosa';
    END TRY
    BEGIN CATCH
        SET @Mensaje = 'Error al insertar la factura. Detalle: ' + ERROR_MESSAGE();
    END CATCH
END;
GO



CREATE OR ALTER PROCEDURE ObtenerFacturaPorID (
    @IDFactura INT,
    @Mensaje VARCHAR(255) OUTPUT
)
AS
BEGIN
    BEGIN TRY
        SELECT * FROM FACTURACION WHERE ID_FACTURA = @IDFactura;
        SET @Mensaje = 'Consulta exitosa';
    END TRY
    BEGIN CATCH
        SET @Mensaje = 'Error al obtener la factura. Detalle: ' + ERROR_MESSAGE();
    END CATCH
END;
GO


CREATE OR ALTER PROCEDURE ActualizarFactura (
    @IDFactura INT,
    @Fecha DATE,
	@Hora TIME,
    @TotalFactura DECIMAL(10, 2),
    @Mensaje VARCHAR(255) OUTPUT
)
AS
BEGIN
    BEGIN TRY
        UPDATE FACTURACION
        SET
            FECHA = @Fecha,
			HORA = @Hora,
            TOTAL_FACTURA = @TotalFactura
        WHERE ID_FACTURA = @IDFactura;
        SET @Mensaje = 'Actualización exitosa';
    END TRY
    BEGIN CATCH
        SET @Mensaje = 'Error al actualizar la factura. Detalle: ' + ERROR_MESSAGE();
    END CATCH
END;
GO


CREATE OR ALTER PROCEDURE EliminarFactura (
    @IDFactura INT,
    @Mensaje VARCHAR(255) OUTPUT
)
AS
BEGIN
    BEGIN TRY
        DELETE FROM FACTURACION WHERE ID_FACTURA = @IDFactura;
        SET @Mensaje = 'Eliminación exitosa';
    END TRY
    BEGIN CATCH
        SET @Mensaje = 'Error al eliminar la factura. Detalle: ' + ERROR_MESSAGE();
    END CATCH
END;
GO

-----------------------------------------------DETALLES_TRANSACCION----------------------------------------------------
-----------------------------------------------DETALLES_TRANSACCION----------------------------------------------------
-----------------------------------------------DETALLES_TRANSACCION----------------------------------------------------


CREATE OR ALTER PROCEDURE InsertarDetalleTransaccion (
    @IDCliente INT,
    @IDFactura INT,
    @IDPedido INT,
    @IDEmpelado INT,
    @Mensaje VARCHAR(255) OUTPUT
)
AS
BEGIN
    BEGIN TRY
        INSERT INTO DETALLES_TRANSACCION (ID_CLIENTE, ID_FACTURA, ID_PEDIDO, ID_EMPLEADO)
        VALUES (@IDCliente, @IDFactura, @IDPedido, @IDEmpelado);
        SET @Mensaje = 'Inserción exitosa';
    END TRY
    BEGIN CATCH
        SET @Mensaje = 'Error al insertar el detalle de la transacción. Detalle: ' + ERROR_MESSAGE();
    END CATCH
END;
GO



CREATE OR ALTER PROCEDURE ObtenerDetalleTransaccionPorID (
    @IDDetalleTransaccion INT,
    @Mensaje VARCHAR(255) OUTPUT
)
AS
BEGIN
    BEGIN TRY
        SELECT * FROM DETALLES_TRANSACCION WHERE ID_DETALLE_PEDIDO = @IDDetalleTransaccion;
        SET @Mensaje = 'Consulta exitosa';
    END TRY
    BEGIN CATCH
        SET @Mensaje = 'Error al obtener el detalle de transacción. Detalle: ' + ERROR_MESSAGE();
    END CATCH
END;
GO


CREATE OR ALTER PROCEDURE ActualizarDetalleTransaccion (
    @IDDetalleTransaccion INT,
    @IDCliente INT,
    @IDFactura INT,
    @IDPedido INT,
    @IDEmpelado INT,
    @Mensaje VARCHAR(255) OUTPUT
)
AS
BEGIN
    BEGIN TRY
        UPDATE DETALLES_TRANSACCION
        SET
            ID_CLIENTE = @IDCliente,
            ID_FACTURA = @IDFactura,
            ID_PEDIDO = @IDPedido,
            ID_EMPLEADO = @IDEmpelado
        WHERE ID_DETALLE_PEDIDO = @IDDetalleTransaccion;
        SET @Mensaje = 'Actualización exitosa';
    END TRY
    BEGIN CATCH
        SET @Mensaje = 'Error al actualizar el detalle de transacción. Detalle: ' + ERROR_MESSAGE();
    END CATCH
END;
GO


CREATE OR ALTER PROCEDURE EliminarDetalleTransaccion (
    @IDDetalleTransaccion INT,
    @Mensaje VARCHAR(255) OUTPUT
)
AS
BEGIN
    BEGIN TRY
        DELETE FROM DETALLES_TRANSACCION WHERE ID_DETALLE_PEDIDO = @IDDetalleTransaccion;
        SET @Mensaje = 'Eliminación exitosa';
    END TRY
    BEGIN CATCH
        SET @Mensaje = 'Error al eliminar el detalle de transacción. Detalle: ' + ERROR_MESSAGE();
    END CATCH
END;
GO

-----------------------------------------------PAGOS----------------------------------------------------
-----------------------------------------------PAGOS----------------------------------------------------
-----------------------------------------------PAGOS----------------------------------------------------


CREATE OR ALTER PROCEDURE InsertarPago (
    @IDFactura INT,
    @MetodoPago VARCHAR(255),
    @Fecha DATE,
	@Hora TIME,
    @EstadoPago VARCHAR(255),
    @Mensaje VARCHAR(255) OUTPUT
)
AS
BEGIN
    BEGIN TRY
        INSERT INTO PAGOS (ID_FACTURA, METODO_PAGO, FECHA, HORA, ESTADO_PAGO)
        VALUES (@IDFactura, @MetodoPago, @Fecha, @Hora, @EstadoPago);
        SET @Mensaje = 'Inserción exitosa';
    END TRY
    BEGIN CATCH
        SET @Mensaje = 'Error al insertar el pago. Detalle: ' + ERROR_MESSAGE();
    END CATCH
END;
GO



CREATE OR ALTER PROCEDURE ObtenerPagoPorID (
    @IDPago INT,
    @Mensaje VARCHAR(255) OUTPUT
)
AS
BEGIN
    BEGIN TRY
        SELECT * FROM PAGOS WHERE ID_PAGO = @IDPago;
        SET @Mensaje = 'Consulta exitosa';
    END TRY
    BEGIN CATCH
        SET @Mensaje = 'Error al obtener el pago. Detalle: ' + ERROR_MESSAGE();
    END CATCH
END;
GO


CREATE OR ALTER PROCEDURE ActualizarPago (
    @IDPago INT,
    @IDFactura INT,
    @MetodoPago VARCHAR(255),
    @Fecha DATE,
	@Hora TIME,
    @EstadoPago VARCHAR(255),
    @Mensaje VARCHAR(255) OUTPUT
)
AS
BEGIN
    BEGIN TRY
        UPDATE PAGOS
        SET
            ID_FACTURA = @IDFactura,
            METODO_PAGO = @MetodoPago,
            FECHA = @Fecha,
			HORA = @Hora,
            ESTADO_PAGO = @EstadoPago
        WHERE ID_PAGO = @IDPago;
        SET @Mensaje = 'Actualización exitosa';
    END TRY
    BEGIN CATCH
        SET @Mensaje = 'Error al actualizar el pago. Detalle: ' + ERROR_MESSAGE();
    END CATCH
END;
GO


CREATE OR ALTER PROCEDURE EliminarPago (
    @IDPago INT,
    @Mensaje VARCHAR(255) OUTPUT
)
AS
BEGIN
    BEGIN TRY
        DELETE FROM PAGOS WHERE ID_PAGO = @IDPago;
        SET @Mensaje = 'Eliminación exitosa';
    END TRY
    BEGIN CATCH
        SET @Mensaje = 'Error al eliminar el pago. Detalle: ' + ERROR_MESSAGE();
    END CATCH
END;
GO

--MONTO DE FACTURAS POR DIA
CREATE OR ALTER PROCEDURE ObtenerTotalFacturasPorDia
AS
BEGIN
    DECLARE @Mensaje VARCHAR(255);
    
    SELECT 
        CAST(FECHA AS DATE) AS Dia,
        SUM(TOTAL_FACTURA) AS TotalPorDia
    FROM FACTURACION
    GROUP BY CAST(FECHA AS DATE)
    ORDER BY Dia;

    SET @Mensaje = 'Consulta exitosa';
    PRINT @Mensaje;  -- Imprimir el mensaje de salida
END;
GO

--CANTIDAD DE PRODUCTOS VENDIDOS POR DIA
CREATE OR ALTER PROCEDURE ObtenerCantidadProductosVendidosPorDia
AS
BEGIN
    DECLARE @Mensaje VARCHAR(255);

    SELECT 
        CAST(F.FECHA AS DATE) AS Dia,
        SUM(P.CANTIDAD) AS CantidadProductosVendidos
    FROM FACTURACION F
    INNER JOIN DETALLES_TRANSACCION DT ON F.ID_FACTURA = DT.ID_FACTURA
    INNER JOIN PEDIDOS P ON DT.ID_PEDIDO = P.ID_PEDIDO
    GROUP BY CAST(F.FECHA AS DATE)
    ORDER BY Dia;

    SET @Mensaje = 'Consulta exitosa';
    PRINT @Mensaje;  -- Imprimir el mensaje de salida
END;
GO

--CANTIDAD DE VENTAS POR DIA
CREATE OR ALTER PROCEDURE ObtenerCantidadVentasPorDia
AS
BEGIN
    DECLARE @Mensaje VARCHAR(255);

    SELECT 
        CAST(FECHA AS DATE) AS Dia,
        COUNT(*) AS CantidadVentas
    FROM FACTURACION F
    GROUP BY CAST(F.FECHA AS DATE)
    ORDER BY Dia;

    SET @Mensaje = 'Consulta exitosa';
    PRINT @Mensaje;  -- Imprimir el mensaje de salida
END;
GO