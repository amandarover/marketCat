package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.User;

public class UserDB {
    public void insertUser(User user) {
        String insertString =
            "INSERT INTO schema_cat.USERS " +
            "(name, username, password, userType)" +
            "VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = DBServices.getConnection().prepareStatement(insertString)){
            statement.setString(2, user.getName());
            statement.setString(3, user.getUsername());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getUserType());
            
            statement.execute();
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateUser(User user) {
        String updateString =
            "UPDATE schema_cat.USERS " +
            "SET name = ? and " +
            "SET username = ? and " +
            "SET password = ? and " +
            "SET userType = ? and " +
            "WHERE idUser = ?";

        try (PreparedStatement statement = DBServices.getConnection().prepareStatement(updateString)){
            statement.setString(1, user.getName());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getUserType());
            statement.setInt(5, (int) user.getIdUser());
            
            int rowsUpdated = statement.executeUpdate();
            
            if (rowsUpdated > 0) {
                System.out.println("A new user was updated successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteUser(int idUser) {
        String deleteString = "DELETE FROM users WHERE idUser = ?";

        try (PreparedStatement statement = DBServices.getConnection().prepareStatement(deleteString)){
            statement.setInt(1, idUser);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("A new user was deleted successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<User> selectAllUsers() {
        String deleteString = "SELECT * FROM users";
        
        ArrayList<User> usersList = new ArrayList<>();
        try (PreparedStatement statement = DBServices.getConnection().prepareStatement(deleteString)){
            ResultSet result = statement.executeQuery();
            
            User user;
            while(result.next()) {
                user = new User();
                user.setIdUser(result.getInt("idUser"));
                user.setName(result.getString("name"));
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));
                user.setUserType(result.getString("userType"));
                usersList.add(user);
            }
            return usersList;
        } catch (Exception e ) {
            e.printStackTrace();
            return null;
        }
    }
    
    public User selectUser(int idUser) {
        String selectString = "SELECT * FROM users WHERE idUser = ? ";

        try (PreparedStatement statement = DBServices.getConnection().prepareStatement(selectString)){
            statement.setInt(1, idUser);
            
            ResultSet result = statement.executeQuery();
            User user = null;
            while(result.next()) {
                user = new User();
                user.setIdUser(result.getInt("idUser"));
                user.setName(result.getString("name"));
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));
                user.setUserType(result.getString("userType"));
            }
            return user;
            
        } catch (Exception e ) {
            e.printStackTrace();
            return null;
        }
    }
}
