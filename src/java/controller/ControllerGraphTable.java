package controller;

import database.ProductDB;
import database.SaleDB;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Product;
import models.User;

@WebServlet("/ControllerGraphTable")
public class ControllerGraphTable extends HttpServlet {

    SaleDB saledb = new SaleDB();
    ProductDB productdb = new ProductDB();

    public void showSales(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException, ParseException {
        ArrayList sales = saledb.selectSaleForMonth();
    }

    public void checkValidation(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException, ParseException {
        ArrayList<Product> products = productdb.selectAllProducts();

        Date todayDate = new Date();
        //System.out.println(dateFormat.format(date));

        for (Product prod : products) {
            Date date = prod.getValidateDate();

            long minus = todayDate.getTime() - date.getTime();

            if (minus <= 2) {
                System.out.println("Está perto da validade");
                alertUser();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            showSales(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ControllerGraphTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    public void alertUser(){
        
    }
}
