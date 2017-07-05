package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ControllerProduct")
public class ControllerProduct extends HttpServlet {

    public void getParameters(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        
        String name = request.getParameter("Nome");
        String description = request.getParameter("Login");
        String quantity = request.getParameter("Senha");
        String unit = request.getParameter("optradio");
        String minStock = request.getParameter("optradio");
        String unitPrice = request.getParameter("optradio");
        String validity = request.getParameter("optradio");

        //System.out.println("Nome: " + name);
        //System.out.println("Login: " + login);
        // System.out.println("Password: " + password);
        // System.out.println("Perfil: " + radio);
        response.sendRedirect("/marketCat/faces/views/products.jsp");
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        //getParameters(request, response);
    }
}
