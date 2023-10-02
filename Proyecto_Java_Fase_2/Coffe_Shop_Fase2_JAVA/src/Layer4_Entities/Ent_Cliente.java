/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layer4_Entities;

/**
 *
 * @author djjav
 */
public class Ent_Cliente extends Ent_Persona {
    //Atributos................................................................
    //Atributos................................................................
    //Atributos................................................................
     private int id_cliente;
    //Constructor..............................................................
    //Constructor..............................................................
    //Constructor..............................................................
    public Ent_Cliente(int id_cliente, String nombre_empleado, String direccion, String telefono, String correo, boolean existe) {
        super(nombre_empleado, direccion, telefono, correo, existe);
        this.id_cliente = id_cliente;
    }
    
    public Ent_Cliente(int id_cliente, String nombre_empleado, String direccion, String telefono, String correo) {
        super(nombre_empleado,direccion, telefono, correo);
        this.id_cliente = id_cliente;
    }
    
    public Ent_Cliente() {
        super();
    }

    //Get/Set..................................................................
    //Get/Set..................................................................
    //Get/Set..................................................................
    public int getIdCliente() {
        return id_cliente;
    }

    public void setIdCliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    //Métodos..................................................................
    //Métodos..................................................................
    //Métodos.................................................................. 
}
