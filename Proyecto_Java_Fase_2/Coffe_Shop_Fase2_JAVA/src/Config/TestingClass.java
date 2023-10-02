/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import Layer2_BusinessLogic.BL_Cliente;
import Layer2_BusinessLogic.BL_Producto;
import Layer4_Entities.Ent_Accounting;
import Layer4_Entities.Ent_Producto;
import java.util.List;

/**
 *
 * @author djjav
 */
public class TestingClass {

    private static List<Ent_Producto> listProducts; // This list gets pulled on program loading

    // Pulls all of the products on program load
    public static void main(String[] args) {
        try {
            BL_Cliente cliente = new BL_Cliente();
            int idCliente = cliente.callClientIdByEmail(FinalVariables.ghostEmail);
            System.out.println(idCliente);
        } catch (Exception e) {
        }

        /*
        try {
            pullProductList("");
            String name = "Expresso";
            String description = "Pequeño";

            //System.out.println(findProductByNameDesc(name, description));
            productStockHandler(name, description);
        } catch (Exception e) {
            // Handle exceptions here
            e.printStackTrace();
        }*/
    }

    //load th list of products first
    private static void pullProductList(String condition) {
        try {
            BL_Producto productLogic = new BL_Producto();
            listProducts = productLogic.callListarProductos(condition); // Initialize the class-level variable
        } catch (Exception e) {
            // Handle exceptions here
            e.printStackTrace();
        }
    }

    // Executes a search by name and description (size) of the product and return the id
    private static int findProductByNameDesc(String productName, String productSize) {
        try {
            for (Ent_Producto product : listProducts) {
                if (product.getNombre_producto().equals(productName) && product.getDescripcion().equals(productSize)) {
                    // Producto encontrado, devuelve su ID
                    return product.getId_producto();
                }
            }
            // Product does not exist
            return -1;
        } catch (Exception e) {
            // Handle exceptions here
            e.printStackTrace();
            return -1;
        }
    }

    //retrieve the ids of all product to discount form database
    public static Ent_Accounting idsRetriever(String productName, String productDesc) {
        Ent_Accounting accounting = new Ent_Accounting();

        accounting.setId_cup(findProductByNameDesc(productName, productDesc));
        accounting.setId_straw(findProductByNameDesc("Pajilla", "Plástico"));//Plástico
        accounting.setId_coffee(findProductByNameDesc("Café", "Grano"));//Grano
        if (accounting.isWithSugar()) {
            accounting.setId_sugar(findProductByNameDesc("Azúcar", "Regular"));//Regular
        }
        if (accounting.isWithCream()) {
            accounting.setId_cream(findProductByNameDesc("Crema", "Polvo"));
        }
        if (accounting.isWithMilk()) {
            accounting.setId_milk(findProductByNameDesc("Leche", "Líquido"));
        }

        // Imprimir los IDs en la consola
        System.out.println("ID_straw: " + accounting.getId_straw());
        System.out.println("ID_cup: " + accounting.getId_cup());
        System.out.println("ID_coffee: " + accounting.getId_coffee());
        System.out.println("ID_sugar: " + accounting.getId_sugar());
        System.out.println("ID_cream: " + accounting.getId_cream());
        System.out.println("ID_milk: " + accounting.getId_milk());

        return accounting;
    }

    public static void productStockHandler(String productName, String productSize) {

        int id_straw = 0;
        int id_coffee = 0;
        int id_cup = 0;
        int id_sugar = 0;
        int id_crean = 0;
        int id_milk = 0;

        boolean withSugar = false;
        boolean withCream = false;
        boolean withMilk = false;

        switch (productName) {
            case "Expresso":
                switch (productSize) {
                    case "Pequeño":
                        idsRetriever(productName, productSize);

                        break;
                    case "Mediano":

                        break;
                    case "Grande":

                        break;
                }

                break;
            case "Negro":
                switch (productSize) {
                    case "Pequeño":

                        break;
                    case "Mediano":

                        break;
                    case "Grande":

                        break;
                }

                break;
            case "Latte":
                switch (productSize) {
                    case "Pequeño":

                        break;
                    case "Mediano":

                        break;
                    case "Grande":

                        break;
                }

                break;
            case "Cappuccino":
                switch (productSize) {
                    case "Pequeño":

                        break;
                    case "Mediano":

                        break;
                    case "Grande":

                        break;
                }

                break;
            case "Mocha":
                switch (productSize) {
                    case "Pequeño":

                        break;
                    case "Mediano":

                        break;
                    case "Grande":

                        break;
                }

                break;
            case "Con Leche":
                switch (productSize) {
                    case "Pequeño":

                        break;
                    case "Mediano":

                        break;
                    case "Grande":

                        break;
                }

                break;
            case "Brew":
                switch (productSize) {
                    case "Pequeño":

                        break;
                    case "Mediano":

                        break;
                    case "Grande":

                        break;
                }

                break;
            case "Irish":
                switch (productSize) {
                    case "Pequeño":

                        break;
                    case "Mediano":

                        break;
                    case "Grande":

                        break;
                }

                break;
            default:
                System.out.println("Invalid option selected");
                break;
        }
    }

}
