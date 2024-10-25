import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registration extends HttpServlet {

     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String username = request.getParameter("uname"); 
        String password = request.getParameter("pwd"); 
        String email = request.getParameter("mail"); 
        String country = request.getParameter("cntry"); 
        
        Connection con = null; 
        PreparedStatement pst = null; 
        
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javpractical?autoReconnect=true&useSSL=false", "root", "root");
            out.println("Connection established successfully!<br/>"); 
            
            pst = con.prepareStatement("INSERT INTO user (name, email, password, country) VALUES (?, ?, ?, ?)"); 
            pst.setString(1, username); 
            pst.setString(2, email); 
            pst.setString(3, password); // Consider hashing the password for security
            pst.setString(4, country); 
            pst.executeUpdate(); 
            
            out.println("Data added successfully!");
        } catch (SQLException e) {
            out.println("Database error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            out.println("JDBC Driver not found: " + e.getMessage());
        } finally {
            // Ensure resources are closed
            try {
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
    

}
