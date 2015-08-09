package main.java.com.entity;

import sun.util.calendar.CalendarDate;
import sun.util.resources.CalendarData;

import javax.print.attribute.standard.DateTimeAtCompleted;
import java.sql.Timestamp;
import java.util.Date;

public class Trasportatore {

    private int idTrasportatore;
    private String nameTrasportatore;
    private String targaMezzo;


    public Trasportatore(){}

    public int getIdTrasportatore() {
        return idTrasportatore;
    }

    public void setIdTrasportatore(int idTrasportatore) {
        this.idTrasportatore = idTrasportatore;
    }

    public String getNameTrasportatore() {
        return nameTrasportatore;
    }

    public void setNameTrasportatore(String nameTrasportatore) {
        this.nameTrasportatore = nameTrasportatore;
    }

    public String getTargaMezzo() {
        return targaMezzo;
    }

    public void setTargaMezzo(String targaMezzo) {
        this.targaMezzo = targaMezzo;
    }


}





