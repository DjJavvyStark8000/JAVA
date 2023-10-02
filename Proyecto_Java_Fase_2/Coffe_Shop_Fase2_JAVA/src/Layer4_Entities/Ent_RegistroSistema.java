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
public class Ent_RegistroSistema {
    //Atributos................................................................
    //Atributos................................................................
    //Atributos................................................................

    private int id_registro;
    private int id_cliente;
    private int id_empleado;
    private int id_encabezado;
    private boolean existe;
    //Constructor..............................................................
    //Constructor..............................................................
    //Constructor..............................................................

    public Ent_RegistroSistema(int id_registro, int id_cliente, int id_empleado, int id_encabezado, boolean existe) {
        this.id_registro = id_registro;
        this.id_cliente = id_cliente;
        this.id_empleado = id_empleado;
        this.id_encabezado = id_encabezado;
        this.existe = existe;
    }

    public Ent_RegistroSistema(int id_registro, int id_cliente, int id_empleado, int id_encabezado) {
        this.id_registro = id_registro;
        this.id_cliente = id_cliente;
        this.id_empleado = id_empleado;
        this.id_encabezado = id_encabezado;
        this.existe = true;
    }

    public Ent_RegistroSistema() {
        this.id_registro = 0;
        this.id_cliente = 0;
        this.id_empleado = 0;
        this.id_encabezado = 0;
    }
    //Get/Set..................................................................
    //Get/Set..................................................................
    //Get/Set..................................................................

    public int getId_registro() {
        return id_registro;
    }

    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_encabezado() {
        return id_encabezado;
    }

    public void setId_encabezado(int id_encabezado) {
        this.id_encabezado = id_encabezado;
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
