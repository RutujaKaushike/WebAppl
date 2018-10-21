package com.operations;

import com.db.DbService;
import com.restaurant.Restaurant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Listing extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set response content type
        DbService service = new DbService();
        List<Restaurant> all = service.getAll();
        req.setAttribute("all", all);
        RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/Hello.jsp");
        dispatcher.forward(req, resp);
     }
}
