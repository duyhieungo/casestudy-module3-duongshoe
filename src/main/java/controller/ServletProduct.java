package main.java.controller;

import main.java.model.product.Import;
import main.java.service.product.IImportService;
import main.java.service.product.ImportServiceImp;

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

@WebServlet(name = "ServletProduct", urlPatterns = "/product")
public class ServletProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        IImportService service = new ImportServiceImp();
        List<Import> importList = service.getImportList();

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "view":
                request.setAttribute("importList", importList);
                request.getRequestDispatcher("views/admin/product/product-home.jsp").forward(request, response);
                break;
        }
    }
}
