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
import java.sql.Date;
import java.util.List;

@WebServlet(name = "AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    private ServiceUserImp serviceUserImp;

    public void init() {
        serviceUserImp = new ServiceUserImp();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        confirmLoginAdmin(request, response);
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "create_user":
                createUser(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "view_product":
                break;
            case "create_product":
                break;
            case "view_catalog":
                break;
            case "create_catalog":
                break;
            case "view_bill":
                break;
            case "view_user":
                showUserTable(request, response);
                break;
            case "create_user":
                showCreateUserForm(request, response);
                break;
            case "view_details_user":
                viewDetailsUser(request, response);
                break;
            default:
                showLoginAdminForm(request, response);
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

    //Hiển thi form đăng nhập admin.
    private void showLoginAdminForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd;
        try {
            rd = request.getRequestDispatcher(Link.LOGIN_ADMIN_TO_LOGIN_ADMIN);
            rd.forward(request, response);
        } catch (ServletException ex) {
            System.err.println(Error.ERROR_006);
        } catch (IOException ex) {
            System.err.println(Error.ERROR_005);
        }
    }

    //Hiển thị form đăng kí
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

    //Hiển thị bảng người dùng
    private void showUserTable(HttpServletRequest request, HttpServletResponse response) {
        List<User> listUser;
        RequestDispatcher rd;
        try {
            listUser = serviceUserImp.selectAllUsers();
            request.setAttribute("listUser", listUser);
            rd = request.getRequestDispatcher(Link.DASHBOARD_TO_VIEW_USER);
            rd.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewDetailsUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = serviceUserImp.selectUser(id);
        RequestDispatcher requestDispatcher;
        try {
            if (user == null) {
                requestDispatcher = request.getRequestDispatcher("error404.jsp");
            } else {
                request.setAttribute("user", user);
                requestDispatcher = request.getRequestDispatcher("views/admin/user/viewDetailsUser.jsp");
                requestDispatcher.forward(request, response);
            }
        } catch (ServletException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) {
        User user = null;
        int roleId = 0;
        String tempRole;
        String firstName;
        String lastName;
        boolean gender;
        String tempGender;
        Date dateOfBirth;
        String tempDateOfBirth;
        String phone;
        String email;
        int status;
        String tempStatus;
        String address = null;
        String username;
        String password;
        RequestDispatcher requestDispatcher;
        try {
            firstName = request.getParameter("firstName");
            lastName = request.getParameter("lastName");
            tempGender = request.getParameter("gender");
            if (tempGender.equals("1")){
                gender = true;
            } else {
                gender = false;
            }
            tempDateOfBirth = request.getParameter("dateOfBirth");
            dateOfBirth = Date.valueOf(tempDateOfBirth);
            phone = request.getParameter("phone");
            email = request.getParameter("email");
            username = request.getParameter("username");
            password = request.getParameter("password");
            tempRole = request.getParameter("role");
            switch (tempRole){
                case "1":
                    roleId = 1;
                    break;
                case "2":
                    roleId = 2;
                    break;
                case "3":
                    roleId = 3;
                    break;
            }
            tempStatus = request.getParameter("status");
            if (tempStatus.equals("1")){
                status = 1;
            } else {
                status = 0;
            }
            address = request.getParameter("address");
            user = new User(roleId,  firstName,  lastName,  gender,  dateOfBirth,  phone,  address,  email,  username,  password,  status);
            serviceUserImp.insertUser(user);
            requestDispatcher = request.getRequestDispatcher(Link.DASHBOARD_TO_CREATE_FORM_USER);
            requestDispatcher.forward(request, response);
        } catch (ServletException ex) {
            System.err.println("Loi chuyen sang form tao user");
        } catch (IOException ex){
            System.err.println(ex.getMessage());
        }
    }
}