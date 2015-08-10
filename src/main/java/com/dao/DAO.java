package main.java.com.dao;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DAO
{
    private Connection conn;

    public DAO() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            //Recupero dati dal file di properties
            Properties properties   = new Properties();
            InputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/config.properties");
            properties.load(inputStream);

            String dbUrl    = properties.getProperty("DBURL");
            String dbName   = properties.getProperty("DBNAME");
            String dbUsr    = properties.getProperty("DBUSER");
            String dbPass   = properties.getProperty("DBPASS");

            this.conn = DriverManager.getConnection(dbUrl + dbName, dbUsr, dbPass);
        }
        catch (Exception e){
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return this.conn;
    }

}
