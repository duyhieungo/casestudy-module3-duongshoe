package main.java.controller;

import main.java.model.Product;
import main.java.service.dao.ProductDAO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Duc on 5/17/2020
 * @project casestudy-module3-duongshoe
 **/

@WebServlet(name = "ServletProduct", urlPatterns = "/products")
public class ServletProduct extends HttpServlet {
    private ProductDAO productDAO;

    public void init() {
        productDAO = new ProductDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
//            case "view":
//                request.getRequestDispatcher("views/admin/brand/brand-home.jsp").forward(request, response);
//                break;
//            case "add":
//                request.getRequestDispatcher("views/admin/brand/brand-register.jsp").forward(request, response);
//                break;
            default:
                List<Product> productList = productDAO.selectAllUsers();
                break;
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
    }
}
