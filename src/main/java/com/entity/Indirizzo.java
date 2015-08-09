package main.java.com.entity;


public class Indirizzo {
    private int id;
    private String via;
    private int cap;
    private String citta;
    private String provincia;
    private String nazione;
    private String CommentiRegolamentoNazione;

    public Indirizzo(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getNazione() {
        return nazione;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

    public String getCommentiRegolamentoNazione() {
        return CommentiRegolamentoNazione;
    }

    public void setCommentiRegolamentoNazione(String commentiRegolamentoNazione) {
        CommentiRegolamentoNazione = commentiRegolamentoNazione;
    }
}
