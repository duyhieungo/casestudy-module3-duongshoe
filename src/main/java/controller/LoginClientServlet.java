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
import java.util.Map;

@WebServlet(name = "LoginClientServlet", urlPatterns = "/login")
public class LoginClientServlet extends HttpServlet {
    private ServiceUserImp serviceUserImp;

    public void init() {
        serviceUserImp = new ServiceUserImp();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        confirmLoginClient(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showLoginClientForm(request, response);
    }

    private void showLoginClientForm(HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher rd;
        try {
            rd = request.getRequestDispatcher("views/user/loginUser.jsp");
            rd.forward(request, response);
        } catch (ServletException ex) {
            System.err.println(Error.ERROR_006);
        } catch (IOException ex) {
            System.err.println(Error.ERROR_005);
        }
    }

    //xác nhận tài khoản client
    public void confirmLoginClient(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> listClient;
        String userName;
        String password;
        RequestDispatcher rd;
        try {
            listClient = serviceUserImp.selectClient();
            userName = request.getParameter("username");
            password = request.getParameter("password");
            if (password.equals(listClient.get(userName))) {
                rd = request.getRequestDispatcher(Link.LOGIN_CLIENT_TO_REDIRECT_HOME);
                rd.forward(request, response);
            } else {
                request.setAttribute(Error.ERROR, Error.ERROR_004);
                rd = request.getRequestDispatcher(Link.LOGIN_CLIENT_TO_LOGIN_CLIENT);
                rd.forward(request, response);
            }
        } catch (ServletException ex) {
            System.err.println(Error.ERROR_021);
        } catch (IOException ex) {
            System.err.println(Error.ERROR_022);
        }
    }
}
