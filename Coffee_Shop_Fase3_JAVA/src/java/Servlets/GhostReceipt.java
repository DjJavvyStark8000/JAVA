/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Config.FinalVariables;
import Config.Substracting;
import Layer2_BusinessLogic.BL_Cliente;
import Layer2_BusinessLogic.BL_EncabezadoFactura;
import Layer4_Entities.Ent_EncabezadoFactura;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author djjav
 */
public class GhostReceipt extends HttpServlet {

    private static int id_Receipt;

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
        try {
            id_Receipt = sendGhostObject();
            Substracting.setIdReceipt(id_Receipt);//global id
            out.println(id_Receipt);
        } catch (Exception e) {
        }
    }

    //check if the client unique email exists in the database
    private boolean clientEmailExist(String givenEmail) {
        boolean exists = false;
        BL_Cliente clientLogic = new BL_Cliente();
        try {
            exists = clientLogic.callClientEmailExist(givenEmail);
            if (exists) {
                exists = true;
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Ha sucedico un error: " + e.getMessage());
        }
        return exists;
    }

    //send fake object to the database
    private int sendGhostObject() {
        BL_EncabezadoFactura receiptHeaderLogic = new BL_EncabezadoFactura();
        Ent_EncabezadoFactura ghostReceiptHeader = createGhostObject();//temporary client
        boolean clientExists = false;

        id_Receipt = -1;

        try {
            clientExists = clientEmailExist(FinalVariables.ghostEmail);//correo fantasma
            if (clientExists) {
                id_Receipt = receiptHeaderLogic.callInsertarEncabezadoFactura(ghostReceiptHeader);

            } else {

            }
        } catch (Exception e) {

        }
        return id_Receipt;
    }

    //fake object
    private Ent_EncabezadoFactura createGhostObject() {

        Ent_EncabezadoFactura encabezadoFactura = new Ent_EncabezadoFactura();
        encabezadoFactura.setId_cliente(101);
        encabezadoFactura.setFecha(Substracting.getFechaActual());
        encabezadoFactura.setImpuesto(BigDecimal.ZERO);
        encabezadoFactura.setDescuento(BigDecimal.ZERO);
        encabezadoFactura.setTotal(BigDecimal.ZERO);
        return encabezadoFactura;
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
