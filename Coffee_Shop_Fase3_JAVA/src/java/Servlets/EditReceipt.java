/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Config.Substracting;
import Layer2_BusinessLogic.BL_EncabezadoFactura;
import Layer4_Entities.Ent_EncabezadoFactura;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author djjav
 */
public class EditReceipt extends HttpServlet {

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
        // Create an instance of your class (assuming your methods are in a class)
        BL_EncabezadoFactura encabezadoLogic = new BL_EncabezadoFactura();
        try {//Grabs one receipt from db, store it in the array to load it on a input table to edit
            String id = request.getParameter("editReceipt");
            int theID = (Integer.parseInt(id));

            Substracting.clientReceipts.clear();//clean my array
            // Call the method to retrieve the list
            List<Ent_EncabezadoFactura> encabezadoFacturas = encabezadoLogic.callListarClienteEncabezado("EF.ID_FACTURA = " + theID);

            // Iterate over the list and print each element
            for (Ent_EncabezadoFactura factura : encabezadoFacturas) {
                Object[] oneRow = new Object[7];
                oneRow[0] = factura.getId_encabezado();
                oneRow[1] = factura.getNombreCliente();
                oneRow[2] = factura.getId_cliente();
                oneRow[3] = factura.getFecha();
                oneRow[4] = factura.getImpuesto();
                oneRow[5] = factura.getDescuento();
                oneRow[6] = factura.getTotal();
                Substracting.clientReceipts.add(oneRow);

            }

            StringBuilder infoText = new StringBuilder("Information List:\n");

            for (Object[] info : Substracting.clientReceipts) {
                for (Object item : info) {
                    infoText.append(item).append(" ");
                }
                infoText.append("\n");
            }

            out.println(infoText);
        } catch (Exception e) {
        }
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
