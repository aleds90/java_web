package main.java.com.dao;

import main.java.com.entity.Destinatario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Alessandro on 09/08/2015.
 */
public class DestinatarioDAO extends DAO implements DAOInterface
{
    private static final String INSERT_SQL = "INSERT INTO tblDestinatario (nomeDestinatario) VALUES (?)";
    private static final String SELECT_SQL = "SELECT NameDestinatario FROM Destinatario WHERE 1";
    private static final String GETDESTINATARIOBYNAME = "SELECT NameDestinatario, viaIndirizzo, PIVA FROM Destinatario WHERE NameDestinatario = ?";

    public DestinatarioDAO() throws SQLException {
        super();
    }

    public void insert(Destinatario destinatario) throws SQLException {

        PreparedStatement pstmt = null;
        pstmt = this.getConnection().prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, destinatario.getNameDestinatario());
        pstmt.executeUpdate();
        pstmt.close();
        this.getConnection().close();
    }


    public int createTable() {

        int Result = 0;
        try {

            Statement createDestinatariostat = this.getConnection().createStatement();

            Result = createDestinatariostat.executeUpdate("CREATE TABLE `tblDestinatario`"
                    + " (`idDestinatario` int(11) NOT NULL AUTO_INCREMENT,"
                    + " `nomeDestinatario` varchar(45) DEFAULT NULL,"
                    + " PRIMARY KEY (`idDestinatario`),"
                    + " UNIQUE KEY `idDestinatario_UNIQUE` (`idDestinatario`),"
                    + " UNIQUE KEY `nomeDestinatario_UNIQUE` (`nomeDestinatario`) ) "
                    + "ENGINE=InnoDB DEFAULT CHARSET=latin1");

            createDestinatariostat.close();
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
        ArrayList<Object> destinatarioList = new ArrayList();
        while (resultSet.next()) {
            destinatarioList.add(resultSet.getString(1));
        }
        this.getConnection().close();
        return destinatarioList;
    }
}
