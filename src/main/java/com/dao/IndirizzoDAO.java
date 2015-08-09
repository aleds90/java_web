package main.java.com.dao;



import main.java.com.entity.Indirizzo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class IndirizzoDAO extends DAO implements DAOInterface {


    private static final String SELECT_SQL = "SELECT via, cap, citta FROM Indirzzo WHERE 1";
    private static final String INSERT_SQL = "INSERT INTO tblIndirizzo (via, cap, citta, provincia, nazione, commentiRegNaz )"
            + " VALUES (?, ?, ?, ?, ?, ?)";

    public IndirizzoDAO() throws SQLException {
        super();
    }

    public void insert(Indirizzo indirizzo) throws SQLException {

        PreparedStatement pstmt = null;
        pstmt = this.getConnection().prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, indirizzo.getVia());
        pstmt.setInt(2, indirizzo.getCap());
        pstmt.setString(3, indirizzo.getCitta());
        pstmt.setString(4, indirizzo.getProvincia());
        pstmt.setString(5, indirizzo.getNazione());
        pstmt.setString(6, indirizzo.getCommentiRegolamentoNazione());

        pstmt.executeUpdate();
        pstmt.close();
        this.getConnection().close();
    }

    public int createTable() {

        int Result = 0;
        try {
            Statement createIndirizzostat = this.getConnection().createStatement();
            Result = createIndirizzostat.executeUpdate("CREATE TABLE `tblIndirizzo` ("+
                    " `idtblIndirizzo` int(11) NOT NULL AUTO_INCREMENT,"+
                    "`via` varchar(45) NOT NULL,"+
                    "`cap` int(11) DEFAULT NULL,"+
                    "`citta` varchar(45) NOT NULL," +
                    "`provincia` varchar(45) DEFAULT NULL,"+
                    " `nazione` varchar(45) DEFAULT NULL,"+
                    " `commentiRegNaz` varchar(45) DEFAULT NULL,"+
                    " PRIMARY KEY (`idtblIndirizzo`)"+
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1");

            createIndirizzostat.close();
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
        ArrayList<Object> indirizzoList = new ArrayList();
        ArrayList<String> viaList = new ArrayList<>();
        ArrayList<Object> capList = new ArrayList<>();
        ArrayList<String> cittaList = new ArrayList<>();
        while (resultSet.next()) {
            viaList.add(resultSet.getString(1));
            capList.add(resultSet.getInt(2));
            cittaList.add(resultSet.getString(3));
        }
        indirizzoList.add(viaList);
        indirizzoList.add(capList);
        indirizzoList.add(cittaList);
        this.getConnection().close();
        return indirizzoList;

    }


}
