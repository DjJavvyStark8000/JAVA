/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layer2_BusinessLogic;

import Layer3_DataAccess.DA_RegistroSistema;
import Layer4_Entities.Ent_RegistroSistema;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author djjav
 */
public class BL_RegistroSistema {
    //atributos

    private String _message;

    //getter
    public String getMessage() {
        return _message;
    }

    //llamar insertar segistrosistema
    public int callInsertarRegistroSistema(Ent_RegistroSistema segistrosistema) throws Exception {
        int id = -1;
        DA_RegistroSistema adsegistrosistema;
        try {
            adsegistrosistema = new DA_RegistroSistema();
            id = adsegistrosistema.InsertarRegistroSistema(segistrosistema);
            _message = adsegistrosistema.getMessage();
        } catch (Exception e) {
            throw e;
        }
        return id;
    }

   
    
    //llamar listarregistros
    public List<Ent_RegistroSistema> callListarRegistroSistemas(String condicion) throws Exception {
        List<Ent_RegistroSistema> resultado = new ArrayList();
        DA_RegistroSistema adsegistrosistema;
        try {
            adsegistrosistema = new DA_RegistroSistema();
            resultado = adsegistrosistema.ListarRegistroSistemas(condicion);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
   public Ent_RegistroSistema callObtenerRegistroSistema(String condicion) throws Exception {
    Ent_RegistroSistema resultado;
    DA_RegistroSistema adsegistrosistema;
    try {
        adsegistrosistema = new DA_RegistroSistema();
        resultado = adsegistrosistema.ObtenerRegistroSistema(condicion);
        if (resultado.isExiste()) {
            _message = "RegistroSistema Recuperado exitosamente";
        } else {
            _message = "El segistrosistema no existe";
        }
    } catch (Exception e) {
        throw e;
    }
    return resultado;
}
    
    
    public int callModificarRegistroSistema(Ent_RegistroSistema segistrosistema) throws Exception {
    
    int resultado  = -1;
    DA_RegistroSistema adsegistrosistema;
        try {
            adsegistrosistema = new DA_RegistroSistema();
            resultado = adsegistrosistema.ModificarRegistroSistema(segistrosistema);
            _message = adsegistrosistema.getMessage();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
    public int callEliminarRegistroSistema(Ent_RegistroSistema segistrosistema) throws Exception {
    
    int resultado  = -1;
    DA_RegistroSistema adsegistrosistema;
        try {
            adsegistrosistema = new DA_RegistroSistema();
            resultado = adsegistrosistema.EliminarRegistroSistema(segistrosistema);
            _message = adsegistrosistema.getMessage();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
}
