package main.java.com.entity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class Fornitore {

    private int idFornitore;
    private String nomeFornitore;
    private int partitaIva;

    public Fornitore(){}

    public int getIdFornitore() {
        return idFornitore;
    }

    public void setIdFornitore(int idFornitore) {
        this.idFornitore = idFornitore;
    }

    public String getNomeFornitore() {
        return nomeFornitore;
    }

    public void setNameFornitore(String nameFornitore) {
        this.nomeFornitore = nameFornitore;
    }


    public int getPartitaIva() {
        return partitaIva;
    }

    public void setPartitaIva(int partitaIva) {
        this.partitaIva = partitaIva;
    }
}
