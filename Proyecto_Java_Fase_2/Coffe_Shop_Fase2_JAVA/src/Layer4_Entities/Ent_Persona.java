/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layer4_Entities;

/**
 *
 * @author djjav
 */
public abstract class Ent_Persona {

    //Atributos................................................................
    //Atributos................................................................
    //Atributos................................................................
    private String nombre;
    private String telefono;
    private String correo;
    private String direccion;
    private boolean existe;

    //Constructores............................................................
    //Constructores............................................................
    //Constructores............................................................
    public Ent_Persona(String nombre, String direccion, String telefono, String correo, boolean existe) {

        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.existe = existe;
    }

    public Ent_Persona(String nombre, String direccion, String telefono, String correo) {

        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.existe = true;
    }

    public Ent_Persona() {

        this.nombre = "";
        this.telefono = "";
        this.correo = "";
        this.direccion = "";
        this.existe = false;
    }

    //Get/Set..............................................................
    //Get/Set..............................................................
    //Get/Set..............................................................
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombreEmpleado) {
        this.nombre = nombreEmpleado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    //Métodos..................................................................
    //Métodos..................................................................
    //Métodos..................................................................
}
