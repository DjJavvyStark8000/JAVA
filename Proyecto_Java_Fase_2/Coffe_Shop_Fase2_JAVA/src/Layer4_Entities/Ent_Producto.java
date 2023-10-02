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
public class Ent_Producto {
    //Atributos................................................................
    //Atributos................................................................
    //Atributos................................................................

    private int id_producto;
    private String nombre_producto;
    private String descripcion;
    private BigDecimal cantidad;
    private String unidad;
    private BigDecimal precio_unitario;
    private boolean existe;

    //Constructor..............................................................
    //Constructor..............................................................
    //Constructor..............................................................
    public Ent_Producto(int id_producto, String nombre_producto, String descripcion, BigDecimal cantidad, String unidad, BigDecimal precio_unitario, boolean existe) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.precio_unitario = precio_unitario;
        this.existe = existe;
    }
    
    public Ent_Producto(int id_producto, String nombre_producto, String descripcion, BigDecimal cantidad, String unidad, BigDecimal precio_unitario) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.precio_unitario = precio_unitario;
        this.existe = true;
    }

    public Ent_Producto() {
        this.id_producto = 0;
        this.nombre_producto = "";
        this.descripcion = "";
        this.cantidad = BigDecimal.ZERO;
        this.unidad = "";
        this.precio_unitario = BigDecimal.ZERO;
        this.existe = false;
    }

    //Get/Set..................................................................
    //Get/Set..................................................................
    //Get/Set..................................................................
    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public BigDecimal getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(BigDecimal precio_unitario) {
        this.precio_unitario = precio_unitario;
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
