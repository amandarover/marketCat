package database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Product;

public class ProductDB {

    public void insertProduct(Product product) {

        String insertString =
            "INSERT INTO schema_cat.PRODUCTS " +
            "(imageUrl, name, description, unitOfMeasure, pricePerUnit, minimunStock, validateDate," + 
            "stock, isCloseout, expirationDateCloseout, minimunCloseout, percentageCloseout)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = DBServices.getConnection().prepareStatement(insertString)){
            statement.setString(1, product.getImageUrl());
            statement.setString(2, product.getName());
            statement.setString(3, product.getDescription());
            statement.setString(4, product.getUnitOfMeasure());
            statement.setDouble(5, product.getPricePerUnit());
            statement.setDouble(6, product.getMinimunStock());
            statement.setDate(7, (Date) product.getValidateDate());
            statement.setDouble(8, product.getStock());
            statement.setBoolean(9, product.isCloseout());
            statement.setDate(10, (Date) product.getExpirationDateCloseout());
            statement.setDouble(11, product.getMinimunCloseout());
            statement.setDouble(12, product.getPercentageCloseout());
            
            statement.execute();
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new product was inserted successfully!");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateProduct(Product product) {
        String updateString =
            "UPDATE schema_cat.PRODUCTS " +
            "SET imageUrl = ? and " +
            "SET name = ? and " +
            "SET description = ? and " +
            "SET unitOfMeasure = ? and " +
            "SET pricePerUnit = ? and " +
            "SET minimunStock = ? and " +
            "SET validateDate = ? and " +
            "SET stock = ? and " +
            "SET isCloseout = ? and " +
            "SET expirationDateCloseout = ? and " +
            "SET minimunCloseout = ? and " +
            "SET percentageCloseout = ? and " +
            "WHERE idProduct = ?";

        try (PreparedStatement statement = DBServices.getConnection().prepareStatement(updateString)){
            statement.setString(1, product.getImageUrl());
            statement.setString(2, product.getName());
            statement.setString(3, product.getDescription());
            statement.setString(4, product.getUnitOfMeasure());
            statement.setDouble(5, product.getPricePerUnit());
            statement.setDouble(6, product.getMinimunStock());
            statement.setDate(7, (Date) product.getValidateDate());
            statement.setDouble(8, product.getStock());
            statement.setLong(9, product.getIdProduct());
            statement.setDate(10, (Date) product.getExpirationDateCloseout());
            statement.setDouble(11, product.getMinimunCloseout());
            statement.setDouble(12, product.getPercentageCloseout());
            
            int rowsUpdated = statement.executeUpdate();
            
            if (rowsUpdated > 0) {
                System.out.println("A new product was updated successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteProduct(int idProduct) {
        String deleteString = "DELETE FROM products WHERE idProduct = ?";

        try (PreparedStatement statement = DBServices.getConnection().prepareStatement(deleteString)){
            statement.setLong(1, idProduct);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("A new product was deleted successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Product> selectAllProducts() {
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
                product.setPricePerUnit(result.getDouble("pricePerUnit"));
                product.setMinimunStock(result.getDouble("minimunStock"));
                product.setValidateDate(result.getDate("validateDate"));
                product.setStock(result.getDouble("stock"));
                product.setCloseout(result.getBoolean("isCloseout"));
                product.setExpirationDateCloseout(result.getDate("expirationDateCloseout"));
                product.setMinimunCloseout(result.getDouble("minimunCloseout"));
                product.setPercentageCloseout(result.getDouble("percentageCloseout"));
                productsList.add(product);
            }
            return productsList;
        } catch (Exception e ) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Product selectProduct(long idProduct) {
        String selectString = "SELECT * FROM products WHERE idProduct = ? ";

        try (PreparedStatement statement = DBServices.getConnection().prepareStatement(selectString)){
            statement.setLong(1, idProduct);
            ResultSet result = statement.executeQuery();
            Product product = null;
            while(result.next()) {
                product = new Product();
                product.setIdProduct(result.getInt("idProduct"));
                product.setImageUrl(result.getString("imageUrl"));
                product.setName(result.getString("name"));
                product.setDescription(result.getString("description"));
                product.setUnitOfMeasure(result.getString("unitOfMeasure"));
                product.setPricePerUnit(result.getDouble("pricePerUnit"));
                product.setMinimunStock(result.getDouble("minimunStock"));
                product.setValidateDate(result.getDate("validateDate"));
                product.setStock(result.getDouble("stock"));
                product.setCloseout(result.getBoolean("isCloseout"));
                product.setExpirationDateCloseout(result.getDate("expirationDateCloseout"));
                product.setMinimunCloseout(result.getDouble("minimunCloseout"));
                product.setPercentageCloseout(result.getDouble("percentageCloseout"));
            }
            return product;
            
        } catch (Exception e ) {
            e.printStackTrace();
            return null;
        }
    }
}
