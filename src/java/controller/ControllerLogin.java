/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.UserDB;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;

@WebServlet("/ControllerLogin")
public class ControllerLogin extends HttpServlet {

    UserDB userdb = new UserDB();

    public void getParameters(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        String login = request.getParameter("usuario");
        String password = request.getParameter("senha");

        System.out.println("Login: " + login);
        System.out.println("Password: " + password);

        ArrayList<User> users = userdb.selectAllUsers();

        for (User user1 : users) {
            String username = user1.getUsername();
            if (login.equals(username)) {
                System.out.println("Usuario existe");
                if ("Gerencia".equals(user1.getUserType())) {
                    response.sendRedirect("products.jsp");
                }
            } else {
                System.out.println("Usuario não existe");
            }
        }

        User user = new User();

        // userdb = 
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
