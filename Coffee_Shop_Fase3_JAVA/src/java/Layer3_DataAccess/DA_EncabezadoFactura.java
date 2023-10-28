/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layer3_DataAccess;

import Config.Configuration;
import Layer4_Entities.Ent_EncabezadoFactura;
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
public class DA_EncabezadoFactura {
    //Atributos................................................................
    //Atributos................................................................
    //Atributos................................................................

    private Connection _cnn;
    private String _message;
    //Constructor..............................................................
    //Constructor..............................................................
    //Constructor..............................................................

    public DA_EncabezadoFactura() throws Exception {
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

    public int InsertarEncabezadoFactura(Ent_EncabezadoFactura encabezadoFactura) throws SQLException {
        int id_encabezadoFactura = -1;
        String sentence = "INSERT INTO ENCABEZADO_FACTURA(ID_CLIENTE, FECHA, IMPUESTO, DESCUENTO, TOTAL) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = _cnn.prepareStatement(sentence, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, encabezadoFactura.getId_cliente());
            ps.setDate(2, java.sql.Date.valueOf(encabezadoFactura.getFecha()));
            ps.setBigDecimal(3, encabezadoFactura.getImpuesto());
            ps.setBigDecimal(4, encabezadoFactura.getDescuento());
            ps.setBigDecimal(5, encabezadoFactura.getTotal());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                id_encabezadoFactura = rs.getInt(1);
                _message = "EncabezadoFactura ingresado con éxito";
            }
        } catch (SQLException e) {
            throw e;
        }
        return id_encabezadoFactura;
    }

    public List<Ent_EncabezadoFactura> ListarEncabezadoFacturas(String condicion) throws SQLException {
        ResultSet rs = null;
        List<Ent_EncabezadoFactura> lista = new ArrayList<>();
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID_FACTURA, ID_CLIENTE, FECHA, IMPUESTO, DESCUENTO, TOTAL FROM ENCABEZADO_FACTURA";
            if (!condicion.isEmpty()) {
                sentencia += " WHERE " + condicion;
            }
            rs = stm.executeQuery(sentencia);

            while (rs.next()) {
                lista.add(new Ent_EncabezadoFactura(
                        rs.getInt("ID_FACTURA"),
                        rs.getInt("ID_CLIENTE"),
                        rs.getString("FECHA"),
                        rs.getBigDecimal("IMPUESTO"),
                        rs.getBigDecimal("DESCUENTO"),
                        rs.getBigDecimal("TOTAL")
                ));
            }
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }

    public Ent_EncabezadoFactura ObtenerEncabezadoFactura(String condicion) throws SQLException {
        Ent_EncabezadoFactura encabezadofactura = new Ent_EncabezadoFactura();
        ResultSet rs = null;
        String sentencia = "SELECT ID_FACTURA, ID_CLIENTE, FECHA, IMPUESTO, DESCUENTO, TOTAL FROM ENCABEZADO_FACTURA";
        if (!condicion.isEmpty()) {
            sentencia += " WHERE " + condicion;
        }
        try (Statement stm = _cnn.createStatement()) {
            rs = stm.executeQuery(sentencia);
            if (rs.next()) {
                encabezadofactura.setId_encabezado(rs.getInt("ID_FACTURA"));
                encabezadofactura.setId_cliente(rs.getInt("ID_CLIENTE"));
                encabezadofactura.setFecha(rs.getString("FECHA"));
                encabezadofactura.setImpuesto(rs.getBigDecimal("IMPUESTO"));
                encabezadofactura.setDescuento(rs.getBigDecimal("DESCUENTO"));
                encabezadofactura.setTotal(rs.getBigDecimal("TOTAL"));

            }
        } catch (SQLException e) {
            throw e;
        } finally {
            _cnn = null;
        }
        return encabezadofactura;
    }

    public int ModificarEncabezadoFactura(Ent_EncabezadoFactura encabezadoFactura) throws SQLException {
        int resultado = 0;
        String sentencia = "UPDATE ENCABEZADO_FACTURA SET ID_CLIENTE = ?, FECHA = ?, IMPUESTO = ?, DESCUENTO = ?, TOTAL = ? WHERE ID_FACTURA = ?";
        try (PreparedStatement ps = _cnn.prepareStatement(sentencia)) {
            ps.setInt(1, encabezadoFactura.getId_cliente());
            ps.setDate(2, java.sql.Date.valueOf(encabezadoFactura.getFecha()));
            ps.setBigDecimal(3, encabezadoFactura.getImpuesto());
            ps.setBigDecimal(4, encabezadoFactura.getDescuento());
            ps.setBigDecimal(5, encabezadoFactura.getTotal());
            ps.setInt(6, encabezadoFactura.getId_encabezado());
            resultado = ps.executeUpdate();
            if (resultado > 0) {
                _message = "Registro modificado con éxito";
            }
        } catch (SQLException e) {
            throw e;
        }
        return resultado;
    }

    public int EliminarEncabezadoFactura(int idFactura) throws SQLException {
        int resultado = 0;
        String sentencia = "DELETE FROM ENCABEZADO_FACTURA WHERE ID_FACTURA = ?";
        try (PreparedStatement ps = _cnn.prepareStatement(sentencia)) {
            ps.setInt(1, idFactura);
            resultado = ps.executeUpdate();
            if (resultado > 0) {
                _message = "Registro eliminado con éxito";
            }
        } catch (SQLException e) {
            throw e;
        }
        return resultado;
    }

    //listar factura y cliente
    public List<Ent_EncabezadoFactura> ListarClienteEncabezado(String condicion) throws SQLException {
        ResultSet rs = null;
        List<Ent_EncabezadoFactura> lista = new ArrayList<>();
        try {
            Statement stm = _cnn.createStatement();

            String sentencia = "SELECT EF.ID_FACTURA,NOMBRE_CLIENTE,EF.ID_CLIENTE,FECHA,IMPUESTO,DESCUENTO,TOTAL FROM ENCABEZADO_FACTURA EF INNER JOIN CLIENTES C ON EF.ID_CLIENTE = C.ID_CLIENTE";
            if (!condicion.isEmpty()) {
                sentencia += " WHERE " + condicion;
            }
            rs = stm.executeQuery(sentencia);

            while (rs.next()) {
                lista.add(new Ent_EncabezadoFactura(
                        rs.getInt("ID_FACTURA"),
                        rs.getString("NOMBRE_CLIENTE"),
                        rs.getInt("ID_CLIENTE"),
                        rs.getString("FECHA"),
                        rs.getBigDecimal("IMPUESTO"),
                        rs.getBigDecimal("DESCUENTO"),
                        rs.getBigDecimal("TOTAL")
                ));
            }
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }
}
