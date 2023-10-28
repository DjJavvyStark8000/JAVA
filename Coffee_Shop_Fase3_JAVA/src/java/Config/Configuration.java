/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author djjav
 */
public final class Configuration {

    public static String getConnection() throws ClassNotFoundException {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return "jdbc:sqlserver://localhost:1433;databasename=COFFEE_SHOP_DB;user=sa;password=sa;";

    }
}

/*
public final class Config {
    public static String getConnectionString()throws ClassNotFoundException{
       
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    return "jdbc:sqlserver://localhost:1433;databasename=CAPAS_JAVA_WEB_2023;user=sa;password=Mcx8000$$$";
    }
}
*/
