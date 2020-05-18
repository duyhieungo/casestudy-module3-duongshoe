package main.java.controller;

import main.java.util.Link;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ManagementUserServlet", urlPatterns = "/user")
public class ManagementUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

    private void showCreateUserForm(HttpServletRequest request, HttpServletResponse response) {
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


    private void showUserTable(HttpServletRequest request, HttpServletResponse response) {
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
