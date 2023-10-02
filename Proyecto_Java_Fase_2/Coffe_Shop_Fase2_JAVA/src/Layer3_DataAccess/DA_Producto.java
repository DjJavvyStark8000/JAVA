/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layer3_DataAccess;

import Config.Configuration;
import Layer4_Entities.Ent_Producto;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author djjav
 */
public class DA_Producto {
    //Atributos................................................................
    //Atributos................................................................
    //Atributos................................................................

    private Connection _cnn;
    private String _message;
    //Constructor..............................................................
    //Constructor..............................................................
    //Constructor..............................................................

    public DA_Producto() throws Exception {
        try {
            String theurl = Configuration.getConnection();
            _cnn = DriverManager.getConnection(theurl);
            _message = "";
        } catch (Exception e) {
            throw e;
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

    //Insertar un producto
    public int InsertarProducto(Ent_Producto producto) throws Exception {
        int id_producto = -1;
        String sentence = "INSERT INTO PRODUCTOS(ID_PRODUCTO, NOMBRE_PRODUCTO, DESCRIPCION,CANTIDA_EN_STOCK, UNIDAD, PRECIO_UNITARIO) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentence, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, producto.getId_producto());
            ps.setString(2, producto.getNombre_producto());
            ps.setString(3, producto.getDescripcion());
            ps.setBigDecimal(4, producto.getCantidad());
            ps.setString(5, producto.getUnidad());
            ps.setBigDecimal(6, producto.getPrecio_unitario());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                id_producto = rs.getInt(1);
                _message = "Producto ingresado con éxito";
            }
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }
        return id_producto;
    }

    // Listar un producto
    public List<Ent_Producto> ListarProductos(String condicion) throws SQLException {
        ResultSet rs = null;
        List<Ent_Producto> lista = new ArrayList<>();
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID_PRODUCTO, NOMBRE_PRODUCTO, DESCRIPCION, CANTIDAD_EN_STOCK, UNIDAD, PRECIO_UNITARIO FROM PRODUCTOS";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);

            while (rs.next()) {
                lista.add(new Ent_Producto(
                        rs.getInt("ID_PRODUCTO"),
                        rs.getString("NOMBRE_PRODUCTO"),
                        rs.getString("DESCRIPCION"),
                        rs.getBigDecimal("CANTIDAD_EN_STOCK"),
                        rs.getString("UNIDAD"),
                        rs.getBigDecimal("PRECIO_UNITARIO")
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

    public Ent_Producto ObtenerProducto(String condicion) throws SQLException {
        Ent_Producto producto = new Ent_Producto();
        ResultSet rs = null;
        String sentencia = "SELECT ID_PRODUCTO, NOMBRE_PRODUCTO, DESCRIPCION, CANTIDAD_EN_STOCK, UNIDAD, PRECIO_UNITARIO FROM PRODUCTOS";
        if (!condicion.isEmpty()) {
            sentencia += " WHERE " + condicion;
        }
        try (Statement stm = _cnn.createStatement()) {
            rs = stm.executeQuery(sentencia);
            if (rs.next()) {
                producto.setId_producto(rs.getInt("ID_PRODUCTO"));
                producto.setNombre_producto(rs.getString("NOMBRE_PRODUCTO"));
                producto.setDescripcion(rs.getString("DESCRIPCION"));
                producto.setCantidad(rs.getBigDecimal("CANTIDAD_EN_STOCK"));
                producto.setUnidad(rs.getString("UNIDAD"));
                producto.setPrecio_unitario(rs.getBigDecimal("PRECIO_UNITARIO"));
                // producto.setExiste(true);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            _cnn = null;
        }
        return producto;
    }

    public int ModificarProducto(Ent_Producto producto) throws SQLException {
        int resultado = 0;
        String sentencia = "UPDATE PRODUCTOS SET NOMBRE_PRODUCTO = ?, DESCRIPCION = ?, CANTIDAD_EN_STOCK = ?, UNIDAD = ?, PRECIO_UNITARIO = ? WHERE ID_PRODUCTO = ?";
        try (PreparedStatement ps = _cnn.prepareStatement(sentencia)) {
            ps.setString(1, producto.getNombre_producto());
            ps.setString(2, producto.getDescripcion());
            ps.setBigDecimal(3, producto.getCantidad());
            ps.setString(4, producto.getUnidad());
            ps.setBigDecimal(5, producto.getPrecio_unitario());
            ps.setInt(6, producto.getId_producto());
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

    public int EliminarProducto(Ent_Producto producto) throws SQLException {
        int resultado = 0;
        String sentencia = "DELETE FROM PRODUCTOS WHERE ID_PRODUCTO = ?";
        try (PreparedStatement ps = _cnn.prepareStatement(sentencia)) {
            ps.setInt(1, producto.getId_producto());
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

  public int getProductID(String customQuery) throws SQLException {
        int id = -1;
        try (PreparedStatement ps = _cnn.prepareStatement(customQuery)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1); // Retrieve the first column (ID_PRODUCTO) from the result set
            }
        }
        return id;
    }
}
