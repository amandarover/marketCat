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
        String description = request.getParameter("Descricao");
        String quantity = request.getParameter("QuantidadeProduto");
        String unit = request.getParameter("UnidadeMedida");
        String minStock = request.getParameter("QuantidadeMinEstoque");
        String unitPrice = request.getParameter("ValorUnidade");
        String validity = request.getParameter("DataValidade");

        System.out.println("Nome: " + name);
        System.out.println("Descricao: " + description);
        System.out.println("Quantidade: " + quantity);
        System.out.println("Unidade: " + unit);
        System.out.println("Estoque Minimo: " + minStock);
        System.out.println("Preco unitario: " + unitPrice);
        System.out.println("Validade: " + validity);
        response.sendRedirect("/marketCat/faces/views/products.jsp");
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        getParameters(request, response);
    }
}
