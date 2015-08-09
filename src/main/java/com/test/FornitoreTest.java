package main.java.com.test;

import main.java.com.dao.FornitoreDAO;
import main.java.com.entity.Fornitore;

import java.sql.SQLException;

/**
 * Created by Alessandro on 09/08/2015.
 */
public class FornitoreTest {
    public static void main(String args[]){

        try {
            FornitoreDAO fornitoreDAO = new FornitoreDAO();
            Fornitore fornitore = fornitoreDAO.getbyid(1);
            System.out.println(fornitore.getNomeFornitore());
        }
        catch (SQLException e){
            System.out.println(e.getMessage());

        }
    }

}
