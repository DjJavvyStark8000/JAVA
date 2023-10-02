/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import Layer4_Entities.Ent_Accounting;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author djjav
 */
public class Substracting {

    public static String getProductSize() {
        return productSize;
    }

    public static void setProductSize(String aProductSize) {
        productSize = aProductSize;
    }

    private static final BigDecimal cupSmallSize = new BigDecimal("12.00");//small amount 
    private static final BigDecimal cupMediumSize = new BigDecimal("16.00");//medium amount
    private static final BigDecimal cupLargeSize = new BigDecimal("20.00");//large amount
    private static BigDecimal cupSize = BigDecimal.ZERO;//large amount//tamaño de la copa de café
    private static String sellingProduct = "Negro";
    private static String productSize = "Pequeño";
    private static BigDecimal unitPrice = BigDecimal.ZERO;
    private static BigDecimal strawQuantity = BigDecimal.ZERO;
    private static BigDecimal orderQuantity = BigDecimal.ZERO;
    private static BigDecimal sugarQuantity = BigDecimal.ZERO;
    private static BigDecimal creamQuantity = BigDecimal.ZERO;
    private static BigDecimal milkQuantity = BigDecimal.ZERO;
    private static String employee = GlobalVariables.getUser();//el que atiende al cliente
    private static int idCliente = 0;//el cliente talvez no existe hay que buscarlo por correo o perdirlo para crearlo 
    private static String estadoPago = "Pendiente";
    private static BigDecimal theDiscount = BigDecimal.ZERO;
    private static String fechaActual = "";
    private static String horaActual = "";
    private static BigDecimal subTotal = BigDecimal.ZERO;
    private static BigDecimal bruteTotal = BigDecimal.ZERO;
    private static BigDecimal theTax = BigDecimal.ZERO;
    private static BigDecimal netTotal = BigDecimal.ZERO;
    private static List<BigDecimal> subTotalList = new ArrayList<>();
    private static boolean withSugar = false;
    private static boolean withCream = false;
    private static boolean withMilk = false;

    public Substracting() {
        // Obtén la fecha actual y la hora actual
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        // Formatea la fecha como una cadena de texto en el formato deseado
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        fechaActual = currentDate.format(dateFormat);
        horaActual = currentTime.format(timeFormat);
    }

    public static void main(String[] args) {
        BigDecimal test = taxTotal();
        System.out.println(test);
    }

    // Getter and Setter for cupSize
    public static BigDecimal getCupSize() {
        return cupSize;
    }

    public static void setCupSize(BigDecimal cupSize) {
        Substracting.cupSize = cupSize;
    }

    // Getter and Setter for productName
    public static String getProductName() {
        return sellingProduct;
    }

    public static void setProductName(String productName) {
        Substracting.sellingProduct = productName;
    }

    // Getter and Setter for orderQuantity
    public static BigDecimal getOrderQuantity() {
        return orderQuantity;
    }

    public static void setOrderQuantity(BigDecimal orderQuantity) {
        Substracting.orderQuantity = orderQuantity;
    }

    // Getter and Setter for employee
    public static String getEmployee() {
        return employee;
    }

    public static void setEmployee(String employee) {
        Substracting.employee = employee;
    }

    // Getter and Setter for idCliente
    public static int getIdCliente() {
        return idCliente;
    }

    public static void setIdCliente(int idCliente) {
        Substracting.idCliente = idCliente;
    }

