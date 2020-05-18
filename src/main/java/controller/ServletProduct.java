package main.java.controller;

import main.java.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Duc on 5/17/2020
 * @project casestudy-module3-duongshoe
 **/

@WebServlet(name = "ServletProduct", urlPatterns = "/brand")
public class ServletProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*        String action = request.getParameter("action");
        IImportService service = new ImportServiceImp();
        List<Product> productList = service.getImportList();



        if (action == null) {
            action = "";
        }
        switch (action) {
            case "view":
//                request.setAttribute("importList", productList);
                request.getRequestDispatcher("views/admin/brand/brand-home.jsp").forward(request, response);
                break;
            case "add":
                request.getRequestDispatcher("views/admin/brand/brand-register.jsp").forward(request, response);
                break;
        }*/
    }
}
