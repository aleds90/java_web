package main.java.com.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


import main.java.com.entity.Modulo;

public class ModuloDAO extends DAO implements DAOInterface {

    private static final String INSERT_SQL = "INSERT INTO tblModulo ( idFornitore, idDestinatario,"
            + " idMerce, idTrasportatore, dataTrasporto, orarioTrasporto )";


    public ModuloDAO() throws SQLException {
        super();
    }

    public void insert(Modulo modulo) throws SQLException {

        PreparedStatement pstmt = null;
        pstmt = this.getConnection().prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
        pstmt.setInt(1, modulo.getIdFornitore());
        pstmt.setInt(2, modulo.getIdDestinatario());
        pstmt.setInt(3, modulo.getIdMerce());
        pstmt.setInt(4, modulo.getIdTrasportatore());
        pstmt.setDate(5, modulo.getDataTrasporto());
        pstmt.setTimestamp(6, modulo.getOrarioTrasporto());

        pstmt.executeUpdate();
        pstmt.close();
        this.getConnection().close();
    }

    @Override
    public int createTable() {
        int Result = 0;
        try {
            Statement createIndirizzostat = this.getConnection().createStatement();
            Result = createIndirizzostat.executeUpdate("CREATE TABLE `tblModulo` ( "+
                    "`idModulo` int(11) NOT NULL AUTO_INCREMENT,"+
                    "`idFornitore` int(11) NOT NULL, "+
                    "`idDestinatario` int(11) NOT NULL, "+
                    "`idMerce` int(11) NOT NULL, "+
                    "`idTrasportatore` int(11) NOT NULL, "+
                    "`dataTrasporto` datetime DEFAULT NULL, "+
                    "`orarioTrasporto` timestamp NULL DEFAULT NULL,"+
                    "PRIMARY KEY (`idModulo`),"+
                    "UNIQUE KEY `idModulo_UNIQUE` (`idModulo`),"+
                    "KEY `ModuloFornitore_idx` (`idFornitore`),"+
                    "KEY `ModuloDestinatario_idx` (`idDestinatario`),"+
                    "KEY `ModuloMerce_idx` (`idMerce`),"+
                    "KEY `ModuloTrasportatore_idx` (`idTrasportatore`),"+
                    "CONSTRAINT `ModuloFornitore` FOREIGN KEY (`idFornitore`) REFERENCES `tblfornitore` (`idFornitore`) ON DELETE NO ACTION ON UPDATE NO ACTION,"+
                    "CONSTRAINT `ModuloDestinatario` FOREIGN KEY (`idDestinatario`) REFERENCES `tbldestinatario` (`idDestinatario`) ON DELETE NO ACTION ON UPDATE NO ACTION,"+
                    "CONSTRAINT `ModuloMerce` FOREIGN KEY (`idMerce`) REFERENCES `tblmerce` (`idMerce`) ON DELETE NO ACTION ON UPDATE NO ACTION,"+
                    "CONSTRAINT `ModuloTrasportatore` FOREIGN KEY (`idTrasportatore`) REFERENCES `tbltrasportatore` (`idTrasportatore`) ON DELETE NO ACTION ON UPDATE NO ACTION "+
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");

            createIndirizzostat.close();
            this.getConnection().close();
            Result++;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result;

    }
}
