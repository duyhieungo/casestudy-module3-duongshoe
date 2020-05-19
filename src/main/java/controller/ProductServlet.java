package main.java.controller;

import main.java.model.ImportRecord;
import main.java.model.Product;
import main.java.service.product.IProductService;
import main.java.service.product.ProductServiceImp;
import main.java.service.stock.IStockService;
import main.java.service.stock.StockServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

/**
 * @author Duc on 5/17/2020
 * @project casestudy-module3-duongshoe
 **/

@WebServlet(name = "ServletProduct", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductServiceImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "detail":
                displayDetail(request, response);
                break;
            case "add":
                request.getRequestDispatcher("views/admin/brand/brand-register.jsp").forward(request, response);
                break;
            default:
                displayProductList(request, response);
        }
    }

    private void displayDetail(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        IStockService stockService = new StockServiceImp();
        String requestDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        try {
            List<ImportRecord> importRecords = stockService.getImportRecordByProductID(id);
            importRecords.sort(new Comparator<>() {
                @Override
                public int compare(ImportRecord o1, ImportRecord o2) {
                    return o1.getImportDateTime().compareTo(o2.getImportDateTime());
                }
            });
            request.setAttribute("importRecords", importRecords);
            request.setAttribute("requestDate", requestDate);
            request.getRequestDispatcher("views/admin/product/detail.jsp").forward(request, response);
        } catch (ServletException | IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void displayProductList(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Product> products = productService.getProductList();
            request.setAttribute("products", products);
            request.getRequestDispatcher("views/admin/product/home.jsp").forward(request, response);
        } catch (ServletException | IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
