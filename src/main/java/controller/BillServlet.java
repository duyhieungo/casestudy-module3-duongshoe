package main.java.controller;

import main.java.model.Bill;
import main.java.service.bill.BillService;
import main.java.service.bill.BillServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.List;

@WebServlet(name = "BillServlet",urlPatterns = "/admin/bills")
public class BillServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BillServiceImpl billServiceImpl;

    public void init() {
        billServiceImpl = new BillServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertBill(request, response);
                    break;
                case "edit":
                    updateBill(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteBill(request, response);
                    break;
                default:
                    listBill(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listBill(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Bill> listBill = billServiceImpl.selectAllBills();
        request.setAttribute("listBill", listBill);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/bill/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/bill/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Bill existingUser = billServiceImpl.selectBill(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/bill/edit.jsp");
        request.setAttribute("bill", existingUser);
        dispatcher.forward(request, response);
    }

    private void insertBill(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        double amount = Double.parseDouble(request.getParameter("amount"));
        String message=request.getParameter("message");
        double discount = Double.parseDouble(request.getParameter("discount"));
        double shipping_fee = Double.parseDouble(request.getParameter("shipping_fee"));
        String payment=request.getParameter("payment");
        Date date_of_payment= Date.valueOf(request.getParameter("date_of_payment"));
        int status=Integer.parseInt(request.getParameter("status"));
        Date create_date= Date.valueOf(request.getParameter("create_date"));
        Date update_date= Date.valueOf(request.getParameter("update_date"));
        Bill newBill = new Bill(amount,message,discount,shipping_fee,payment,date_of_payment,status,create_date,update_date);
        billServiceImpl.insertBill(newBill);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/bill/create.jsp");
        dispatcher.forward(request, response);
    }
    private void updateBill(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        int user_id=Integer.parseInt(request.getParameter("user_id"));
        double amount = Double.parseDouble(request.getParameter("amount"));
        String message=request.getParameter("message");
        double discount = Double.parseDouble(request.getParameter("discount"));
        double shipping_fee = Double.parseDouble(request.getParameter("shipping_fee"));
        String payment=request.getParameter("payment");
        Date date_of_payment= Date.valueOf(request.getParameter("date_of_payment"));
        int status=Integer.parseInt(request.getParameter("status"));
        Date create_date= Date.valueOf(request.getParameter("create_date"));
        Date update_date= Date.valueOf(request.getParameter("update_date"));

        Bill anotherBill = new Bill(id, user_id,amount,message,discount,shipping_fee,payment,date_of_payment,status,create_date,update_date);
        billServiceImpl.updateBill(anotherBill);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/bill/edit.jsp");
        dispatcher.forward(request, response);
    }
    private void deleteBill(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        billServiceImpl.deleteBill(id);

        List<Bill> listBill = billServiceImpl.selectAllBills();
        request.setAttribute("listBill", listBill);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/bill/list.jsp");
        dispatcher.forward(request, response);
    }
}
