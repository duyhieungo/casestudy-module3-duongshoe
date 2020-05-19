package main.java.controller;

import main.java.model.ImportRecord;
import main.java.model.Product;
import main.java.service.brand.BrandServiceImp;
import main.java.service.brand.IBrandService;
import main.java.service.product.IProductService;
import main.java.service.product.ProductServiceImp;
import main.java.service.record.stock.IImportService;
import main.java.service.record.stock.ImportServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Duc on 5/18/2020
 * @project casestudy-module3-duongshoe
 **/

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    private List<Product> productList;
    private IBrandService brandService;
    private IProductService productService;
    private IImportService importService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "add":
                break;
            case "edit":
                break;
            case "view-detail":
                showProductDetail(req, resp);
                break;
            default:
                showProductList(req, resp);
        }
    }

    private void showProductDetail(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        importService = new ImportServiceImp(productService);
        List<ImportRecord> recordList = importService.getImportRecords(Integer.parseInt(id));
        Product product = productList.get(Integer.parseInt(id));
        req.setAttribute("product", product);
        req.setAttribute("recordList", recordList);
        try {
            req.getRequestDispatcher("views/admin/product/product-detail.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showProductList(HttpServletRequest req, HttpServletResponse resp) {
        brandService = new BrandServiceImp();
        productService = new ProductServiceImp(brandService);
        productList = productService.getProductList();
        req.setAttribute("productList", productList);
        try {
            req.getRequestDispatcher("views/admin/product/product-home.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
