/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layer4_Entities;

import java.time.LocalTime;

/**
 *
 * @author djjav
 */
public class Ent_Pago {

    //Atributos................................................................
    //Atributos................................................................
    //Atributos................................................................
    private int id_pago;
    private int id_encabezado;
    private String metodo_pago;
    private String hora;
    private String estado_pago;
    private boolean existe;

    //Constructor..............................................................
    //Constructor..............................................................
    //Constructor..............................................................
    public Ent_Pago(int id_pago, int id_encabezado, String metodo_pago, String hora, String estado_pago, boolean existe) {
        this.id_pago = id_pago;
        this.id_encabezado = id_encabezado;
        this.metodo_pago = metodo_pago;
        this.hora = hora;
        this.estado_pago = estado_pago;
        this.existe = existe;
    }
    
    public Ent_Pago(int id_pago, int id_encabezado, String metodo_pago, String hora, String estado_pago) {
        this.id_pago = id_pago;
        this.id_encabezado = id_encabezado;
        this.metodo_pago = metodo_pago;
        this.hora = hora;
        this.estado_pago = estado_pago;
        this.existe = true;
    }

    public Ent_Pago() {
        this.id_pago = 0;
        this.id_encabezado = 0;
        this.metodo_pago = "";
        this.hora = "";
        this.estado_pago = "";
        this.existe = false;
    }

    //Get/Set..................................................................
    //Get/Set..................................................................
    //Get/Set..................................................................
    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public int getId_encabezado() {
        return id_encabezado;
    }

    public void setId_encabezado(int id_encabezado) {
        this.id_encabezado = id_encabezado;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstado_pago() {
        return estado_pago;
    }

    public void setEstado_pago(String estado_pago) {
        this.estado_pago = estado_pago;
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
