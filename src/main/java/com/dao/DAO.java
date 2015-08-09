package main.java.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO
{
    static final String  JDBC_DRIVER = "com.mysql.jdbc.Driver.";
    //static  String DB_URL = "jdbc:mysql://localhost/ModulSaver";
    static  String DB_URL = "jdbc:mysql://localhost/web";
    static  String USER = "root";
    static  String PASS = "alessandro";

    private Connection conn;

    public DAO() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
        }
        catch (Exception e){
            System.out.print(e.getMessage());
        }
    }

    public Connection getConnection(){
        return this.conn;
    }
    // Per inizializzare sia la password che user,la prima volta che verrá utilizzato il programma e ogni volta che verrá
    // ristartato il programma, visto che non sappiamo password e username dell utente(Vedi GUI.Main -> DBExists()
    public static void setPASS(String pASS) {
        PASS = pASS;
    }
    public static void setUSER(String uSER) {
        USER = uSER;
    }
    public static void setDB_URL(String dB_URL) {
        DB_URL = "jdbc:mysql://localhost/" + dB_URL;
    }

}
