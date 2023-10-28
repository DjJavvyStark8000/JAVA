/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Config.Substracting;
import Layer2_BusinessLogic.BL_Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author djjav
 */
public class VirtualReceipt extends HttpServlet {

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
           
            String productName = Substracting.getProductName();
            BigDecimal quantity = Substracting.getOrderQuantity();
            BigDecimal unitPrice = Substracting.getUnitPrice(); // Assuming this is the unit price
            int productID = -1;

            boolean updated = false;

            for (Object[] row : Substracting.receiptLines) {
                String existingProductName = (String) row[1];
                BigDecimal existingQuantity = (BigDecimal) row[0];

                if (productName.equals(existingProductName)) {
                    // If product name matches an existing entry, add the quantity
                    row[0] = existingQuantity.add(quantity);  // Update the quantity by adding

                    // Calculate the new subtotal and update it
                    BigDecimal newSubtotal = unitPrice.multiply((BigDecimal) row[0]);
                    row[4] = newSubtotal;  // Update the subtotal
                    updated = true;
                    break;
                }
            }

            if (!updated) {
                // If no matching entry was found, add a new row
                Object[] oneRow = new Object[6];
                oneRow[0] = quantity;
                oneRow[1] = productName;
                oneRow[2] = Substracting.getProductSize();
                oneRow[3] = unitPrice;
                // Calculate the new subtotal for the new row and set it
                BigDecimal newSubtotal = unitPrice.multiply(quantity);
                oneRow[4] = newSubtotal;  // Set the subtotal
                BL_Producto logicProductID = new BL_Producto();
                String custonQuery = "SELECT ID_PRODUCTO FROM PRODUCTOS WHERE NOMBRE_PRODUCTO = '" + productName + "' AND DESCRIPCION = '" + Substracting.getProductSize() + "'";        
                productID = logicProductID.callGetProductId(custonQuery);
                oneRow[5] = productID;

                Substracting.receiptLines.add(oneRow);
            }
            
            out.println(productID); // Indicate success
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
