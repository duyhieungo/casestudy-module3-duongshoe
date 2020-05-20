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
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ManagementUserServlet", urlPatterns = "/user")
public class ManagementUserServlet extends HttpServlet {

    private ServiceUserImp serviceUserImp;

    public void init() {
        serviceUserImp = new ServiceUserImp();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create_user":
                createUser(request, response);
                break;
            case "delete_user":
                deleteUser(request, response);
                break;
            case "edit_user":
                updateUser(request, response);
                break;
        }
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
            case "view_details_user":
                viewDetailsUser(request, response, "viewDetailsUser");
                break;
            case "delete_user":
                viewDetailsUser(request, response, "deleteForm");
                break;
            case "edit_user":
                viewDetailsUser(request, response, "editForm");
                break;
        }
    }

    //Hiển thị form đăng kí
    private void showCreateUserForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd;
        try {
            rd = request.getRequestDispatcher(Link.DASHBOARD_TO_CREATE_FORM_USER);
            rd.forward(request, response);
        } catch (ServletException e) {
            System.err.println(Error.ERROR_008);
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
            System.err.println(Error.ERROR_009);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Hiển thị bảng thông tin chi tiết người dùng
    private void viewDetailsUser(HttpServletRequest request, HttpServletResponse response, String type) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user;
        RequestDispatcher requestDispatcher = null;
        try {
            user = serviceUserImp.selectUser(id);
            if (user == null) {
                requestDispatcher = request.getRequestDispatcher("error404.jsp");
            } else {
                request.setAttribute("user", user);
                if (type.equals("viewDetailsUser")) {
                    requestDispatcher = request.getRequestDispatcher(Link.VIEW_DETAILS_USER);
                } else if (type.equals("deleteForm")) {
                    requestDispatcher = request.getRequestDispatcher(Link.DELETE_FORM);
                } else if (type.equals("editForm")) {
                    requestDispatcher = request.getRequestDispatcher(Link.EDIT_FORM);
                }
                requestDispatcher.forward(request, response);
            }
        } catch (ServletException ex) {
            System.err.println(Error.ERROR_010);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    //Hiển thị form đăng ký người dùng
    private void createUser(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher;
        User user;
        try {
            user = getValuesFromForm(request);
            serviceUserImp.insertUser(user);
            requestDispatcher = request.getRequestDispatcher(Link.DASHBOARD_TO_CREATE_FORM_USER);
            request.setAttribute("message", "Thêm tài khoản mới thành công");
            requestDispatcher.forward(request, response);
        } catch (ServletException ex) {
            System.err.println(Error.ERROR_013);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Xóa user sau đó thông báo message
    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int id;
        User user;
        RequestDispatcher requestDispatcher;
        try {
            id = Integer.parseInt(request.getParameter("id"));
            user = serviceUserImp.selectUser(id);
            if (user == null) {
                requestDispatcher = request.getRequestDispatcher("error404.jsp");
            } else {
                serviceUserImp.deleteUser(id);
                requestDispatcher = request.getRequestDispatcher(Link.DASHBOARD_TO_DELETE_USER);
                request.setAttribute("message", "Xóa thành công");
                requestDispatcher.forward(request, response);
            }
        } catch (ServletException e) {
            System.err.println(Error.ERROR_012);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Chỉnh sửa user sau đó thông báo message
    private void updateUser(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher;
        User user;
        try {
            user = getValuesFromForm(request);
            serviceUserImp.updateUser(user);
            request.setAttribute("message", "Cập nhật tài khoản mới thành công");
            requestDispatcher = request.getRequestDispatcher(Link.EDIT_FORM);
            requestDispatcher.forward(request, response);
        } catch (ServletException ex) {
            System.err.println(Error.ERROR_013);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private User getValuesFromForm(HttpServletRequest request) {
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
        firstName = request.getParameter("firstName");
        lastName = request.getParameter("lastName");
        tempGender = request.getParameter("gender");
        if (tempGender.equals("1")) {
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
        switch (tempRole) {
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
        if (tempStatus.equals("1")) {
            status = 1;
        } else {
            status = 0;
        }
        address = request.getParameter("address");
        user = new User(roleId, firstName, lastName, gender, dateOfBirth, phone, address, email, username, password, status);
        return user;
    }

}
