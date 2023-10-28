/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layer4_Entities;

/**
 *
 * @author djjav
 */
public class Ent_Empleado extends Ent_Persona {

    //Atributos................................................................
    //Atributos................................................................
    //Atributos................................................................
    private int id_empleado;
    private int id_cargo;
    
    //Constructor..............................................................
    //Constructor..............................................................
    //Constructor..............................................................
    
    public Ent_Empleado(int id_empleado, String nombre_empleado, String telefono, String correo, String direccion, int id_cargo, boolean existe){
    super(nombre_empleado, telefono, correo, direccion, existe);
    this.id_empleado = id_empleado;
    this.id_cargo = id_cargo;
    }
    
    public Ent_Empleado(int id_empleado, String nombre_empleado, String telefono, String correo, String direccion, int id_cargo){
    super(nombre_empleado, telefono, correo, direccion);
    this.id_empleado = id_empleado;
    this.id_cargo = id_cargo;
    }
    
    public Ent_Empleado(){
    super();
    this.id_cargo = 0;
    }
    
    //Get/Set..................................................................
    //Get/Set..................................................................
    //Get/Set..................................................................
    
    public int getIdEmpleado() {
        return id_empleado;
    }

    public void setIdEmpleado(int id_cliente) {
        this.id_empleado = id_cliente;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }
    
    //Métodos..................................................................
    //Métodos..................................................................
    //Métodos..................................................................
    
    
}
