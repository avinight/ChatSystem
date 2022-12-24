package server.features.service.usecases;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class MyHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the requested resource
        String resource = request.getParameter("resource");

        // Set the content type of the response
        response.setContentType("text/html");

        // Get the response writer
        PrintWriter out = response.getWriter();

        // Write the response
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Example</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello from the servlet!</h1>");
        out.println("<p>You requested the resource: " + resource + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
