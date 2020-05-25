package main.java.controller;

import main.java.model.Bill;
import main.java.model.BillDetail;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddToCartServlet", urlPatterns = "/addtoCart")
public class AddToCartServlet extends HttpServlet {
    private IProductService productService = new ProductServiceImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "cart":
                showCartDetail(request, response);
                break;
            default:
                listCart(request, response);
                break;
        }
    }

    private void listCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/user/cart-detail.jsp");
        dispatcher.forward(request, response);
    }

    private void showCartDetail(HttpServletRequest request, HttpServletResponse response) {
        int quantity = 1;
        int id;
        try {
            if (request.getParameter("id") != null) {
                id = Integer.parseInt(request.getParameter("id"));
                Product product = null;
                product = productService.getProductByProductID(id);
                if (product != null) {
                    if (request.getParameter("quantity") != null) {
                        quantity = Integer.parseInt(request.getParameter("quantity"));
                    }
                    HttpSession session = request.getSession();
                    if (session.getAttribute("billDetail") == null) {
                        BillDetail billDetail = new BillDetail();
                        List<Item> itemList = new ArrayList<Item>();
                        Item item = new Item();
                        item.setQuantity(quantity);
                        item.setProduct(product);
                        item.setPrice(productService.price(product.getProductID()));
                        itemList.add(item);
                        billDetail.setItems(itemList);
                        session.setAttribute("billDetail", billDetail);
                    } else {
                        BillDetail billDetail = (BillDetail) session.getAttribute("billDetail");
                        List<Item> itemList = billDetail.getItems();
                        boolean check = false;
                        for (Item item : itemList) {
                            if (item.getProduct().getProductID() == product.getProductID()) {
                                item.setQuantity(item.getQuantity() + quantity);
                                check = true;
                            }
                        }
                        if (!check) {
                            Item item = new Item();
                            item.setQuantity(quantity);
                            item.setProduct(product);
                            item.setPrice(productService.price(product.getProductID()));
                            itemList.add(item);
                            billDetail.setItems(itemList);
                        }
                        session.setAttribute("billDetail", billDetail);
                    }
                }
                response.sendRedirect("/cart");
            } else {
                response.sendRedirect(request.getContextPath() + "/home");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}

