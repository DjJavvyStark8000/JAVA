/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layer2_BusinessLogic;

import Layer3_DataAccess.DA_Producto;
import Layer4_Entities.Ent_Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author djjav
 */
public class BL_Producto {
    //atributos

    private String _message;

    //getter
    public String getMessage() {
        return _message;
    }

    //llamar insertar producto
    public int callInsertarProducto(Ent_Producto producto) throws Exception {
        int id = -1;
        DA_Producto adproducto;
        try {
            adproducto = new DA_Producto();
            id = adproducto.InsertarProducto(producto);
            _message = adproducto.getMessage();
        } catch (Exception e) {
            throw e;
        }
        return id;
    }

    //llamar listarregistros
    public List<Ent_Producto> callListarProductos(String condicion) throws Exception {
        List<Ent_Producto> resultado = new ArrayList();
        DA_Producto adproducto;
        try {
            adproducto = new DA_Producto();
            resultado = adproducto.ListarProductos(condicion);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }

    public Ent_Producto callObtenerProducto(String condicion) throws Exception {
        Ent_Producto resultado;
        DA_Producto adproducto;
        try {
            adproducto = new DA_Producto();
            resultado = adproducto.ObtenerProducto(condicion);
            if (resultado.isExiste()) {
                _message = "Producto Recuperado exitosamente";
            } else {
                _message = "El producto no existe";
            }
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }

    public int callModificarProducto(Ent_Producto producto) throws Exception {

        int resultado = -1;
        DA_Producto adproducto;
        try {
            adproducto = new DA_Producto();
            resultado = adproducto.ModificarProducto(producto);
            _message = adproducto.getMessage();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }

    public int callEliminarProducto(Ent_Producto producto) throws Exception {

        int resultado = -1;
        DA_Producto adproducto;
        try {
            adproducto = new DA_Producto();
            resultado = adproducto.EliminarProducto(producto);
            _message = adproducto.getMessage();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }

    //Get product id
    public int callGetProductId(String custonQuery) throws Exception {
        int id = -1;
        DA_Producto daproducto;
        try {
            daproducto = new DA_Producto();
            id = daproducto.getProductID(custonQuery);
        } catch (Exception e) {
            throw e;
        }
        return id;
    }
}
