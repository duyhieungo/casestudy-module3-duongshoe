package main.java.controller;

import main.java.model.Catalog;
import main.java.service.catalog.CatalogServiceImp;
import main.java.service.catalog.ICatalogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Duc on 5/21/2020
 * @project casestudy-module3-duongshoe
 **/

@WebServlet(name = "CatalogServlet", urlPatterns = "/catalog")
public class CatalogServlet extends HttpServlet {
    private ICatalogService catalogService = new CatalogServiceImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            default:
                displayCatalogList(request, response);
        }
    }

    private void displayCatalogList(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Catalog> catalogList = catalogService.getCatalogList();
            request.setAttribute("catalogList", catalogList);
            request.getRequestDispatcher("views/admin/catalog/home.jsp").forward(request, response);
        } catch (SQLException | IOException | ServletException e) {
            e.printStackTrace();
        }
    }
}
