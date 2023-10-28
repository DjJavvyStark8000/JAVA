/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layer3_DataAccess;

import Config.Configuration;
import Layer4_Entities.Ent_Empleado;
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
public class DA_Empleado {
    //Atributos................................................................
    //Atributos................................................................
    //Atributos................................................................

    private Connection _cnn;
    private String _message;
    //Constructor..............................................................
    //Constructor..............................................................
    //Constructor..............................................................

    public DA_Empleado() throws Exception {
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

    //Insertar un empleado
    public int InsertarEmpleado(Ent_Empleado empleado) throws Exception {
        int id_empleado = -1;
        String sentence = "INSERT INTO EMPLEADOS(NOMBRE_EMPLEADO, DIRECCION, NUMERO_TELEFONO, CORREO_ELECTRONICO, ID_CARGO) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentence, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getDireccion());
            ps.setString(3, empleado.getTelefono());
            ps.setString(4, empleado.getCorreo());
            ps.setInt(5, empleado.getId_cargo());

            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                id_empleado = rs.getInt(1);
                _message = "Empleado ingresado con éxito";
            }
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }
        return id_empleado;
    }

    // Listar empleados
    public List<Ent_Empleado> ListarEmpleados(String condicion) throws SQLException {
        List<Ent_Empleado> lista = new ArrayList<>();
        ResultSet rs = null;
        String sentencia = "SELECT ID_EMPLEADO, NOMBRE_EMPLEADO, DIRECCION, NUMERO_TELEFONO, CORREO_ELECTRONICO, ID_CARGO FROM EMPLEADOS";
        if (!condicion.isEmpty()) {
            sentencia += " WHERE " + condicion;
        }
        try (Statement stm = _cnn.createStatement()) {
            rs = stm.executeQuery(sentencia);
            while (rs.next()) {
                lista.add(new Ent_Empleado(
                        rs.getInt("ID_EMPLEADO"),
                        rs.getString("NOMBRE_EMPLEADO"),
                        rs.getString("DIRECCION"),
                        rs.getString("NUMERO_TELEFONO"),
                        rs.getString("CORREO_ELECTRONICO"),
                        rs.getInt("ID_CARGO")
                ));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            // No establezcas _cnn a null en el bloque "finally" ya que necesitas la conexión para otros métodos.
            // _cnn = null;
            if (rs != null) {
                rs.close();
            }
        }
        return lista;
    }

// Obtener un empleado
    public Ent_Empleado ObtenerEmpleado(String condicion) throws SQLException {
        Ent_Empleado empleado = null; // Cambiado a null en lugar de un objeto vacío.
        ResultSet rs = null;
        String sentencia = "SELECT ID_EMPLEADO, NOMBRE_EMPLEADO, DIRECCION, NUMERO_TELEFONO, CORREO_ELECTRONICO, ID_CARGO FROM EMPLEADOS";
        if (!condicion.isEmpty()) {
            sentencia += " WHERE " + condicion;
        }
        try (Statement stm = _cnn.createStatement()) {
            rs = stm.executeQuery(sentencia);
            if (rs.next()) {
                empleado = new Ent_Empleado();
                empleado.setIdEmpleado(rs.getInt("ID_EMPLEADO"));
                empleado.setNombre(rs.getString("NOMBRE_EMPLEADO"));
                empleado.setDireccion(rs.getString("DIRECCION"));
                empleado.setTelefono(rs.getString("NUMERO_TELEFONO"));
                empleado.setCorreo(rs.getString("CORREO_ELECTRONICO"));
                empleado.setId_cargo(rs.getInt("ID_CARGO"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        return empleado;
    }

// Modificar empleado
    public int ModificarEmpleado(Ent_Empleado empleado) throws SQLException {
        int resultado = 0;
        String sentencia = "UPDATE EMPLEADOS SET NOMBRE_EMPLEADO = ?, DIRECCION = ?, NUMERO_TELEFONO = ?, CORREO_ELECTRONICO = ?, ID_CARGO = ? WHERE ID_EMPLEADO = ?";
        try (PreparedStatement ps = _cnn.prepareStatement(sentencia)) {
            ps.setString(1, empleado.getNombre()); 
            ps.setString(2, empleado.getDireccion());
            ps.setString(3, empleado.getTelefono());
            ps.setString(4, empleado.getCorreo());
            ps.setInt(5, empleado.getId_cargo());
            ps.setInt(6,empleado.getIdEmpleado());
            resultado = ps.executeUpdate();
            if (resultado > 0) {
                _message = "Registro modificado con éxito";
            }
        } catch (SQLException e) {
            throw e;
        }
        return resultado;
    }

// Eliminar empleado
    public int EliminarEmpleado(Ent_Empleado empleado) throws SQLException {
        int resultado = 0;
        String sentencia = "DELETE FROM EMPLEADOS WHERE ID_EMPLEADO = ?";
        try (PreparedStatement ps = _cnn.prepareStatement(sentencia)) {
            ps.setInt(1, empleado.getIdEmpleado());
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
