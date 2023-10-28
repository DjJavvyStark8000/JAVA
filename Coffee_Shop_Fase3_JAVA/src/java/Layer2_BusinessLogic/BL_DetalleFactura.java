/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layer2_BusinessLogic;

import Layer3_DataAccess.DA_DetalleFactura;
import Layer4_Entities.Ent_DetalleFactura;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author djjav
 */
public class BL_DetalleFactura {
    //atributos

    private String _message;

    //getter
    public String getMessage() {
        return _message;
    }

    //llamar insertar detalle_factura
    public int callInsertarDetalleFactura(Ent_DetalleFactura detalle_factura) throws Exception {
        int id = -1;
        DA_DetalleFactura addetalle_factura;
        try {
            addetalle_factura = new DA_DetalleFactura();
            id = addetalle_factura.InsertarDetalleFactura(detalle_factura);
            _message = addetalle_factura.getMessage();
        } catch (Exception e) {
            throw e;
        }
        return id;
    }

   
    
    //llamar listarregistros
    public List<Ent_DetalleFactura> callListarDetalleFacturas(String condicion) throws Exception {
        List<Ent_DetalleFactura> resultado = new ArrayList();
        DA_DetalleFactura addetalle_factura;
        try {
            addetalle_factura = new DA_DetalleFactura();
            resultado = addetalle_factura.ListarDetalleFacturas(condicion);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
   public Ent_DetalleFactura callObtenerDetalleFactura(String condicion) throws Exception {
    Ent_DetalleFactura resultado;
    DA_DetalleFactura addetalle_factura;
    try {
        addetalle_factura = new DA_DetalleFactura();
        resultado = addetalle_factura.ObtenerDetalleFactura(condicion);
        if (resultado.isExiste()) {
            _message = "DetalleFactura Recuperado exitosamente";
        } else {
            _message = "El detalle_factura no existe";
        }
    } catch (Exception e) {
        throw e;
    }
    return resultado;
}
    
    
    public int callModificarDetalleFactura(Ent_DetalleFactura detalle_factura) throws Exception {
    
    int resultado  = -1;
    DA_DetalleFactura addetalle_factura;
        try {
            addetalle_factura = new DA_DetalleFactura();
            resultado = addetalle_factura.ModificarDetalleFactura(detalle_factura);
            _message = addetalle_factura.getMessage();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
    public int callEliminarDetalleFactura(Ent_DetalleFactura detalle_factura) throws Exception {
    
    int resultado  = -1;
    DA_DetalleFactura addetalle_factura;
        try {
            addetalle_factura = new DA_DetalleFactura();
            resultado = addetalle_factura.EliminarDetalleFactura(detalle_factura);
            _message = addetalle_factura.getMessage();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
}
