import jakarta.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import myPackage.CCBeanLocal;

public class CCServlet extends HttpServlet {
     @EJB CCBeanLocal obj; 
   
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             double amt = Double.parseDouble(request.getParameter("amt")); 
            if(request.getParameter("type").equals("r2d")) 
            { 
                out.println("<h1>"+amt+ " Rupees = "+obj.r2Dollar(amt)+" Dollars</h1>"); 
            } 
            if(request.getParameter("type").equals("d2r")) 
            { 
                out.println("<h1>"+amt+ " Dollars = "+obj.d2Rupees(amt)+" Rupees</h1>"); 
            } 
        }
    }

    
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>

}
