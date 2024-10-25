import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class LoginPage extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String u=request.getParameter("uname"); 
            String p=request.getParameter("pass"); 
            if(u.equals("abc")&& p.equals("1234")) 
            { 
                out.println("login successfully !!!"); 
            } 
            else 
            { 
                out.println("login failed !!!"); 
            } 
        }
    }
}
