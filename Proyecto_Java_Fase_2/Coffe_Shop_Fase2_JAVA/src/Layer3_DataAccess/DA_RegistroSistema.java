/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layer3_DataAccess;

import Config.Configuration;
import Layer4_Entities.Ent_RegistroSistema;
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
public class DA_RegistroSistema {
    //Atributos................................................................
    //Atributos................................................................
    //Atributos................................................................

    private Connection _cnn;
    private String _message;
    //Constructor..............................................................
    //Constructor..............................................................
    //Constructor..............................................................

    public DA_RegistroSistema() throws Exception {
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

    //Insertar un registrosistema
    public int InsertarRegistroSistema(Ent_RegistroSistema registrosistema) throws Exception {
        int id_registrosistema = -1;
        String sentence = "INSERT INTO REGISTRO_SISTEMA(ID_REGISTRO_SISTEMA, ID_CLIENTE, ID_ENCABEZADO_FACTURA, ID_EMPLEADO) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentence, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, registrosistema.getId_registro());
            ps.setInt(2, registrosistema.getId_cliente());
            ps.setInt(3, registrosistema.getId_encabezado());
            ps.setInt(4, registrosistema.getId_empleado());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                id_registrosistema = rs.getInt(1);
                _message = "RegistroSistema ingresado con éxito";
            }
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }
        return id_registrosistema;
    }

    // Listar un registrosistema
    public List<Ent_RegistroSistema> ListarRegistroSistemas(String condicion) throws SQLException {
        ResultSet rs = null;
        List<Ent_RegistroSistema> lista = new ArrayList<>();
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID_REGISTRO_SISTEMA, ID_CLIENTE, ID_ENCABEZADO_FACTURA, ID_EMPLEADO FROM REGISTRO_SISTEMA";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);

            while (rs.next()) {
                lista.add(new Ent_RegistroSistema(
                        rs.getInt("ID_REGISTRO_SISTEMA"),
                        rs.getInt("ID_CLIENTE"),
                        rs.getInt("ID_ENCABEZADO_FACTURA"),
                        rs.getInt("ID_EMPLEADO")
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

    public Ent_RegistroSistema ObtenerRegistroSistema(String condicion) throws SQLException {
        Ent_RegistroSistema registrosistema = new Ent_RegistroSistema();
        ResultSet rs = null;
        String sentencia = "SELECT ID_REGISTRO_SISTEMA, ID_CLIENTE, ID_ENCABEZADO_FACTURA, ID_EMPLEADO FROM REGISTRO_SISTEMA";
        if (!condicion.isEmpty()) {
            sentencia += " WHERE " + condicion;
        }
        try (Statement stm = _cnn.createStatement()) {
            rs = stm.executeQuery(sentencia);
            if (rs.next()) {
                registrosistema.setId_registro(rs.getInt("ID_REGISTRO_SISTEMA"));
                registrosistema.setId_cliente(rs.getInt("ID_CLIENTE"));
                registrosistema.setId_encabezado(rs.getInt("ID_ENCABEZADO_FACTURA"));
                registrosistema.setId_empleado(rs.getInt("ID_EMPLEADO"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            _cnn = null;
        }
        return registrosistema;
    }

    public int ModificarRegistroSistema(Ent_RegistroSistema registrosistema) throws SQLException {
        int resultado = 0;
        String sentencia = "UPDATE REGISTRO_SISTEMA SET ID_REGISTRO_SISTEMA, ID_CLIENTE, ID_ENCABEZADO_FACTURA, ID_EMPLEADO WHERE ID_REGISTRO_SISTEMA = ?";
        try (PreparedStatement ps = _cnn.prepareStatement(sentencia)) {
            ps.setInt(1, registrosistema.getId_registro());
            ps.setInt(2, registrosistema.getId_cliente());
            ps.setInt(3, registrosistema.getId_encabezado());
            ps.setInt(4, registrosistema.getId_empleado());
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

    public int EliminarRegistroSistema(Ent_RegistroSistema registrosistema) throws SQLException {
        int resultado = 0;
        String sentencia = "DELETE FROM REGISTRO_SISTEMA WHERE ID_REGISTRO_SISTEMA = ?";
        try (PreparedStatement ps = _cnn.prepareStatement(sentencia)) {
            ps.setInt(1, registrosistema.getId_registro());
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
