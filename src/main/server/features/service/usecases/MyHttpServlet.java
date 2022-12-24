package server.features.service.usecases;

import jakarta.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

@WebServlet(name = "MyHttpServlet", urlPatterns = {"/Users/frederickmeneses/Documents/CSC207/ChatSystem/node_modules/socket.io/client-dist/socket.io.js"})
public class MyHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the content type of the response
        response.setContentType("application/javascript");

        // Get the input stream for the resource
        InputStream inputStream = getServletContext().getResourceAsStream("/Users/frederickmeneses/Documents/CSC207/ChatSystem/node_modules/socket.io/client-dist/socket.io.js");

        // Copy the contents of the input stream to the output stream of the response
        IOUtils.copy(inputStream, response.getOutputStream());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get the request data
        String data = request.getParameter("data");

        // Do something with the data

        // Set the response status and content type
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("text/plain");

        // Write the response
        response.getWriter().println("Success");
    }
}
