package main.java.com.dao;



import main.java.com.entity.Trasportatore;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TrasportatoreDAO extends DAO implements DAOInterface{

    private static final String INSERT_SQL = "INSERT INTO tblTrasportatore  (nomeTrasportatore, targaTrasportatore) VALUES (?, ?)";
    private static final String SELECT_SQL = "SELECT NameTrasportatore FROM Trasportatore WHERE NameTrasportatore";

    public TrasportatoreDAO() throws SQLException {
        super();
    }

    public void insert (Trasportatore trasportatore) throws SQLException{

        PreparedStatement pstmt=null;
        pstmt = this.getConnection().prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, trasportatore.getNameTrasportatore());
        pstmt.setString(2, trasportatore.getTargaMezzo());
        pstmt.executeUpdate();
        pstmt.close();
        this.getConnection().close();
    }

    public int createTable(){

        int Result = 0;
        try{
            Statement createDestinatariostat = this.getConnection().createStatement();
            Result = createDestinatariostat.executeUpdate("CREATE TABLE `tblTrasportatore` "
                    + "(`idTrasportatore` int(11) NOT NULL AUTO_INCREMENT,"
                    + "`nomeTrasportatore` varchar(45) NOT NULL,"
                    + "`targaTrasportatore` varchar(45) DEFAULT NULL,"
                    + "PRIMARY KEY (`idTrasportatore`),"
                    + "UNIQUE KEY `idTrasportatore_UNIQUE` (`idTrasportatore`))"
                    + " ENGINE=InnoDB DEFAULT CHARSET=latin1");

            createDestinatariostat.close();
            this.getConnection().close();
            Result++;
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result;
    }

    public ArrayList<Object> getAll() throws SQLException{

        PreparedStatement pStatement = this.getConnection().prepareStatement(SELECT_SQL);
        //pStatement.setString(1, "%" + Name+"%" + "%");
        ResultSet resultSet = pStatement.executeQuery();
        //pStatement.close();
        ArrayList<Object> trasportatoreList = new ArrayList();
        while(resultSet.next()){
            trasportatoreList.add(resultSet.getString(1));
        }
        this.getConnection().close();
        return trasportatoreList;
    }

}
