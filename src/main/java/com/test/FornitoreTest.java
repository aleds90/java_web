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




                Fornitore f = new Fornitore();
                f.setNameFornitore("ale");
                f.setPartitaIva(1);
                FornitoreDAO dao = new FornitoreDAO();
                dao.insert(f);



            FornitoreDAO fornitoreDAO = new FornitoreDAO();
            Fornitore fornitore = fornitoreDAO.getbyid(2);
            System.out.println(fornitore.getNomeFornitore());
        }
        catch (SQLException e){
            System.out.println(e.getMessage());

        }
    }

}
