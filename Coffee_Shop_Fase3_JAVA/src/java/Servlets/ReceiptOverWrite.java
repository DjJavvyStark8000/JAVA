/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Layer2_BusinessLogic.BL_EncabezadoFactura;
import Layer4_Entities.Ent_EncabezadoFactura;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author djjav
 */
public class ReceiptOverWrite extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {//Grabs one receipt from db, store it in the array to load it on a input table to edit
            int result = -1;
            // Retrieve form data from request parameters
            String idFactura = request.getParameter("id_factura");
            String cliente = request.getParameter("cliente");
            String idCliente = request.getParameter("id_cliente");
            String fecha = request.getParameter("fecha");
            String impuesto = request.getParameter("impuesto");
            String descuento = request.getParameter("descuento");
            String total = request.getParameter("total");

            result = receiptOverWrite(idCliente, fecha, impuesto, descuento, total, idFactura);
            //String requestData = "idFactura= " + idFactura + "\n" + "cliente= " + cliente + "\n" + "idCliente= " + idCliente + "\n" + "fecha= " + fecha + "\n" + "impuesto= " + impuesto + "\n" + "descuento= " + descuento + "\n" + "total= " + total;
            out.println();
        } catch (Exception e) {
        }
    }

    private Ent_EncabezadoFactura createReceiptObject(String idCliente, String fecha, String impuesto, String descuento, String total, String idFactura) {
        Ent_EncabezadoFactura encabezado = new Ent_EncabezadoFactura();
        try {
            encabezado.setId_cliente(Integer.parseInt(idCliente));
            encabezado.setFecha(fecha);
            BigDecimal impuestoDecimal = new BigDecimal(impuesto);
            BigDecimal descuentoDecimal = new BigDecimal(descuento);
            BigDecimal totalDecimal = new BigDecimal(total);
            encabezado.setImpuesto(impuestoDecimal);
            encabezado.setDescuento(descuentoDecimal);
            encabezado.setTotal(totalDecimal);
            encabezado.setId_encabezado(Integer.parseInt(idFactura));
        } catch (NumberFormatException e) {
            e.printStackTrace(); // You can replace this with proper error handling 
        }
        return encabezado;
    }

    //send fake object to the database
    private int receiptOverWrite(String idCliente, String fecha, String impuesto, String descuento, String total, String idFactura) throws SQLException {
        BL_EncabezadoFactura receiptHeaderLogic = new BL_EncabezadoFactura();
        Ent_EncabezadoFactura encabezado;
        int resultado = -1;

        try {
            encabezado = createReceiptObject(idCliente, fecha, impuesto, descuento, total, idFactura);
            resultado = receiptHeaderLogic.callModificarEncabezadoFactura(encabezado);
        } catch (Exception e) {

            e.printStackTrace(); // You can replace this with proper error handling
        }
        return resultado;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
