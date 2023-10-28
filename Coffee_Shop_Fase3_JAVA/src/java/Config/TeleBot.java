/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import Layer2_BusinessLogic.BL_EncabezadoFactura;
import Layer4_Entities.Ent_EncabezadoFactura;
import java.util.List;

/**
 *
 * @author djjav
 */
public class TeleBot {

    public static void main(String[] args) {
        // Create an instance of your class (assuming your methods are in a class)
        BL_EncabezadoFactura encabezadoLogic = new BL_EncabezadoFactura();

        try {
            // Call the method to retrieve the list
            List<Ent_EncabezadoFactura> encabezadoFacturas = encabezadoLogic.callListarClienteEncabezado("");
           
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

            System.out.println(infoText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
