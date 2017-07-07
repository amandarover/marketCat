package controller;

import database.SaleDB;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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

    Sale sale;
    ArrayList<SaleItem> saleItems;

    public void getParameters(HttpServletRequest request,
            HttpServletResponse response) throws IOException, SQLException, ServletException {

        String name = request.getParameter("Nome");
        String quantity = request.getParameter("QuantidadeProduto");
        String price = request.getParameter("ValorUnidade");

        System.out.println("Nome: " + name);
        System.out.println("Quantidade: " + quantity);
        System.out.println("Valor: " + price);

        Product product = new Product();
        SaleItem saleItem = new SaleItem();

        saleItem.setProduct(product);
        saleItem.setQuantity(Double.parseDouble(quantity));
        saleItems.add(saleItem);

        sale.setSaleItem(saleItems);

        SaleDB saledb = new SaleDB();

        saledb.insertSale(sale);

        //////
        ArrayList listsale = saledb.selectSaleForMonth();

        request.setAttribute("listsale", listsale);
        RequestDispatcher send = request.getRequestDispatcher("vendas.jsp");
        send.forward(request, response);

        //response.sendRedirect("/marketCat/faces/views/vendas.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        try {
            getParameters(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSale.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
