package main.java.com.entity;

/**
 * Created by Alessandro on 02/08/2015.
 */
public class Merce {
    private int idMerce;
    private String tipoMerce;
    private int quantitativoMerce;
    private double pesoLordo;
    private double pesoNetto;
    private double densitaAmb;
    private double densita15g;
    private boolean certificazioni;

    public Merce(){}

    public int getIdMerce() {
        return idMerce;
    }

    public void setIdMerce(int idMerce) {
        this.idMerce = idMerce;
    }

    public String getTipoMerce() {
        return tipoMerce;
    }

    public void setTipoMerce(String tipoMerce) {
        this.tipoMerce = tipoMerce;
    }

    public double getPesoLordo() {
        return pesoLordo;
    }

    public void setPesoLordo(double pesoLordo) {
        this.pesoLordo = pesoLordo;
    }

    public int getQuantitativoMerce() {
        return quantitativoMerce;
    }

    public void setQuantitativoMerce(int quantitativoMerce) {
        this.quantitativoMerce = quantitativoMerce;
    }

    public double getPesoNetto() {
        return pesoNetto;
    }

    public void setPesoNetto(double pesoNetto) {
        this.pesoNetto = pesoNetto;
    }

    public double getDensita15g() {
        return densita15g;
    }

    public void setDensita15g(double densita15g) {
        this.densita15g = densita15g;
    }

    public double getDensitaAmb() {
        return densitaAmb;
    }

    public void setDensitaAmb(double densitaAmb) {
        this.densitaAmb = densitaAmb;
    }

    public boolean isCertificazioni() {
        return certificazioni;
    }

    public void setCertificazioni(boolean certificazioni) {
        this.certificazioni = certificazioni;
    }
}
