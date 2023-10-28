/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layer2_BusinessLogic;

import Layer3_DataAccess.DA_EncabezadoFactura;
import Layer4_Entities.Ent_EncabezadoFactura;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author djjav
 */
public class BL_EncabezadoFactura {
    //atributos

    private String _message;

    //getter
    public String getMessage() {
        return _message;
    }

    //llamar insertar encabezadofactura
    public int callInsertarEncabezadoFactura(Ent_EncabezadoFactura encabezadofactura) throws Exception {
        int id = -1;
        DA_EncabezadoFactura adencabezadofactura;
        try {
            adencabezadofactura = new DA_EncabezadoFactura();
            id = adencabezadofactura.InsertarEncabezadoFactura(encabezadofactura);
            _message = adencabezadofactura.getMessage();
        } catch (Exception e) {
            throw e;
        }
        return id;
    }

   
    
    //llamar listarregistros
    public List<Ent_EncabezadoFactura> callListarEncabezadoFacturas(String condicion) throws Exception {
        List<Ent_EncabezadoFactura> resultado = new ArrayList();
        DA_EncabezadoFactura adencabezadofactura;
        try {
            adencabezadofactura = new DA_EncabezadoFactura();
            resultado = adencabezadofactura.ListarEncabezadoFacturas(condicion);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
    //llamar listarregistros
    public List<Ent_EncabezadoFactura> callListarClienteEncabezado(String condicion) throws Exception {
        List<Ent_EncabezadoFactura> resultado = new ArrayList();
        DA_EncabezadoFactura adencabezadofactura;
        try {
            adencabezadofactura = new DA_EncabezadoFactura();
            resultado = adencabezadofactura.ListarClienteEncabezado(condicion);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
   public Ent_EncabezadoFactura callObtenerEncabezadoFactura(String condicion) throws Exception {
    Ent_EncabezadoFactura resultado;
    DA_EncabezadoFactura adencabezadofactura;
    try {
        adencabezadofactura = new DA_EncabezadoFactura();
        resultado = adencabezadofactura.ObtenerEncabezadoFactura(condicion);
        if (resultado.isExiste()) {
            _message = "EncabezadoFactura Recuperado exitosamente";
        } else {
            _message = "El encabezadofactura no existe";
        }
    } catch (Exception e) {
        throw e;
    }
    return resultado;
}
    
    
    public int callModificarEncabezadoFactura(Ent_EncabezadoFactura encabezadofactura) throws Exception {
    
    int resultado  = -1;
    DA_EncabezadoFactura adencabezadofactura;
        try {
            adencabezadofactura = new DA_EncabezadoFactura();
            resultado = adencabezadofactura.ModificarEncabezadoFactura(encabezadofactura);
            _message = adencabezadofactura.getMessage();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
    public int callEliminarEncabezadoFactura(int idFactura) throws Exception {
    
    int resultado  = -1;
    DA_EncabezadoFactura adencabezadofactura;
        try {
            adencabezadofactura = new DA_EncabezadoFactura();
            resultado = adencabezadofactura.EliminarEncabezadoFactura(idFactura);
            _message = adencabezadofactura.getMessage();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
}
