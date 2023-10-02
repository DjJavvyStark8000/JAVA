/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layer4_Entities;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author djjav
 */
public class Ent_EncabezadoFactura {
    //Atributos................................................................
    //Atributos................................................................
    //Atributos................................................................

    private int id_encabezado;
    private int id_cliente;
    private String fecha;
    private BigDecimal impuesto;
    private BigDecimal descuento;
    private BigDecimal total;
    private boolean existe;

    //Constructor..............................................................
    //Constructor..............................................................
    //Constructor..............................................................
    public Ent_EncabezadoFactura(int id_encabezado, int id_cliente, String fecha, BigDecimal impuesto, BigDecimal descuento, BigDecimal total) {
        this.id_encabezado = id_encabezado;
        this.id_cliente = id_cliente;
        this.fecha = fecha;
        this.impuesto = impuesto;
        this.descuento = descuento;
        this.total = total;
    }

    public Ent_EncabezadoFactura() {
        this.id_encabezado = 0;
        this.id_cliente = 0;
        this.fecha = "";
        this.impuesto = BigDecimal.ZERO;
        this.descuento = BigDecimal.ZERO;
        this.total = BigDecimal.ZERO;
    }
    //Get/Set..................................................................
    //Get/Set..................................................................
    //Get/Set..................................................................

    public int getId_encabezado() {
        return id_encabezado;
    }

    public void setId_encabezado(int id_encabezado) {
        this.id_encabezado = id_encabezado;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_detalle) {
        this.id_cliente = id_detalle;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    public BigDecimal getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(BigDecimal impuesto) {
        this.impuesto = impuesto;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
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
