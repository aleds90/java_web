package main.java.com.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


import main.java.com.entity.Fornitore;
import main.java.com.entity.Indirizzo;

public class IndirizzoFornitoreDAO extends DAO implements DAOInterface {

    private static final String INSERT_SQL = "INSERT INTO tblIndirizzoFornitore (idIndirizzo, idFornitore) VALUES (?, ?)";


    public IndirizzoFornitoreDAO() throws SQLException {
        super();

    }

    public void insert(Indirizzo indirizzo, Fornitore fornitore) throws SQLException {

        PreparedStatement pstmt = null;
        pstmt = this.getConnection().prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
        pstmt.setInt(1, indirizzo.getId());
        pstmt.setInt(2, fornitore.getIdFornitore());
        pstmt.executeUpdate();
        pstmt.close();
        this.getConnection().close();
    }

    @Override
    public int createTable() {
        int Result = 0;
        try {

            Statement createDestinatariostat = this.getConnection().createStatement();

            Result = createDestinatariostat.executeUpdate("CREATE TABLE `tblIndirizzoFornitore` "
                    + "(`idIndirizzo` int(11) NOT NULL,"
                    + "`idFornitore` int(11) NOT NULL,"
                    + "UNIQUE KEY `idIndirizzo_UNIQUE` (`idIndirizzo`),"
                    + "KEY `idForn_idx` (`idFornitore`),"
                    + "CONSTRAINT `idForn` FOREIGN KEY (`idFornitore`) REFERENCES `tblfornitore` (`idFornitore`) ON DELETE NO ACTION ON UPDATE NO ACTION,"
                    + "CONSTRAINT `idInd` FOREIGN KEY (`idIndirizzo`) REFERENCES `tblindirizzo` (`idtblIndirizzo`) ON DELETE NO ACTION ON UPDATE NO ACTION)"
                    + " ENGINE=InnoDB DEFAULT CHARSET=latin1");

            createDestinatariostat.close();
            this.getConnection().close();
            Result++;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return Result;
    }




}

