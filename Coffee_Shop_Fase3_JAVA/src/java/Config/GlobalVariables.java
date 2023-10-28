/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

/**
 *
 * @author djjav
 */
public class GlobalVariables {

    // Declare a static variable to hold the user value
    private static String rolePosition = "Administrador";
    private static String userOnDuty = "";

    // Method to get the current user value
    public static String getRole() {
        return rolePosition;
    }

    // Method to set a new value to the user variable
    public static void setRole(String newRole) {
        rolePosition = newRole;
    }

    // Method to get the current user value
    public static String getUser() {
        return userOnDuty;
    }

    // Method to set a new value to the user variable
    public static void setUser(String newUser) {
        rolePosition = newUser;
    }
}
