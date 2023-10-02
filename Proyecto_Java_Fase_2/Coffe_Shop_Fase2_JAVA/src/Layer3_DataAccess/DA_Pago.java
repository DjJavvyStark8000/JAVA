/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layer3_DataAccess;

import Config.Configuration;
import Layer4_Entities.Ent_Pago;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author djjav
 */
public class DA_Pago {
    //Atributos................................................................
    //Atributos................................................................
    //Atributos................................................................

    private Connection _cnn;
    private String _message;
    //Constructor..............................................................
    //Constructor..............................................................
    //Constructor..............................................................

    public DA_Pago() throws Exception {
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

    //insertar
    public int InsertarPago(Ent_Pago pago) throws Exception {
        int id_pago = -1;
        String sentence = "INSERT INTO PAGOS(ID_PAGO, ID_ENCABEZADO_FACTURA, METODO_PAGO, HORA,ESTADO_PAGO) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentence, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pago.getId_pago());
            ps.setInt(2, pago.getId_encabezado());
            ps.setString(3, pago.getMetodo_pago());
            ps.setString(4, pago.getHora());
            ps.setString(5, pago.getEstado_pago());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                id_pago = rs.getInt(1);
                _message = "Pago ingresado con éxito";
            }
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }
        return id_pago;
    }

    // Listar un pago
    public List<Ent_Pago> ListarPagos(String condicion) throws SQLException {
        ResultSet rs = null;
        List<Ent_Pago> lista = new ArrayList<>();
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID_PAGO, ID_ENCABEZADO_FACTURA, METODO_PAGO, HORA,ESTADO_PAGO FROM PAGOS";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);

            while (rs.next()) {
                lista.add(new Ent_Pago(
                        rs.getInt("ID_PAGO"),
                        rs.getInt("ID_ENCABEZADO_FACTURA"),
                        rs.getString("METODO_PAGO"),
                        rs.getString("HORA"),
                        rs.getString("ESTADO_PAGO")
                ));
            }
        } catch (Exception e) {
            // Handle or log the exception appropriately
            throw e;
        } finally {
            _cnn = null;
        }
        return lista;
    }

    public Ent_Pago ObtenerPago(String condicion) throws SQLException {
        Ent_Pago pago = new Ent_Pago();
        ResultSet rs = null;
        String sentencia = "SELECT ID_PAGO, ID_ENCABEZADO_FACTURA, METODO_PAGO, HORA, ESTADO_PAGO FROM PAGOS";
        if (!condicion.isEmpty()) {
            sentencia += " WHERE " + condicion;
        }
        try (Statement stm = _cnn.createStatement()) {
            rs = stm.executeQuery(sentencia);
            if (rs.next()) {
                pago.setId_pago(rs.getInt("ID_PAGO"));
                pago.setId_encabezado(rs.getInt("ID_ENCABEZADO_FACTURA"));
                pago.setMetodo_pago(rs.getString("METODO_PAGO"));
                pago.setHora(rs.getString("HORA"));
                pago.setEstado_pago(rs.getString("ESTADO_PAGO"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            _cnn = null;
        }
        return pago;
    }

    public int ModificarPago(Ent_Pago pago) throws SQLException {
        int resultado = 0;
        String sentencia = "UPDATE PAGOS SET ID_ENCABEZADO_FACTURA = ?, METODO_PAGO = ?, HORA = ?, ESTADO_PAGO = ? WHERE ID_PAGO = ?";
        try (PreparedStatement ps = _cnn.prepareStatement(sentencia)) {
            ps.setInt(1, pago.getId_encabezado());
            ps.setString(2, pago.getMetodo_pago());
            ps.setObject(3, pago.getHora());
            ps.setString(5, pago.getEstado_pago());
            ps.setInt(6, pago.getId_pago());
            resultado = ps.executeUpdate();
            if (resultado > 0) {
                _message = "Registro modificado con éxito";
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            _cnn = null;
        }
        return resultado;
    }

    public int EliminarPago(Ent_Pago pago) throws SQLException {
        int resultado = 0;
        String sentencia = "DELETE FROM PAGOS WHERE ID_PAGO = ?";
        try (PreparedStatement ps = _cnn.prepareStatement(sentencia)) {
            ps.setInt(1, pago.getId_pago());
            resultado = ps.executeUpdate();
            if (resultado > 0) {
                _message = "Registro eliminado con éxito";
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            _cnn = null;
        }
        return resultado;
    }
}
