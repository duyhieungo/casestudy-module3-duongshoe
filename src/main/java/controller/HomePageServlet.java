package main.java.controller;

//import com.sun.glass.ui.Size;
import main.java.model.Item;
import main.java.model.Product;
import main.java.service.product.IProductService;
import main.java.service.product.ProductServiceImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/home")
public class HomePageServlet extends HttpServlet {
    private IProductService productService = new ProductServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "view-detail":
                    showDetailForm(request, response);
                    break;
//                case "more":
//                    showMore(request,response);
//                    break;
                default:
                    listProduct(request,response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Item> itemList = productService.getProductForHomePage();
        request.setAttribute("itemList", itemList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void showDetailForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product existingProduct = productService.getProductByProductID(id);
        request.setAttribute("product", existingProduct);
        List<Integer> size = productService.getSizeListByProductID(id);
        request.setAttribute("size", size);
        int price = productService.price(id);
        DecimalFormat formatter = new DecimalFormat("###,###,###.##");
        String priceFormatter = formatter.format(price);
        request.setAttribute("price", priceFormatter);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/user/product-detail.jsp");
        dispatcher.forward(request, response);
    }
}
