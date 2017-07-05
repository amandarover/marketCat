package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ControllerSale")
public class ControllerSale extends HttpServlet {

    public void getParameters(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        
        String name = request.getParameter("Nome");
        String quantity = request.getParameter("QuantidadeProduto");
        String price = request.getParameter("ValorUnidade");
        

        System.out.println("Nome: " + name);
        System.out.println("Quantidade: " + quantity);
        System.out.println("Valor: " + price);
        


        response.sendRedirect("/marketCat/faces/views/vendas.jsp");
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        getParameters(request, response);

    }
}
