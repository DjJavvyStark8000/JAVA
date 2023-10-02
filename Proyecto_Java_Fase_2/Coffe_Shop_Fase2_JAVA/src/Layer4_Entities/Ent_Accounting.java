/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layer4_Entities;

/**
 *
 * @author djjav
 */
public class Ent_Accounting {

    //atributes
    private int id_straw;
    private int id_coffee;
    private int id_cup;
    private int id_sugar;
    private int id_cream;
    private int id_milk;
    private boolean withSugar;
    private boolean withCream;
    private boolean withMilk;

    public Ent_Accounting() {
        this.id_straw = 0;
        this.id_coffee = 0;
        this.id_cup = 0;
        this.id_sugar = 0;
        this.id_cream = 0;
        this.id_milk = 0;
        this.withSugar = true;
        this.withCream = true;
        this.withMilk = true;
    }

    public Ent_Accounting(int id_straw, int id_coffee, int id_cup, int id_sugar, int id_crean, int id_milk, boolean withSugar, boolean withCream, boolean withMilk) {
        this.id_straw = id_straw;
        this.id_coffee = id_coffee;
        this.id_cup = id_cup;
        this.id_sugar = id_sugar;
        this.id_cream = id_crean;
        this.id_milk = id_milk;
        this.withSugar = withSugar;
        this.withCream = withCream;
        this.withMilk = withMilk;
    }

    public int getId_straw() {
        return id_straw;
    }

    public void setId_straw(int id_straw) {
        this.id_straw = id_straw;
    }

    public int getId_coffee() {
        return id_coffee;
    }

    public void setId_coffee(int id_coffee) {
        this.id_coffee = id_coffee;
    }

    public int getId_cup() {
        return id_cup;
    }

    public void setId_cup(int id_cup) {
        this.id_cup = id_cup;
    }

    public int getId_sugar() {
        return id_sugar;
    }

    public void setId_sugar(int id_sugar) {
        this.id_sugar = id_sugar;
    }

    public int getId_cream() {
        return id_cream;
    }

    public void setId_cream(int id_crean) {
        this.id_cream = id_crean;
    }

    public int getId_milk() {
        return id_milk;
    }

    public void setId_milk(int id_milk) {
        this.id_milk = id_milk;
    }

    public boolean isWithSugar() {
        return withSugar;
    }

    public void setWithSugar(boolean withSugar) {
        this.withSugar = withSugar;
    }

    public boolean isWithCream() {
        return withCream;
    }

    public void setWithCream(boolean withCream) {
        this.withCream = withCream;
    }

    public boolean isWithMilk() {
        return withMilk;
    }

    public void setWithMilk(boolean withMilk) {
        this.withMilk = withMilk;
    }


}
