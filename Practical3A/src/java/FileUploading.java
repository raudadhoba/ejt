//package fileupload;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.*;

@MultipartConfig
public class FileUploading extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String path = request.getParameter("destination");
        Part filePart = request.getPart("file");
        String filename = filePart.getSubmittedFileName();

        out.print("<br>File Name: " + filename);
        
        try (OutputStream os = new FileOutputStream(new File(path + File.separator + filename));
             InputStream is = filePart.getInputStream()) {
             
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            out.println("<br>File uploaded successfully!");
        } catch (FileNotFoundException e) {
            out.print("<br>Error: File not found - " + e.getMessage());
        } catch (IOException e) {
            out.print("<br>Error: IO Exception - " + e.getMessage());
        }
    }
}
