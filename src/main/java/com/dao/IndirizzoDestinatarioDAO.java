package main.java.com.dao;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


import main.java.com.entity.Destinatario;
import main.java.com.entity.Indirizzo;

public class IndirizzoDestinatarioDAO extends DAO implements DAOInterface {

    private static final String INSERT_SQL = "INSERT INTO tlbIndirizzoDestinatario (idIndirizzo, idDestinatario) VALUES (?, ?)";


    public IndirizzoDestinatarioDAO() throws SQLException {
        super();

    }

    public void insert(Indirizzo indirizzo, Destinatario destinatario) throws SQLException {

        PreparedStatement pstmt = null;
        pstmt = this.getConnection().prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
        pstmt.setInt(1, indirizzo.getId());
        pstmt.setInt(2, destinatario.getId());
        pstmt.executeUpdate();
        pstmt.close();
        this.getConnection().close();
    }

    @Override
    public int createTable() {
        int Result = 0;
        try {

            Statement createDestinatariostat = this.getConnection().createStatement();

            Result = createDestinatariostat.executeUpdate("CREATE TABLE `tlbIndirizzoDestinatario`"
                    + " (`idDestinatario` INT(11) NOT NULL,"
                    + "`idIndirizzo` INT(11) NOT NULL,"
                    + "UNIQUE KEY `idDestinatario_UNIQUE` (`idDestinatario`),"
                    + "KEY `idIndirizzo_idx` (`idIndirizzo`),"
                    + "CONSTRAINT `idDestinatario` FOREIGN KEY (`idDestinatario`)"
                    + "REFERENCES `tbldestinatario` (`idDestinatario`)"
                    + "ON DELETE NO ACTION ON UPDATE NO ACTION,"
                    + "CONSTRAINT `idIndirizzo` FOREIGN KEY (`idIndirizzo`)"
                    + "REFERENCES `tblindirizzo` (`idtblIndirizzo`)"
                    + "ON DELETE NO ACTION ON UPDATE NO ACTION)"
                    + "ENGINE=INNODB DEFAULT CHARSET=LATIN1");


            createDestinatariostat.close();
            this.getConnection().close();
            Result++;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return Result;
    }




}

