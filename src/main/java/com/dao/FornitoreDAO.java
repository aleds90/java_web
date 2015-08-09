package main.java.com.dao;



import main.java.com.entity.Fornitore;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FornitoreDAO extends DAO implements DAOInterface {

    private static final String INSERT_SQL = "INSERT INTO tblFornitore (nomeFornitore, partitaIvaFornitore) VALUES (?, ?)";
    private static final String SELECT_SQL = "SELECT NameFornitore FROM Fornitore WHERE 1";
    private static final String SELECT_BY_ID = "SELECT * FROM tblFornitore WHERE idFornitore=(?)";
    private static final String SELECT_SQ_BY_NAME = "";


    public FornitoreDAO() throws SQLException {
        super();
    }

    public Fornitore getbyid(Integer id) throws SQLException
    {

        PreparedStatement pStatement = this.getConnection().prepareStatement(SELECT_BY_ID);
        pStatement.setInt(1, id);
        ResultSet resultSet = pStatement.executeQuery();
        Fornitore fornitore = new Fornitore();
        while (resultSet.next()){
            fornitore.setIdFornitore(resultSet.getInt("idFornitore"));
            fornitore.setNameFornitore(resultSet.getString("nomeFornitore"));
            fornitore.setPartitaIva(resultSet.getInt("partitaIvaFornitore"));
        }
        return fornitore;

    }

    public void insert(Fornitore fornitore) throws SQLException {


        // Colonne AUTO_INCREMENT posso essere autogenerate con il metodo RETURN_GENERATED_KEYS
        PreparedStatement pstmt = null;
        pstmt = this.getConnection().prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, fornitore.getNomeFornitore());
        pstmt.setInt(2, fornitore.getPartitaIva());
        pstmt.executeUpdate();
        pstmt.close();
        this.getConnection().close(); //si assume la modalita? autocommit

    }

    public int createTable() {
        int Result = 0;
        try {

            Statement createFornitorestat = this.getConnection().createStatement();
            Result = createFornitorestat.executeUpdate("CREATE TABLE `tblFornitore` "
                    + "(`idFornitore` int(11) NOT NULL AUTO_INCREMENT,"
                    + "`nomeFornitore` varchar(45) NOT NULL,"
                    + "`partitaIvaFornitore` int(11) DEFAULT NULL,"
                    + "PRIMARY KEY (`idFornitore`),"
                    + "UNIQUE KEY `nomeFornitore_UNIQUE` "
                    + "(`nomeFornitore`)) ENGINE=InnoDB DEFAULT CHARSET=latin1");


            createFornitorestat.close();
            this.getConnection().close();
            Result++;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return Result;
    }


    public ArrayList<Object> getAll() throws SQLException {

        PreparedStatement pStatement = this.getConnection().prepareStatement(SELECT_SQL);
        //pStatement.setString(1, "%" + Name+"%" + "%");
        ResultSet resultSet = pStatement.executeQuery();
        //pStatement.close();
        ArrayList<Object> fornitoreList = new ArrayList();
        while (resultSet.next()) {
            fornitoreList.add(resultSet.getString(1));
        }
        this.getConnection().close();
        return fornitoreList;
    }

    public ArrayList<Object> getByName(String name){
        ArrayList<Object> fornitoreList = new ArrayList();
        return  fornitoreList;
    }
}
