 
<%@page contentType="text/html" import="java.sql.*" %> 
<html> 
    <body> 
        <h1>UPDATING EMPLOYEE RECORD</h1> 
        <% 
            String eno = request.getParameter("emp_no");  
            String sal = request.getParameter("salary"); 
            try { 
                Class.forName("com.mysql.jdbc.Driver"); 
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javpractical?autoReconnect=true&useSSL=false","root","root"); 
                PreparedStatement stmt = con.prepareStatement("select * from employee where eno=?");  
                stmt.setString(1, eno); 
                ResultSet rs = stmt.executeQuery(); 
                if (rs.next()) { 
                    out.println("<h1> EMPLOYEE " + rs.getString("eno") + " EXIST </h1>");  
                    PreparedStatement pst = con.prepareStatement("update employee set salary=? where eno=?");  
                    pst.setString(1, sal); 
                    pst.setString(2, eno); 
                    pst.executeUpdate(); 
                    out.println("<h1>EMPLOYEE RECORDS UPDATED !!!</h1>"); 
                }  
                else  
                { 
                    out.println("<h1>EMPLOYEE RECORD DOES NOT EXIST !!!</h1>"); 
                } 
            }  
            catch (Exception e)  
            { 
                out.println(e); 
            } 
        %> 
    </body> 
</html>  