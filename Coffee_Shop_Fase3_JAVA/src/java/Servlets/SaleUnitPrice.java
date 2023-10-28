/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Config.FinalVariables;
import Config.Substracting;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author djjav
 */
public class SaleUnitPrice extends HttpServlet {

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

            BigDecimal unitPrice = BigDecimal.ZERO;
            String productName = Substracting.getProductName(); // Store the product name in a variable for efficiency

            if ("Expresso".equals(productName) || "Negro".equals(productName)) {
                unitPrice = FinalVariables.priceOzCoffee.multiply(Substracting.getCupSize()); // only coffee
                unitPrice = unitPrice.setScale(2, RoundingMode.HALF_UP); // format to 2 digits
                Substracting.setUnitPrice(unitPrice);
                out.println(Substracting.getUnitPrice());
            } else if ("WithMilk".equals(productName)) {
                unitPrice = FinalVariables.priceOzCoffee.multiply(Substracting.getCupSize()); // only coffee
                unitPrice = unitPrice.add(FinalVariables.priceWithMilk); // add milk to it
                unitPrice = unitPrice.setScale(2, RoundingMode.HALF_UP); // format to 2 digits
                Substracting.setUnitPrice(unitPrice);
                out.println(Substracting.getUnitPrice());
            } else if ("Latte".equals(productName) || "Cappuccino".equals(productName)
                    || "Mocha".equals(productName) || "Brew".equals(productName)
                    || "Irish".equals(productName)) {
                unitPrice = FinalVariables.priceOzCoffee.multiply(Substracting.getCupSize()); // only coffee
                unitPrice = unitPrice.add(FinalVariables.priceWithMilk); // add milk to it
                unitPrice = unitPrice.add(FinalVariables.priceWithCream); // add cream to it
                unitPrice = unitPrice.setScale(2, RoundingMode.HALF_UP); // format to 2 digits
                Substracting.setUnitPrice(unitPrice);
                out.println(Substracting.getUnitPrice());
            }
            out.println("No price");

        } catch (Exception e) {
            out.println("Error");
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
