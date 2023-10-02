/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layer2_BusinessLogic;

import Layer3_DataAccess.DA_Cliente;
import Layer4_Entities.Ent_Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author djjav
 */
public class BL_Cliente {
    //atributos

    private String _message;

    //getter
    public String getMessage() {
        return _message;
    }

    //llamar insertar cliente
    public int callInsertarCliente(Ent_Cliente cliente) throws Exception {
        int id = -1;
        DA_Cliente adcliente;
        try {
            adcliente = new DA_Cliente();
            id = adcliente.InsertarCliente(cliente);
            _message = adcliente.getMessage();
        } catch (Exception e) {
            throw e;
        }
        return id;
    }

   
    
    //llamar listarregistros
    public List<Ent_Cliente> callListarClientes(String condicion) throws Exception {
        List<Ent_Cliente> resultado = new ArrayList();
        DA_Cliente adcliente;
        try {
            adcliente = new DA_Cliente();
            resultado = adcliente.ListarClientes(condicion);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
   public Ent_Cliente callObtenerCliente(String condicion) throws Exception {
    Ent_Cliente resultado;
    DA_Cliente adcliente;
    try {
        adcliente = new DA_Cliente();
        resultado = adcliente.ObtenerCliente(condicion);
        if (resultado.isExiste()) {
            _message = "Cliente Recuperado exitosamente";
        } else {
            _message = "El cliente no existe";
        }
    } catch (Exception e) {
        throw e;
    }
    return resultado;
}
    
    
    public int callModificarCliente(Ent_Cliente cliente) throws Exception {
    
    int resultado  = -1;
    DA_Cliente adcliente;
        try {
            adcliente = new DA_Cliente();
            resultado = adcliente.ModificarCliente(cliente);
            _message = adcliente.getMessage();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
    public int callEliminarCliente(Ent_Cliente cliente) throws Exception {
    
    int resultado  = -1;
    DA_Cliente adcliente;
        try {
            adcliente = new DA_Cliente();
            resultado = adcliente.EliminarCliente(cliente);
            _message = adcliente.getMessage();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
    //client exist???
    public boolean callClientEmailExist(String givenEmail) throws Exception {
    boolean exists = false;
    DA_Cliente adcliente;
        try {
            adcliente = new DA_Cliente();
            exists = adcliente.clientEmailExists(givenEmail);
        } catch (Exception e) {
            throw e;
        }    
    return exists;
    }
    
    
    //grab client id
    public int callClientIdByEmail(String givenEmail) throws Exception {
    int id = -1;
    DA_Cliente adcliente;
        try {
            adcliente = new DA_Cliente();
            id = adcliente.grabClientIDByEmail(givenEmail);
        } catch (Exception e) {
            throw e;
        }    
    return id;
    }
}
