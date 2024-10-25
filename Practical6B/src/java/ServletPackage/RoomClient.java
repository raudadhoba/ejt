package ServletPackage;

import jakarta.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import myPackage.RoomBeanLocal;


public class RoomClient extends HttpServlet {

     
    @EJB RoomBeanLocal obj; 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
        response.setContentType("text/html"); 
        PrintWriter out = response.getWriter(); 
        try 
        { 
            int no=Integer.parseInt(request.getParameter("t1")); 
            String b=request.getParameter("btn"); 
            int res=0; 
            if(b.equals("CheckIn")) 
            { 
                res=obj.checkin(no); 
                if (res==1) 
                    out.println(no + " rooms check-in"); 
            } 
            if(b.equals("CheckOut")) 
            { 
                res=obj.checkout(no); 
                if (res==1) 
                    out.println(no + " rooms check-out"); 
            } 
            if(res==0) 
                out.println("Not possible to do Check IN / OUT"); 
            out.println("<br><br><a href=index.html> Back </a>"); 
        } 
        finally { 
            out.close(); 
        } 
    }
}
