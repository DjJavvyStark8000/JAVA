/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layer2_BusinessLogic;

import Layer3_DataAccess.DA_Empleado;
import Layer4_Entities.Ent_Empleado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author djjav
 */
public class BL_Empleado {
   //atributos

    private String _message;

    //getter
    public String getMessage() {
        return _message;
    }

    //llamar insertar empleado
    public int callInsertarEmpleado(Ent_Empleado empleado) throws Exception {
        int id = -1;
        DA_Empleado adempleado;
        try {
            adempleado = new DA_Empleado();
            id = adempleado.InsertarEmpleado(empleado);
            _message = adempleado.getMessage();
        } catch (Exception e) {
            throw e;
        }
        return id;
    }

   
    
    //llamar listarregistros
    public List<Ent_Empleado> callListarEmpleados(String condicion) throws Exception {
        List<Ent_Empleado> resultado = new ArrayList();
        DA_Empleado adempleado;
        try {
            adempleado = new DA_Empleado();
            resultado = adempleado.ListarEmpleados(condicion);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
   public Ent_Empleado callObtenerEmpleado(String condicion) throws Exception {
    Ent_Empleado resultado;
    DA_Empleado adempleado;
    try {
        adempleado = new DA_Empleado();
        resultado = adempleado.ObtenerEmpleado(condicion);
        if (resultado.isExiste()) {
            _message = "Empleado Recuperado exitosamente";
        } else {
            _message = "El empleado no existe";
        }
    } catch (Exception e) {
        throw e;
    }
    return resultado;
}
    
    
    public int callModificarEmpleado(Ent_Empleado empleado) throws Exception {
    
    int resultado  = -1;
    DA_Empleado adempleado;
        try {
            adempleado = new DA_Empleado();
            resultado = adempleado.ModificarEmpleado(empleado);
            _message = adempleado.getMessage();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
    public int callEliminarEmpleado(Ent_Empleado empleado) throws Exception {
    
    int resultado  = -1;
    DA_Empleado adempleado;
        try {
            adempleado = new DA_Empleado();
            resultado = adempleado.EliminarEmpleado(empleado);
            _message = adempleado.getMessage();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    } 
}
