package main.java.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginAdminFilter", urlPatterns = {"/dashboard", "/product", "/bills", "/user"})
public class LoginAdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        String loginURI = req.getContextPath() + "/admin";
        boolean loggedIn = (session != null) && (session.getAttribute("admin") != null);
        boolean loginRequest = req.getRequestURI().equals(loginURI);

        if (loggedIn || loginRequest) {
            chain.doFilter(req, resp);
        } else {
            resp.sendRedirect(loginURI);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
