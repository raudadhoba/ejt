import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class calculator extends HttpServlet {
    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           int n3; 
            int n1=Integer.parseInt(request.getParameter("fno")); 
            int n2=Integer.parseInt(request.getParameter("sno")); 
            String op=request.getParameter("opt"); 
            if(op.equals("addition")) 
            { 
                n3=n1+n2; 
                out.println("ADDITION IS : "+n3); 
                 
            } 
            if(op.equals("subtractor")) 
            { 
                n3=n1-n2; 
                out.println("SUBTRACT IS : "+n3); 
            } 
            if(op.equals("multiplication")) 
            { 
                n3=n1*n2; 
                out.println("MULTIPLICATION IS : "+n3); 
                 
            } 
            if(op.equals("division")) 
            { 
                n3=n1/n2; 
                out.println("DIVISION IS : "+n3); 
                 
            } 

        }
    }
}
