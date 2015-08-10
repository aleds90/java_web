package main.java.com.controller;

import main.java.com.dao.FornitoreDAO;
import main.java.com.entity.Fornitore;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Alessandro on 09/08/2015.
 */
public class FornitoreServlet extends HttpServlet {
    private RequestDispatcher jsp;

    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();

        jsp = context.getRequestDispatcher("/WEB-INF/jsp/fornitore.jsp");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            //Integer id = (Integer)request.getAttribute("id");

            FornitoreDAO fornitoreDAO = new FornitoreDAO();
            Fornitore fornitore = fornitoreDAO.getbyid(1);
            request.setAttribute("fornitore", fornitore);
            System.out.print(fornitore.getNomeFornitore());
        }
        catch (SQLException e){
            System.out.println(e.getMessage());

        }catch (Exception e){
            System.out.print(e.getMessage());
        }

        jsp.forward(request, response);
    }
}
