import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletContext;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;


public class NonBlockingServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         try(PrintWriter out = response.getWriter()){ 
            out.println("<h1>File Reader</h1>"); 
            String filename="/WEB-INF/demo.txt"; 
            ServletContext c = getServletContext(); 
            InputStream in = c.getResourceAsStream(filename); 
            String path = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/ReadingNonBlockingServlet"; 
            URL url = new URL(path); 
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(); 
            conn.setChunkedStreamingMode(2); 
            conn.setDoOutput(true);  
            conn.connect(); 
            if(in!=null) 
            { 
                InputStreamReader inr = new InputStreamReader(in); 
                BufferedReader br = new BufferedReader(inr); 
                String text = ""; 
                System.out.println("Reading started..."); 
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream())); 
                while ((text = br.readLine()) != null){ 
                    out.print(text+"<br>"); 
                    try{ 
                        Thread.sleep(1000); 
                        out.flush(); 
                    } 
                    catch(InterruptedException ex) {} 
                } 
                out.print("Reading Completed....."); 
                bw.flush(); 
                bw.close(); 
            } 
        } 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
