import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * @project casestudy-module3-duongshoe
 * @author Duc on 5/13/2020
 */
@WebServlet(name = "test", urlPatterns = "/test")
public class ServletTest extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try (PrintWriter printWriter = response.getWriter()) {
            printWriter.write("<html><h1>Chào các doanh nhân</h1></html>");
        }
    }
}
