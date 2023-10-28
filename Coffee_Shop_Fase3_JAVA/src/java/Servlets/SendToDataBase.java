package Servlets;

import Config.FinalVariables;
import Config.Substracting;
import static Config.Substracting.productSubtractDetails;
import static Config.Substracting.receiptLines;
import Layer2_BusinessLogic.BL_Accounting;
import Layer2_BusinessLogic.BL_Cliente;
import Layer2_BusinessLogic.BL_DetalleFactura;
import Layer2_BusinessLogic.BL_EncabezadoFactura;
import Layer4_Entities.Ent_Cliente;
import Layer4_Entities.Ent_DetalleFactura;
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
public class SendToDataBase extends HttpServlet {

    private static String theEmail = FinalVariables.ghostEmail;
    private static String theName = "Cliente";

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

            theEmail = request.getParameter("userEmail");
            theName = request.getParameter("userName");
            //Step ONE substracting the products from databse
            takeFromDataBase();

            //Step TWO create receipt details in databse
            addReceiptDetail();
            
            //Step THREE check if new email was entered to built a new client
            BL_Cliente clientLogic = new BL_Cliente();
            Boolean clientExists = clientEmailExist(theEmail);
            if (!clientExists) {
                createClient();
            }
            //Step FOUR modify the ghost reciept
            addReceipt();

            //a new receipt can be created now
            //openGhostReceipt = true;
             
            out.println("");
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
            JOptionPane.showMessageDialog(null, "Ha sucedico un error: " + e.getMessage());
        }
        return exists;
    }

    //update database
    private void takeFromDataBase() {
        String condition = "";
        int id = 0;
        BigDecimal amount;
        for (Object[] row : productSubtractDetails) {
            if (row.length >= 16) { // Verify row length
                for (int i = 0; i < 16; i++) { // Iterate through all 16 columns

                    if (i % 2 == 0) { // Check if it's even
                        int value = (int) row[i]; // Cast the element to an Integer
                        id = value;
                        condition = "ID_PRODUCTO = '" + id + "'";
                        amount = (BigDecimal) row[i + 1];
                        BL_Accounting.grabProductToUpdate(condition, amount);
                    }
                }
            }
        }
    }

    //built receipt details table in the database
    private void addReceiptDetail() {

        int idReceipt;
        int productId;
        BigDecimal cantidad;
        BigDecimal subtotal;

        //instance of the object
        Ent_DetalleFactura receiptDetail = new Ent_DetalleFactura();
        //loop the array to grab the informacion to insert in the database
        for (Object[] row : receiptLines) {
            if (row.length > 5) { // Verify row length  
                idReceipt = Substracting.getIdReceipt();
                productId = (int) row[5];
                cantidad = (BigDecimal) row[0];
                subtotal = (BigDecimal) row[4];

                receiptDetail.setId_detalle(idReceipt);
                receiptDetail.setId_producto(productId);
                receiptDetail.setCantidad(cantidad.intValue());
                receiptDetail.setSubtotal(subtotal);

                BL_DetalleFactura logicReceiptDetail = new BL_DetalleFactura();
                try {
                    int returnId = logicReceiptDetail.callInsertarDetalleFactura(receiptDetail);
                } catch (Exception e) {
                    e.printStackTrace(); // Print the full stack trace for debugging

                }
            }
        }
    }

    //add Receipt header table to the database
    private void addReceipt() {

        int returnId = 0;
        try {

            //instance of the object Receipt header
            Ent_EncabezadoFactura receiptHeader = new Ent_EncabezadoFactura();
            BL_Cliente cliente = new BL_Cliente();
            int idCliente = cliente.callClientIdByEmail(theEmail);
            receiptHeader.setId_cliente(idCliente);
            receiptHeader.setFecha(Substracting.getFechaActual());
            receiptHeader.setImpuesto(Substracting.getTheTax());
            receiptHeader.setDescuento(Substracting.getTheDiscount());
            receiptHeader.setTotal(Substracting.getNetTotal());
            receiptHeader.setId_encabezado(Substracting.getIdReceipt());

            BL_EncabezadoFactura logicReceiptHeader = new BL_EncabezadoFactura();
            returnId = logicReceiptHeader.callModificarEncabezadoFactura(receiptHeader);
        } catch (Exception e) {
            e.printStackTrace(); // Print the full stack trace for debugging

        }

    }

    //createClient
    private void createClient() {
        if (theEmail != FinalVariables.ghostEmail || theEmail != "") {
            BL_Cliente clientLogic = new BL_Cliente();
            Ent_Cliente cliente;
            int idnewclient;
            try {
                cliente = clientObject();
                idnewclient = clientLogic.callInsertarCliente(cliente);
                if (idnewclient > 0) {
                    //JOptionPane.showMessageDialog(this, "Nuevo cliente agregado");
                }
            } catch (Exception e) {

            }
        }
    }

    //create client object
    private Ent_Cliente clientObject() {
        Ent_Cliente client = new Ent_Cliente();

        try {
            client.setNombre(theName);
            client.setDireccion("n/a");
            client.setTelefono("n/a");
            client.setCorreo(theEmail);

        } catch (Exception e) {

        }
        return client;
    }

}
