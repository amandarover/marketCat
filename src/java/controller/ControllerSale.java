package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Product;
import models.Sale;
import models.SaleItem;

@WebServlet("/ControllerSale")
public class ControllerSale extends HttpServlet {

    Sale sale = new Sale();

    public void getParameters(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String name = request.getParameter("Nome");
        String quantity = request.getParameter("QuantidadeProduto");
        String price = request.getParameter("ValorUnidade");

        System.out.println("Nome: " + name);
        System.out.println("Quantidade: " + quantity);
        System.out.println("Valor: " + price);
        
        //Vou precisar de uma lista de todos os produtos
        Product product = new Product();
        SaleItem saleItem = new SaleItem();
        // Sale sale = new Sale();

        saleItem.setProduct(product);

        response.sendRedirect("/marketCat/faces/views/vendas.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        getParameters(request, response);

    }
}
