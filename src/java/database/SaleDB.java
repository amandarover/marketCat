package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Product;
import models.Sale;
import models.SaleItem;

public class SaleDB {
    public void insertSale(Sale sale) throws SQLException {
        PreparedStatement statement = null;
        Connection con = DBServices.getConnection();
        try {        
            for (SaleItem item : sale.getSaleItem()) {
                statement = con.prepareStatement("INSERT INTO sale " +
                    "(idProduct, idSale, productQuantity, totalSale, saleDate, cpfCustomer)" + 
                    "VALUES (?, ?, ?, ?, ?, ?)");
                statement.setLong(1, item.getProduct().getIdProduct());
                statement.setLong(2, sale.getIdSale());
                statement.setDouble(3, item.getQuantity());
                statement.setDouble(4, sale.getTotalSale());
                statement.setDate(5, (Date) sale.getSaleDate());
                statement.setString(6, sale.getCpfCustomer());
                
//                Tratar o calculo de porcentagem no sistema (aqui só deve ficar o resultado da venda)
//                if (item.getProduct().isCloseout() == true) {
//                    
//                    double percentagePaid = (item.getProduct().getPercentageCloseout()*100) - 100; //inserir no campo porcentagem apenas 0,1 -> referente a 10%
//                    double amountPaid = percentagePaid * item.getProduct().getPricePerUnit(); //tratar para virar positivo
//                    statement.setDouble(5, amountPaid);
//                } else {
//                    ps.setDouble(5, item.getValorUnidade());
//                }

                statement.execute();
            }
        } catch (SQLException ex) {
            System.out.println("Erro no insertVenda \n " + ex.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
        }
    }
    
    public void deleteSaleProduct(long idProduct) {
        String deleteString = "DELETE FROM sale WHERE idProduct = ?";

        try (PreparedStatement statement = DBServices.getConnection().prepareStatement(deleteString)){
            statement.setLong(1, idProduct);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("A new product was deleted from a sale successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteSale(long idProduct, long idSale) {
        String deleteString = "DELETE FROM sale WHERE idProduct = ? "+
                "AND WHERE idSale = ?";

        try (PreparedStatement statement = DBServices.getConnection().prepareStatement(deleteString)){
            statement.setLong(1, idProduct);
            statement.setLong(2, idSale);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("A sale was totaly deleted successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Product> selectSaleForMonth() { //TODO
        String deleteString = "SELECT * FROM products";
        ArrayList<Product> productsList = new ArrayList<>();
        try (PreparedStatement statement = DBServices.getConnection().prepareStatement(deleteString)){
            ResultSet result = statement.executeQuery();
            Product product;
            while(result.next()) {
                product = new Product();
                product.setIdProduct(result.getInt("idProduct"));
                product.setImageUrl(result.getString("imageUrl"));
                product.setName(result.getString("name"));
                product.setDescription(result.getString("description"));
                product.setUnitOfMeasure(result.getString("unitOfMeasure"));
                productsList.add(product);
            }
            return productsList;
        } catch (Exception e ) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Sale selectSale(int idProduct) {
        String selectString = "SELECT * FROM sale WHERE idProduct = ? "+
                "AND idSale = ?";

        try (PreparedStatement statement = DBServices.getConnection().prepareStatement(selectString)){
            statement.setInt(1, idProduct);
            ResultSet result = statement.executeQuery();
            Sale sale = null;
            
            sale.setIdSale(result.getLong("idSale"));
            sale.setTotalSale(result.getDouble("totalSale"));
            sale.setSaleDate(result.getDate("saleDate"));
            sale.setCpfCustomer(result.getString("cpfCustomer"));
            
            ArrayList<SaleItem> saleItemList = new ArrayList<>();
            while (result.next()) {
                SaleItem saleItem = new SaleItem();
                saleItem.setQuantity(result.getDouble("productQuantity"));
                
                ProductDB productDB = new ProductDB();
                Product product = productDB.selectProduct(result.getLong("idProduct"));
                saleItem.setProduct(product);
                
                saleItemList.add(saleItem);
            }
            sale.setSaleItem(saleItemList);
            return sale;
        } catch (Exception e ) {
            e.printStackTrace();
            return null;
        }
    }
}
