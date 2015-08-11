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

public class InsertFornitoreServlet extends HttpServlet{

    private RequestDispatcher jsp;

    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();

        jsp = context.getRequestDispatcher("/WEB-INF/jsp/insertFornitore.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nome = request.getParameter("nomeFornitore");
        Integer piva = Integer.parseInt(request.getParameter("partitaIvaFornitore"));

        try{

            Fornitore f = new Fornitore();
            f.setNameFornitore(nome);
            f.setPartitaIva(piva);
            FornitoreDAO dao = new FornitoreDAO();
            dao.insert(f);

        }catch (SQLException e){
            request.setAttribute("error", e.getMessage());

        }

        jsp.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        jsp.forward(request, response);
    }

}
