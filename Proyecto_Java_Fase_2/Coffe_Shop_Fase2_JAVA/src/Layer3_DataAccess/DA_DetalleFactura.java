/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layer3_DataAccess;

import Config.Configuration;
import Layer4_Entities.Ent_DetalleFactura;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author djjav
 */
public class DA_DetalleFactura {
  //Atributos................................................................
    //Atributos................................................................
    //Atributos................................................................

    private Connection _cnn;
    private String _message;
    //Constructor..............................................................
    //Constructor..............................................................
    //Constructor..............................................................

    public DA_DetalleFactura() throws Exception {
        try {
            String theurl = Configuration.getConnection();
            _cnn = DriverManager.getConnection(theurl);
            _message = "";
        } catch (Exception e) {
        }
    }
    //Get/.....................................................................
    //Get/.....................................................................
    //Get/.....................................................................
    public String getMessage() {
        return _message;
    }
    //Métodos..................................................................
    //Métodos..................................................................
    //Métodos..................................................................
    
   // Insertar un detalle_factura
public int InsertarDetalleFactura(Ent_DetalleFactura detalle_factura) throws Exception {
    int id_detalle_factura = -1;
    String sentence = "INSERT INTO DETALLE_FACTURA (ID_FACTURA, ID_PRODUCTO, CANTIDAD, SUB_TOTAL) VALUES (?, ?, ?, ?)";
    try {
        PreparedStatement ps = _cnn.prepareStatement(sentence, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, detalle_factura.getId_detalle());
        ps.setInt(2, detalle_factura.getId_producto());
        ps.setInt(3, detalle_factura.getCantidad());
        ps.setBigDecimal(4, detalle_factura.getSubtotal());

        ps.execute();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs != null && rs.next()) {
            id_detalle_factura = rs.getInt(1);
            _message = "DetalleFactura ingresado con éxito";
        }
    } catch (Exception e) {
        throw e;
    } finally {
        _cnn = null;
    }
    return id_detalle_factura;
}

// Listar detalle_facturas
public List<Ent_DetalleFactura> ListarDetalleFacturas(String condicion) throws SQLException {
    List<Ent_DetalleFactura> lista = new ArrayList<>();
    ResultSet rs = null;
    String sentencia = "SELECT ID_FACTURA, ID_PRODUCTO, CANTIDAD, SUB_TOTAL FROM DETALLE_FACTURA";
    if (!condicion.isEmpty()) {
        sentencia += " WHERE " + condicion;
    }
    try (Statement stm = _cnn.createStatement()) {
        rs = stm.executeQuery(sentencia);
        while (rs.next()) {
            lista.add(new Ent_DetalleFactura(
                    rs.getInt("ID_FACTURA"),
                    rs.getInt("ID_PRODUCTO"),
                    rs.getInt("CANTIDAD"),
                    rs.getBigDecimal("SUB_TOTAL")
            ));
        }
    } catch (SQLException e) {
        throw e;
    } finally {
        if (rs != null) {
            rs.close();
        }
    }
    return lista;
}

// Obtener un detalle_factura
public Ent_DetalleFactura ObtenerDetalleFactura(String condicion) throws SQLException {
    Ent_DetalleFactura detalle_factura = null;
    ResultSet rs = null;
    String sentencia = "SELECT ID_FACTURA, ID_PRODUCTO, CANTIDAD, SUB_TOTAL FROM DETALLE_FACTURA";
    if (!condicion.isEmpty()) {
        sentencia += " WHERE " + condicion;
    }
    try (Statement stm = _cnn.createStatement()) {
        rs = stm.executeQuery(sentencia);
        if (rs.next()) {
            detalle_factura = new Ent_DetalleFactura(
                rs.getInt("ID_FACTURA"),
                rs.getInt("ID_PRODUCTO"),
                rs.getInt("CANTIDAD"),
                rs.getBigDecimal("SUB_TOTAL")
            );
        }
    } catch (SQLException e) {
        throw e;
    } finally {
        if (rs != null) {
            rs.close();
        }
    }
    return detalle_factura;
}

// Modificar detalle_factura
public int ModificarDetalleFactura(Ent_DetalleFactura detalle_factura) throws SQLException {
    int resultado = 0;
    String sentencia = "UPDATE DETALLE_FACTURA SET ID_PRODUCTO = ?, CANTIDAD = ?, SUB_TOTAL = ? WHERE ID_FACTURA = ?";
    try (PreparedStatement ps = _cnn.prepareStatement(sentencia)) {
        ps.setInt(1, detalle_factura.getId_producto());
        ps.setInt(2, detalle_factura.getCantidad());
        ps.setBigDecimal(3, detalle_factura.getSubtotal());
        ps.setInt(4, detalle_factura.getId_detalle());

        resultado = ps.executeUpdate();
        if (resultado > 0) {
            _message = "Registro modificado con éxito";
        }
    } catch (SQLException e) {
        throw e;
    }
    return resultado;
}

// Eliminar detalle_factura
public int EliminarDetalleFactura(Ent_DetalleFactura detalle_factura) throws SQLException {
    int resultado = 0;
    String sentencia = "DELETE FROM DETALLE_FACTURA WHERE ID_FACTURA = ?";
    try (PreparedStatement ps = _cnn.prepareStatement(sentencia)) {
        ps.setInt(1, detalle_factura.getId_detalle());
        resultado = ps.executeUpdate();
        if (resultado > 0) {
            _message = "Registro eliminado con éxito";
        }
    } catch (SQLException e) {
        throw e;
    }
    return resultado;
}
}
