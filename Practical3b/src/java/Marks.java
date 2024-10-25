    import java.io.IOException;
    import java.io.PrintWriter;
    import jakarta.servlet.ServletException;
    import jakarta.servlet.http.HttpServlet;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;

    import java.sql.*; 

    public class Marks extends HttpServlet {

        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try{
                Class.forName("com.mysql.jdbc.Driver"); 
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javpractical?autoReconnect=true&useSSL=false", "root", "root"); 
                Statement stmt = con.createStatement(); 
                ResultSet res = stmt.executeQuery("select answer from questionset"); 
                int count = 0, qno = 0; 
                while (res.next())  
                { 
                    qno++; 
                    String selectedAnswer = request.getParameter("q" + qno); 
                    if (selectedAnswer != null && selectedAnswer.equals(res.getString(1)))  
                    { 
                        count++; 
                        out.println("<h1>CORRECT </h1>"); 
                    }  
                    else  
                    { 
                        out.println("<h1>INCORRECT </h1>"); 
                    } 
                } 
                out.println("<h1>YOUR MARKS IS " + count + " </h1>"); 
            }  
            catch (Exception e)  
            { 
                out.println(e); 
            }

        }
    }
