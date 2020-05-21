package main.java.controller;

import main.java.model.Bill;
import main.java.service.bill.BillServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BillServlet", urlPatterns = "/bills")
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
                case "confirm":
                    confirmBill(request, response);
                    break;
                case "deny":
                    denyBill(request, response);
                    break;
                case "pending":
                    pendingBill(request,response);
                    break;
                default:
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
                case "confirm":
                    showConfirmForm(request, response);
                    break;
                case "deny":
                    showDenyForm(request, response);
                    break;
                case "pending":
                    showPendingForm(request,response);
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


    private void showConfirmForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Bill existingUser = billServiceImpl.selectBill(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/bill/confirmForm.jsp");
        request.setAttribute("bill", existingUser);
        dispatcher.forward(request, response);
    }

    private void showDenyForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Bill existingUser = billServiceImpl.selectBill(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/bill/denyForm.jsp");
        request.setAttribute("bill", existingUser);
        dispatcher.forward(request, response);
    }

    private void confirmBill(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        int status =1;
        Bill anotherBill = new Bill(id, status);
        billServiceImpl.updateBill(anotherBill);
        response.sendRedirect("/bills");
    }
    private void denyBill(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        int status = -1;
        Bill anotherBill = new Bill(id, status);
        billServiceImpl.updateBill(anotherBill);
        response.sendRedirect("/bills");
    }

    private void showPendingForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Bill existingUser = billServiceImpl.selectBill(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/bill/pendingForm.jsp");
        request.setAttribute("bill", existingUser);
        dispatcher.forward(request, response);
    }
    private void pendingBill(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        int status = 0;
        Bill anotherBill = new Bill(id, status);
        billServiceImpl.updateBill(anotherBill);
        response.sendRedirect("/bills");
    }
}
