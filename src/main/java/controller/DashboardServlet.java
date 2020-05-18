package main.java.controller;

import main.java.model.User;
import main.java.service.user.ServiceUserImp;
import main.java.util.Error;
import main.java.util.Link;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DashboardServlet", urlPatterns = "/dashboard")
public class DashboardServlet extends HttpServlet {
    private ServiceUserImp serviceUserImp;

    public void init() {
        serviceUserImp = new ServiceUserImp();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        confirmLoginAdmin(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "view_user":
                showUserTable(request, response);
                break;
            case "create_user":
                showCreateUserForm(request, response);
                break;
        }
    }

    //xác nhận tài khoản admin
    public void confirmLoginAdmin(HttpServletRequest request, HttpServletResponse response) {
        User admin;
        String userName;
        String password;
        RequestDispatcher rd;
        try {
            admin = serviceUserImp.selectAdmin();
            userName = request.getParameter("username");
            password = request.getParameter("password");
            if (userName.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
                rd = request.getRequestDispatcher(Link.LOGIN_ADMIN_TO_DASHBOARD);
                rd.forward(request, response);
            } else {
                request.setAttribute(Error.ERROR, Error.ERROR_004);
                rd = request.getRequestDispatcher(Link.LOGIN_ADMIN_TO_LOGIN_ADMIN);
                rd.forward(request, response);
            }
        } catch (ServletException ex) {
            System.err.println(Error.ERROR_006);
        } catch (IOException ex) {
            System.err.println(Error.ERROR_005);
        }
    }

    //Hiển thị form đăng kí
    public void showCreateUserForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd;
        try {
            rd = request.getRequestDispatcher(Link.DASHBOARD_TO_CREATE_FORM_USER);
            rd.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Hiển thị bảng người dùng
    public void showUserTable(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd;
        try {
            rd = request.getRequestDispatcher(Link.DASHBOARD_TO_VIEW_USER);
            rd.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
