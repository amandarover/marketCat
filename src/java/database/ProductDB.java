package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Product;

public class ProductDB {

    public void insertProduct(Product product) {

        String insertString =
            "INSERT INTO schema_cat.PRODUCTS " +
            "(imageUrl, name, description, unitOfMeasure, pricePerUnit, minimunStock, validateDate, stock)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = DBServices.getConnection().prepareStatement(insertString)){
            statement.setString(1, product.getImageUrl());
            statement.setString(2, product.getName());
            statement.setString(3, product.getDescription());
            statement.setString(4, product.getUnitOfMeasure());
            statement.setDouble(5, product.getPricePerUnit());
            statement.setDouble(6, product.getMinimunStock());
            statement.setDate(7, product.getValidateDate());
            statement.setDouble(8, product.getStock());
            
            statement.execute();
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
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
            "WHERE idProducts = ?";

        try (PreparedStatement statement = DBServices.getConnection().prepareStatement(updateString)){
            statement.setString(1, product.getImageUrl());
            statement.setString(2, product.getName());
            statement.setString(3, product.getDescription());
            statement.setString(4, product.getUnitOfMeasure());
            statement.setDouble(5, product.getPricePerUnit());
            statement.setDouble(6, product.getMinimunStock());
            statement.setDate(7, product.getValidateDate());
            statement.setDouble(8, product.getStock());
            //preparestatement para chave primaria
            int rowsUpdated = statement.executeUpdate();
            //javautildate para javasqldate
            
            if (rowsUpdated > 0) {
                System.out.println("A new user was updated successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteProduct(int idProduct) {
        String deleteString = "DELETE FROM Pessoa WHERE idProducts = ?";

        try (PreparedStatement statement = DBServices.getConnection().prepareStatement(deleteString)){
            statement.setInt(1, idProduct);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("A new user was deleted successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void selectAllProducts() {
        String deleteString = "SELECT * FROM products";

        try (PreparedStatement statement = DBServices.getConnection().prepareStatement(deleteString)){
            ResultSet result = statement.executeQuery();
            //mostra por output os valores das tabelas para verificaçao se deu certo o/
            int count = 0;

            while (result.next()){
                String name = result.getString("name");
                double pricePerUnit = result.getDouble("pricePerUnit");
                double validateDate = result.getDouble("validateDate");
                String output = "Product #%d: %s - %d - %t";
                System.out.println(String.format(output, ++count, name, pricePerUnit, validateDate));
            }
            //termina a amostragem
            
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }
    
    public Product selectProduct(int idProduct) {
        String selectString = "SELECT * FROM products WHERE idProducts = ? ";

        try (PreparedStatement statement = DBServices.getConnection().prepareStatement(selectString)){
            statement.setInt(1, idProduct);
            ResultSet result = statement.executeQuery();
            Product product = null;
            while(result.next()) {
                product = new Product();
                product.setImageUrl(result.getString("imageUrl"));
                product.setName(result.getString("name"));
                product.setDescription(result.getString("description"));
                product.setUnitOfMeasure(result.getString("unitOfMeasure"));
                product.setPricePerUnit(result.getDouble("pricePerUnit"));
                product.setMinimunStock(result.getDouble("minimunStock"));
                product.setValidateDate(result.getDate("validateDate"));
                product.setStock(result.getDouble("stock"));
            }
            return product;
            
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }    
}
