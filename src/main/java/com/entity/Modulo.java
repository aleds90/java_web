package main.java.com.entity;


import java.sql.Date;
import java.sql.Timestamp;

public class Modulo {

    private int idModulo;
    private int idFornitore;
    private int idDestinatario;
    private int idMerce;
    private int idTrasportatore;
    private Date dataTrasporto;
    private Timestamp orarioTrasporto;
    public int getIdModulo() {
        return idModulo;
    }
    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }
    public int getIdFornitore() {
        return idFornitore;
    }
    public void setIdFornitore(int idFornitore) {
        this.idFornitore = idFornitore;
    }
    public int getIdDestinatario() {
        return idDestinatario;
    }
    public void setIdDestinatario(int idDestinatario) {
        this.idDestinatario = idDestinatario;
    }
    public int getIdMerce() {
        return idMerce;
    }
    public void setIdMerce(int idMerce) {
        this.idMerce = idMerce;
    }
    public int getIdTrasportatore() {
        return idTrasportatore;
    }
    public void setIdTrasportatore(int idTrasportatore) {
        this.idTrasportatore = idTrasportatore;
    }
    public Date getDataTrasporto() {
        return dataTrasporto;
    }
    public void setDataTrasporto(Date dataTrasporto) {
        this.dataTrasporto = dataTrasporto;
    }
    public Timestamp getOrarioTrasporto() {
        return orarioTrasporto;
    }
    public void setOrarioTrasporto(Timestamp orarioTrasporto) {
        this.orarioTrasporto = orarioTrasporto;
    }





}
