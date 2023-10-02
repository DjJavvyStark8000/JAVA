/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layer3_DataAccess;

import Config.Configuration;
import Layer4_Entities.Ent_Cliente;
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
public class DA_Cliente {
    //Atributos................................................................
    //Atributos................................................................
    //Atributos................................................................

    private Connection _cnn;
    private String _message;
    //Constructor..............................................................
    //Constructor..............................................................
    //Constructor..............................................................

    public DA_Cliente() throws Exception {
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

    //Insertar un cliente
    public int InsertarCliente(Ent_Cliente cliente) throws Exception {
        int id_cliente = -1;
        String sentence = "INSERT INTO CLIENTES(NOMBRE_CLIENTE, DIRECCION, NUMERO_TELEFONO, CORREO_ELECTRONICO) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentence, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDireccion());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getCorreo());

            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                id_cliente = rs.getInt(1);
                _message = "Cliente ingresado con éxito";
            }
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }
        return id_cliente;
    }

    // Listar clientes
    public List<Ent_Cliente> ListarClientes(String condicion) throws SQLException {
        List<Ent_Cliente> lista = new ArrayList<>();
        ResultSet rs = null;
        String sentencia = "SELECT ID_CLIENTE, NOMBRE_CLIENTE, DIRECCION, NUMERO_TELEFONO, CORREO_ELECTRONICO FROM CLIENTES";
        if (!condicion.isEmpty()) {
            sentencia += " WHERE " + condicion;
        }
        try (Statement stm = _cnn.createStatement()) {
            rs = stm.executeQuery(sentencia);
            while (rs.next()) {
                lista.add(new Ent_Cliente(
                        rs.getInt("ID_CLIENTE"),
                        rs.getString("NOMBRE_CLIENTE"),
                        rs.getString("DIRECCION"),
                        rs.getString("NUMERO_TELEFONO"),
                        rs.getString("CORREO_ELECTRONICO")
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

// Obtener un cliente
    public Ent_Cliente ObtenerCliente(String condicion) throws SQLException {
        Ent_Cliente cliente = null; // Cambiado a null en lugar de un objeto vacío.
        ResultSet rs = null;
        String sentencia = "SELECT ID_CLIENTE, NOMBRE_CLIENTE, DIRECCION, NUMERO_TELEFONO, CORREO_ELECTRONICO FROM CLIENTES";
        if (!condicion.isEmpty()) {
            sentencia += " WHERE " + condicion;
        }
        try (Statement stm = _cnn.createStatement()) {
            rs = stm.executeQuery(sentencia);
            if (rs.next()) {
                cliente = new Ent_Cliente();
                cliente.setIdCliente(rs.getInt("ID_CLIENTE"));
                cliente.setNombre(rs.getString("NOMBRE_CLIENTE"));
                cliente.setDireccion(rs.getString("DIRECCION"));
                cliente.setTelefono(rs.getString("NUMERO_TELEFONO"));
                cliente.setCorreo(rs.getString("CORREO_ELECTRONICO"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        return cliente;
    }

// Modificar cliente
    public int ModificarCliente(Ent_Cliente cliente) throws SQLException {
        int resultado = 0;
        String sentencia = "UPDATE CLIENTES SET NOMBRE_CLIENTE = ?, DIRECCION = ?, NUMERO_TELEFONO = ?, CORREO_ELECTRONICO = ? WHERE ID_CLIENTE = ?";
        try (PreparedStatement ps = _cnn.prepareStatement(sentencia)) {
            ps.setString(1, cliente.getNombre()); // Corregido el índice de los parámetros.
            ps.setString(2, cliente.getDireccion());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getCorreo());
            resultado = ps.executeUpdate();
            if (resultado > 0) {
                _message = "Registro modificado con éxito";
            }
        } catch (SQLException e) {
            throw e;
        }
        return resultado;
    }

// Eliminar cliente
    public int EliminarCliente(Ent_Cliente cliente) throws SQLException {
        int resultado = 0;
        String sentencia = "DELETE FROM CLIENTES WHERE ID_CLIENTE = ?";
        try (PreparedStatement ps = _cnn.prepareStatement(sentencia)) {
            ps.setInt(1, cliente.getIdCliente());
            resultado = ps.executeUpdate();
            if (resultado > 0) {
                _message = "Registro eliminado con éxito";
            }
        } catch (SQLException e) {
            throw e;
        }
        return resultado;
    }

    //si un correo existe o no en la base de datos
    public boolean clientEmailExists(String givenEmail) throws Exception {
        boolean exists = false;
        String query = "SELECT 1 FROM CLIENTES WHERE CORREO_ELECTRONICO = ?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(query);
            ps.setString(1, givenEmail);
            ResultSet rs = ps.executeQuery();
            exists = rs.next(); // Check if a result exists for the given email
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }
        return exists;
    }

    public int grabClientIDByEmail(String givenEmail) throws SQLException {
        int id = -1;
        String query = "SELECT ID_CLIENTE FROM CLIENTES WHERE CORREO_ELECTRONICO = ?";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = _cnn.prepareStatement(query);
            ps.setString(1, givenEmail);
            rs = ps.executeQuery();

            if (rs.next()) {
                id = rs.getInt("ID_CLIENTE");
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            // Don't set _cnn to null here; manage your database connection properly.
        }

        return id;
    }
}
