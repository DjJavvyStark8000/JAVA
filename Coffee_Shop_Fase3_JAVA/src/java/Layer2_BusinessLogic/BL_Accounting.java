/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layer2_BusinessLogic;

import Config.FinalVariables;
import Config.Substracting;
import Layer4_Entities.Ent_EncabezadoFactura;
import Layer4_Entities.Ent_Producto;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author djjav
 */
public class BL_Accounting {

    private static List<Ent_Producto> listProducts; // This list gets pulled on program loading
    private static int id_straw;
    private static int id_coffee;
    private static int id_small_cup;
    private static int id_medium_cup;
    private static int id_large_cup;
    private static int id_sugar;
    private static int id_cream;
    private static int id_milk;
    private static boolean exists;

    // Pulls all of the products on program load
    public static void main(String[] args) {
        try {
            pullProductList("");
            String name = "Expresso";
            String description = "Pequeño";

        } catch (Exception e) {
            // Handle exceptions here
            e.printStackTrace();
        }
    }

    //load th list of products first
    public static void pullProductList(String condition) {
        try {
            BL_Producto productLogic = new BL_Producto();
            setListProducts(productLogic.callListarProductos(condition)); // Initialize the class-level variable
        } catch (Exception e) {
            // Handle exceptions here
            e.printStackTrace();
        }
    }

    // Executes a search by name and description (size) of the product and return the id
    public static int findProductByNameDesc(String productName, String description) {
        try {
            for (Ent_Producto product : getListProducts()) {
                if (product.getNombre_producto().equals(productName) && product.getDescripcion().equals(description)) {
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

    public static void grabProductsIds() {
        setId_coffee(findProductByNameDesc("Café", "Grano"));
        setId_straw(findProductByNameDesc("Pajilla", "Plástico"));
        setId_small_cup(findProductByNameDesc("Copa", "Pequeño"));
        setId_medium_cup(findProductByNameDesc("Copa", "Mediano"));
        setId_large_cup(findProductByNameDesc("Copa", "Grande"));
        setId_sugar(findProductByNameDesc("Azúcar", "Regular"));
        setId_cream(findProductByNameDesc("Crema", "Polvo"));
        setId_milk(findProductByNameDesc("Leche", "Líquido"));
        if (getId_coffee() > 0 && getId_straw() > 0 && getId_small_cup() > 0 && getId_medium_cup() > 0 && getId_large_cup() > 0
                && getId_sugar() > 0 && getId_cream() > 0 && getId_milk() > 0) {
            setExists(true);
        }
    }

    //grabs the product from data base and make the math to substract for quantity form the data base and update product
    public static void grabProductToUpdate(String condition, BigDecimal thisQuantity) {
        try {
            // grab the original product
            BL_Producto productLogic = new BL_Producto();
            Ent_Producto pullProducto = productLogic.callObtenerProducto(condition);

            if (pullProducto != null) {
                // calculate the new quantity
                BigDecimal newQuantity = pullProducto.getCantidad().subtract(thisQuantity);

                // create a modified version with the new quantity to overwrite
                Ent_Producto createProducto = new Ent_Producto();
                createProducto.setNombre_producto(pullProducto.getNombre_producto());
                createProducto.setDescripcion(pullProducto.getDescripcion());
                createProducto.setCantidad(newQuantity);
                createProducto.setUnidad(pullProducto.getUnidad());
                createProducto.setPrecio_unitario(pullProducto.getPrecio_unitario());
                createProducto.setId_producto(pullProducto.getId_producto());

                // update the product in the database
                productLogic.callModificarProducto(createProducto);
            } else {
                JOptionPane.showMessageDialog(null, "El producto no existe", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha sucedido un error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static List<Ent_Producto> getListProducts() {
        return listProducts;
    }

    public static void setListProducts(List<Ent_Producto> aListProducts) {
        listProducts = aListProducts;
    }

    public static int getId_straw() {
        return id_straw;
    }

    public static void setId_straw(int aId_straw) {
        id_straw = aId_straw;
    }

    public static int getId_coffee() {
        return id_coffee;
    }

    public static void setId_coffee(int aId_coffee) {
        id_coffee = aId_coffee;
    }

    public static int getId_small_cup() {
        return id_small_cup;
    }

    public static void setId_small_cup(int aId_small_cup) {
        id_small_cup = aId_small_cup;
    }

    public static int getId_medium_cup() {
        return id_medium_cup;
    }

    public static void setId_medium_cup(int aId_medium_cup) {
        id_medium_cup = aId_medium_cup;
    }

    public static int getId_large_cup() {
        return id_large_cup;
    }

    public static void setId_large_cup(int aId_large_cup) {
        id_large_cup = aId_large_cup;
    }

    public static int getId_sugar() {
        return id_sugar;
    }

    public static void setId_sugar(int aId_sugar) {
        id_sugar = aId_sugar;
    }

    public static int getId_cream() {
        return id_cream;
    }

    public static void setId_cream(int aId_cream) {
        id_cream = aId_cream;
    }

    public static int getId_milk() {
        return id_milk;
    }

    public static void setId_milk(int aId_milk) {
        id_milk = aId_milk;
    }

    public static boolean isExists() {
        return exists;
    }

    public static void setExists(boolean aExists) {
        exists = aExists;
    }

    public BL_Accounting() {
        this.id_straw = 0;
        this.id_coffee = 0;
        this.id_small_cup = 0;
        this.id_medium_cup = 0;
        this.id_large_cup = 0;
        this.id_sugar = 0;
        this.id_cream = 0;
        this.id_milk = 0;
    }

    public BL_Accounting(int id_straw, int id_coffee, int id_small_cup, int id_medium_cup, int id_large_cup,
            int id_sugar, int id_cream, int id_milk) {
        BL_Accounting.id_straw = id_straw;
        BL_Accounting.id_coffee = id_coffee;
        BL_Accounting.id_small_cup = id_small_cup;
        BL_Accounting.id_medium_cup = id_medium_cup;
        BL_Accounting.id_large_cup = id_large_cup;
        BL_Accounting.id_sugar = id_sugar;
        BL_Accounting.id_cream = id_cream;
        BL_Accounting.id_milk = id_milk;
    }

}
