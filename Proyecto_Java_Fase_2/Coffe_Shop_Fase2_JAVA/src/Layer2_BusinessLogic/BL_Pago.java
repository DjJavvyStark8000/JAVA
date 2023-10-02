/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layer2_BusinessLogic;

import Layer3_DataAccess.DA_Pago;
import Layer4_Entities.Ent_Pago;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author djjav
 */
public class BL_Pago {
    //atributos

    private String _message;

    //getter
    public String getMessage() {
        return _message;
    }

    //llamar insertar pago
    public int callInsertarPago(Ent_Pago pago) throws Exception {
        int id = -1;
        DA_Pago adpago;
        try {
            adpago = new DA_Pago();
            id = adpago.InsertarPago(pago);
            _message = adpago.getMessage();
        } catch (Exception e) {
            throw e;
        }
        return id;
    }

   
    
    //llamar listarregistros
    public List<Ent_Pago> callListarPagos(String condicion) throws Exception {
        List<Ent_Pago> resultado = new ArrayList();
        DA_Pago adpago;
        try {
            adpago = new DA_Pago();
            resultado = adpago.ListarPagos(condicion);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
   public Ent_Pago callObtenerPago(String condicion) throws Exception {
    Ent_Pago resultado;
    DA_Pago adpago;
    try {
        adpago = new DA_Pago();
        resultado = adpago.ObtenerPago(condicion);
        if (resultado.isExiste()) {
            _message = "Pago Recuperado exitosamente";
        } else {
            _message = "El pago no existe";
        }
    } catch (Exception e) {
        throw e;
    }
    return resultado;
}
    
    
    public int callModificarPago(Ent_Pago pago) throws Exception {
    
    int resultado  = -1;
    DA_Pago adpago;
        try {
            adpago = new DA_Pago();
            resultado = adpago.ModificarPago(pago);
            _message = adpago.getMessage();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
    public int callEliminarPago(Ent_Pago pago) throws Exception {
    
    int resultado  = -1;
    DA_Pago adpago;
        try {
            adpago = new DA_Pago();
            resultado = adpago.EliminarPago(pago);
            _message = adpago.getMessage();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
}