    // Getter and Setter for estadoPago
    public static String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        Substracting.estadoPago = estadoPago;
    }

    // Getter and Setter for theDiscount
    public static BigDecimal getTheDiscount() {
        return theDiscount;
    }

    public static void setTheDiscount(BigDecimal theDiscount) {
        Substracting.theDiscount = theDiscount;
    }

    // Getter and Setter for fechaActual
    public static String getFechaActual() {
        return fechaActual;
    }

    public static void setFechaActual(String fechaActual) {
        Substracting.fechaActual = fechaActual;
    }

    // Getter and Setter for horaActual
    public static String getHoraActual() {
        return horaActual;
    }

    public static void setHoraActual(String horaActual) {
        Substracting.horaActual = horaActual;
    }

    // Getter and Setter for subTotal
    public static BigDecimal getSubTotal() {
        return subTotal;
    }

    public static void setSubTotal(BigDecimal subTotal) {
        Substracting.subTotal = subTotal;
    }

    // Getter and Setter for subTotal
    public static BigDecimal getBruteTotal() {
        return bruteTotal;
    }

    public static void setBruteTotal(BigDecimal bruteTotal) {
        Substracting.bruteTotal = bruteTotal;
    }

    // Getter and Setter for netTotal
    public static BigDecimal getNetTotal() {
        return netTotal;
    }

    public static void setNetTotal(BigDecimal netTotal) {
        Substracting.netTotal = netTotal;
    }

    // Getter for cupSmallSize
    public static BigDecimal getCupSmallSize() {
        return cupSmallSize;
    }

    // Getter for cupMediumSize
    public static BigDecimal getCupMediumSize() {
        return cupMediumSize;
    }

    // Getter for cupLargeSize
    public static BigDecimal getCupLargeSize() {
        return cupLargeSize;
    }

    // Getter for sugarQuantity
    public static BigDecimal getSugarQuantity() {
        return sugarQuantity;
    }

    // Setter for sugarQuantity
    public static void setSugarQuantity(BigDecimal sugarQuantity) {
        Substracting.sugarQuantity = sugarQuantity;
    }

    // Getter for strawQuantity
    public static BigDecimal getStrawQuantity() {
        return strawQuantity;
    }

    // Setter for strawQuantity
    public static void setStrawQuantity(BigDecimal strawQuantity) {
        Substracting.strawQuantity = strawQuantity;
    }

    // Getter for creamQuantity
    public static BigDecimal getCreamQuantity() {
        return creamQuantity;
    }

    // Setter for creamQuantity
    public static void setCreamQuantity(BigDecimal creamQuantity) {
        Substracting.creamQuantity = creamQuantity;
    }

    // Getter for milkQuantity
    public static BigDecimal getMilkQuantity() {
        return milkQuantity;
    }

    // Setter for creamQuantity
    public static void setMilkQuantity(BigDecimal milkQuantity) {
        Substracting.milkQuantity = milkQuantity;
    }

    // Getter for unitPrice
    public static BigDecimal getUnitPrice() {
        return unitPrice;
    }

    // Setter for unitPrice
    public static void setUnitPrice(BigDecimal unitPrice) {
        Substracting.unitPrice = unitPrice;
    }

    // Getter and Setter for afterTax
    public static BigDecimal getTheTax() {
        return theTax;
    }

    public static void setTheTax(BigDecimal theTax) {
        Substracting.theTax = theTax;
    }

    // Getter method for withSugar
    public static boolean isWithSugar() {
        return withSugar;
    }

    // Setter method for withSugar
    public static void setWithSugar(boolean withSugar) {
        Substracting.withSugar = withSugar;
    }

    // Getter method for withCream
    public static boolean isWithCream() {
        return withCream;
    }

    // Setter method for withCream
    public static void setWithCream(boolean withCream) {
        Substracting.withCream = withCream;
    }

    // Getter method for withMilk
    public static boolean isWithMilk() {
        return withMilk;
    }

    // Setter method for withMilk
    public static void setWithMilk(boolean withMilk) {
        Substracting.withMilk = withMilk;
    }

    //Make the math for product price
    public static BigDecimal productPriceUnit() {
        BigDecimal unitPrice = BigDecimal.ZERO;
        if (Substracting.getProductName() == "Expresso" || Substracting.getProductName() == "Negro") {
            unitPrice = FinalVariables.priceOzCoffee.multiply(Substracting.cupSize);//only coffee
            unitPrice = unitPrice.setScale(2, RoundingMode.HALF_UP);//format 2 digits
            Substracting.setUnitPrice(unitPrice);
        } else if (Substracting.getProductName() == "WithMilk") {
            unitPrice = FinalVariables.priceOzCoffee.multiply(Substracting.cupSize);//only coffee
            unitPrice = unitPrice.add(FinalVariables.priceWithMilk);//add milk to it
            unitPrice = unitPrice.setScale(2, RoundingMode.HALF_UP);//format 2 digits
            Substracting.setUnitPrice(unitPrice);
        } else if (Substracting.getProductName() == "Latte" || Substracting.getProductName() == "Cappuccino"
                || Substracting.getProductName() == "Mocha" || Substracting.getProductName() == "Brew"
                || Substracting.getProductName() == "Irish") {
            unitPrice = FinalVariables.priceOzCoffee.multiply(Substracting.cupSize);//only coffee
            unitPrice = unitPrice.add(FinalVariables.priceWithMilk);//add milk to it
            unitPrice = unitPrice.add(FinalVariables.priceWithCream);//add milk to it
            unitPrice = unitPrice.setScale(2, RoundingMode.HALF_UP);//format 2 digits
            Substracting.setUnitPrice(unitPrice);
        }
        return Substracting.getUnitPrice();
    }

    //get the subtotal from each purchase
    public static BigDecimal productSubTotal() {
        BigDecimal theSubTotal = Substracting.getOrderQuantity().multiply(Substracting.getUnitPrice());
        theSubTotal = theSubTotal.setScale(2, RoundingMode.HALF_UP);//format 2 digits
        Substracting.setSubTotal(theSubTotal);
        subTotalList.add(theSubTotal);
        return Substracting.getSubTotal();
    }

    //get the subtotal from each purchase
    public static BigDecimal productBruteTotal() {

        // Calculate the total of all subtotals
        BigDecimal totalSubtotals = BigDecimal.ZERO;
        for (BigDecimal subtotal : subTotalList) {
            totalSubtotals = totalSubtotals.add(subtotal);
        }
        totalSubtotals = totalSubtotals.setScale(2, RoundingMode.HALF_UP);//format 2 digits
        Substracting.setBruteTotal(totalSubtotals);
        return Substracting.getBruteTotal();
    }

    //get the tax total
    public static BigDecimal taxTotal() {
        BigDecimal productBruteTotal = productBruteTotal();
        BigDecimal theTax = FinalVariables.ivaTax.multiply(productBruteTotal);
        theTax = theTax.setScale(2, RoundingMode.HALF_UP);//format 2 digits
        Substracting.setTheTax(theTax);
        return theTax;
    }

    //get the discount total
    public static BigDecimal discountTotal() {
        BigDecimal bruteruteTotal = productBruteTotal();
        BigDecimal taxTotal = taxTotal();
        BigDecimal withTax = bruteruteTotal.add(taxTotal);
        BigDecimal theDiscount = withTax.multiply(FinalVariables.applyDiscount);
        theDiscount = theDiscount.setScale(2, RoundingMode.HALF_UP);//format 2 digits
        Substracting.setTheDiscount(theDiscount);
        return Substracting.getTheDiscount();
    }

    //get the net total
    public static BigDecimal netTotal() {
        BigDecimal bruteruteTotal = productBruteTotal();
        BigDecimal taxTotal = taxTotal();
        BigDecimal withTax = bruteruteTotal.add(taxTotal);
        BigDecimal theDiscount = withTax.multiply(FinalVariables.applyDiscount);
        BigDecimal netTotal = withTax.subtract(theDiscount);
        netTotal = netTotal.setScale(2, RoundingMode.HALF_UP);//format 2 digits
        Substracting.setNetTotal(netTotal);
        return Substracting.getNetTotal();
    }
}
