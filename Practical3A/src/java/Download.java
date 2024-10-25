
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Download extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String filename = request.getParameter("filename");
        ServletContext context = getServletContext();

        if (filename == null || filename.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid filename");
            return;
        }

        String mimeType = context.getMimeType(filename);
        if (mimeType == null) {
            mimeType = "application/octet-stream"; // Fallback for unknown types
        }
        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");

        // Adjust the path to include the 'mypdf' folder
        InputStream is = context.getResourceAsStream("/mypdf/" + filename);
        if (is == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found");
            return;
        }

        try (ServletOutputStream out = response.getOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = is.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            out.flush();
        } finally {
            is.close();
        }
    }
}
