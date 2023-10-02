/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layer4_Entities;

import java.math.BigDecimal;

/**
 *
 * @author djjav
 */
public class Ent_DetalleFactura {
   //Atributos................................................................
    //Atributos................................................................
    //Atributos................................................................
private int id_detalle;
private int id_producto;
private int cantidad;
private boolean existe;
private BigDecimal subtotal;
    //Constructor..............................................................
    //Constructor..............................................................
    //Constructor..............................................................
    public Ent_DetalleFactura(int id_detalle, int id_producto, int cantidad, BigDecimal subtotal, boolean existe) {
        this.id_detalle = id_detalle;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.existe = existe;
    }
    
    public Ent_DetalleFactura(int id_detalle, int id_producto, int cantidad, BigDecimal subtotal) {
        this.id_detalle = id_detalle;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.existe = true;
    }
    
    public Ent_DetalleFactura() {
        this.id_detalle = 0;
        this.id_producto = 0;
        this.cantidad = 0;
        this.subtotal = BigDecimal.ZERO;
        this.existe = false;
    }

    //Get/Set..................................................................
    //Get/Set..................................................................
    //Get/Set..................................................................
    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
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
