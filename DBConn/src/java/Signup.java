import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import org.mindrot.jbcrypt.BCrypt;

public class Signup extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver"); 

            // Establish the connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms?autoReconnect=true&useSSL=false", "root", "root"); 
            String sql = "INSERT INTO user (name, email, password, country) VALUES (?, ?, ?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.setString(4, country);

            // Execute the insert operation
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                out.println("<h2>Signup Successful!</h2>");
                out.println("<p>Username: " + username + "</p>");
                out.println("<p>Email: " + email + "</p>");
                out.println("<p>Country: " + country + "</p>");
            } else {
                out.println("<h2>Signup Failed!</h2>");
            }

        } catch (Exception e) {
            out.println("<h2>Error occurred!</h2>");
            out.println("<p>" + e.getMessage() + "</p>");
        } finally {
            
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                out.println("<h2>Resource Closing Error!</h2>");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Signup Servlet";
    }
}
