package controller;

import database.ProductDB;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Product;

@WebServlet("/ControllerProduct")
public class ControllerProduct extends HttpServlet {

    public void getParameters(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        String name = request.getParameter("Nome");
        String description = request.getParameter("Descricao");
        String quantity = request.getParameter("QuantidadeProduto");
        String unit = request.getParameter("UnidadeMedida");
        String minStock = request.getParameter("QuantidadeMinEstoque");
        String unitPrice = request.getParameter("ValorUnidade");
        String validity = request.getParameter("DataValidade");

        String expirationDateClouseout = request.getParameter("DataFinalProm");
        String percentageCloseout = request.getParameter("PorProm");
        String minimumClouseout = request.getParameter("MinUnProm");

        System.out.println("Nome: " + name);
        System.out.println("Descricao: " + description);
        System.out.println("Quantidade: " + quantity);
        System.out.println("Unidade: " + unit);
        System.out.println("Estoque Minimo: " + minStock);
        System.out.println("Preco unitario: " + unitPrice);
        System.out.println("Validade: " + validity);
        System.out.println("Data Promocao: " + expirationDateClouseout);
        System.out.println("Porcentagem: " + percentageCloseout);
        System.out.println("Unidade Minima Promocao: " + minimumClouseout);

        ProductDB productdb = new ProductDB();

        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setUnitOfMeasure(unit);
        product.setStock(Double.parseDouble(quantity));
        product.setMinimunStock(Double.parseDouble(minStock));
        product.setPricePerUnit(Double.parseDouble(unitPrice));

        //Promotion
        product.setExpirationDateCloseout(expirationDateClouseout);
        product.setPercentageCloseout(Double.parseDouble(percentageCloseout));
        product.setMinimunCloseout(Double.parseDouble(minimumClouseout));

        productdb.insertProduct(product);

        ArrayList listproducts = productdb.selectAllProducts();

        request.setAttribute("listproducts", listproducts);
        RequestDispatcher mandar = request.getRequestDispatcher("products.jsp");
        mandar.forward(request, response);

       // response.sendRedirect("/marketCat/faces/views/products.jsp");
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        getParameters(request, response);
    }
}
