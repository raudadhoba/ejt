package myPackage;
import java.sql.*;
import jakarta.ejb.Stateless;

@Stateless
public class RoomBean implements RoomBeanLocal {
    @Override
    public int checkin(int no) { 
        try 
        { 
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javpractical?autoReconnect=true&useSSL=false", "root", "root"); 
            String sql1 = "select * from rooms"; 
            Statement st=con.createStatement(); 
            ResultSet rs=st.executeQuery(sql1); 
            rs.next(); 
            int total=rs.getInt(2); 
            int occ=rs.getInt(3); 
            int free=total-occ; 
            System.out.println(total); 
            System.out.println(free); 
            if (free>=no) 
            { 
                String sql2="update rooms set occ=?"; 
                PreparedStatement ps=con.prepareStatement(sql2); 
                ps.setInt(1, occ+no); 
                int res=ps.executeUpdate(); 
                return res; 
            } 
            else return 0; 
        } 
        catch(Exception e) 
        { 
            return 0; 
        } 
    } 
    public int checkout(int no) { 
        try 
        {  
            Class.forName("com.mysql.jdbc.Driver"); 

            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javpractical?autoReco nnect=true&useSSL=false", "root", "root"); 
            String sql1 = "select * from rooms"; 
            Statement st=con.createStatement(); 
            ResultSet rs=st.executeQuery(sql1); 
            rs.next(); 
            int total=rs.getInt(2); 
            int occ=rs.getInt(3); 
            if (occ>=no) 
            { 
                String sql2="update rooms set occ=?"; 
                PreparedStatement ps=con.prepareStatement(sql2); 
                ps.setInt(1, occ-no); 
                int res=ps.executeUpdate(); 
                return res; 
            } 
            else return 0; 
        } 
        catch(Exception e) 
        { 
            return 0; 
        } 
    } 
}
