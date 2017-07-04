package models;

public class User {
    enum UserType {
        ADMIN, MANAGER, CASHIER
    }
    private long idUser;
    private String name;
    private String username;
    private String password;
}
