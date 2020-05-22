package main.java.controller;

import main.java.service.product.IProductService;
import main.java.service.product.ProductServiceImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    private IProductService productService = new ProductServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
        super.doPost(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cart-detail.jsp");
        dispatcher.forward(request, response);
    }
}
