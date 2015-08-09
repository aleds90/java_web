package main.java.com.dao;


import main.java.com.entity.Merce;

import javax.xml.transform.Result;
import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class MerceDAO extends DAO implements DAOInterface {

    public static final String SELECT_SQL = "SELECT tipoMerce, quantitaMerce,pesoLordo from Merce WHERE 1";
    public static final String INSERT_SQL = "INSERT INTO tblMerce (tipoMerce, quantitaMerce, pesoLordo, pesoNetto, densitaAmb,"
            + "densita15g) VALUES (?, ?, ?, ?, ?, ?)";

    public MerceDAO() throws SQLException{
        super();
    }

    public void insert (Merce merce) throws SQLException{

        PreparedStatement pstmt = null;
        pstmt = this.getConnection().prepareStatement(INSERT_SQL, java.sql.Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, merce.getTipoMerce());
        pstmt.setInt(2, merce.getQuantitativoMerce());
        pstmt.setDouble(3, merce.getPesoLordo());
        pstmt.setDouble(4, merce.getPesoNetto());
        pstmt.setDouble(5, merce.getDensitaAmb());
        pstmt.setDouble(6, merce.getDensita15g());

        pstmt.executeUpdate();
        pstmt.close();
        this.getConnection().close();
    }

    public int createTable() {

        int result = 0;
        try {
            java.sql.Statement createMercestat = this.getConnection().createStatement();
            result = createMercestat.executeUpdate("CREATE TABLE `tblMerce` ("
                    + "`idMerce` int(11) NOT NULL AUTO_INCREMENT,"
                    + "`tipoMerce` varchar(45) NOT NULL,"
                    + "`quantitaMerce` int(11) NOT NULL,"
                    + "`pesoLordo` double DEFAULT NULL,"
                    + "`pesoNetto` double DEFAULT NULL,"
                    + "`densitaAmb` double DEFAULT NULL,"
                    + "`densita15g` double DEFAULT NULL,"
                    + "PRIMARY KEY (`idMerce`),"
                    + "UNIQUE KEY `idMerce_UNIQUE` (`idMerce`))"
                    + " ENGINE=InnoDB DEFAULT CHARSET=latin1");

            createMercestat.close();
            this.getConnection().close();
            result++;
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public ArrayList<Object> getAll() throws Exception{

        PreparedStatement pStatement             = this.getConnection().prepareStatement(SELECT_SQL);
        ResultSet resultSet                      = pStatement.executeQuery();
        ArrayList<Object> merceList              = new ArrayList<>();
        ArrayList<String> tipoMerceList          = new ArrayList<>();
        ArrayList<Integer> quantitativoMerceList = new ArrayList<>();
        ArrayList<Integer> pesoLordoList         = new ArrayList<>();

        while ( resultSet.next()) {
            tipoMerceList.add(resultSet.getString(1));
            quantitativoMerceList.add(resultSet.getInt(2));
            pesoLordoList.add(resultSet.getInt(3));
        }

        merceList.add(tipoMerceList);
        merceList.add(quantitativoMerceList);
        merceList.add(pesoLordoList);
        this.getConnection().close();
        return merceList;
    }
}








