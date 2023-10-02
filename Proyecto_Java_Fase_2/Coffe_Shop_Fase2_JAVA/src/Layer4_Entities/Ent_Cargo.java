/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layer4_Entities;

/**
 *
 * @author djjav
 */
public class Ent_Cargo {
    //Atributos................................................................
    //Atributos................................................................
    //Atributos................................................................

    private int id_cargo;
    private String cargo;
    //Constructor..............................................................
    //Constructor..............................................................
    //Constructor..............................................................

    public Ent_Cargo(int id_cargo, String cargo) {
        this.id_cargo = id_cargo;
        this.cargo = cargo;
    }

    public Ent_Cargo() {
        this.id_cargo = 0;
        this.cargo = "";
    }
    //Get/Set..................................................................
    //Get/Set..................................................................
    //Get/Set..................................................................

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    //Métodos..................................................................
    //Métodos..................................................................
    //Métodos..................................................................

}
