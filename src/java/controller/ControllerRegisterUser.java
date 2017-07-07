package controller;

import database.UserDB;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;


@WebServlet("/ControllerRegisterUser")
public class ControllerRegisterUser extends HttpServlet {

    public void getParameters(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        String name = request.getParameter("Nome");
        String login = request.getParameter("Login");
        String password = request.getParameter("Senha");
        String radio = request.getParameter("optradio");

        System.out.println("Nome: " + name);
        System.out.println("Login: " + login);
        System.out.println("Password: " + password);
        System.out.println("Perfil: " + radio);

        User user = new User();

        UserDB userdb = new UserDB();
        if ("Gerencia".equals(radio)) {

            user.setName(name);
            user.setPassword(password);
            user.setUsername(login);
            user.setUserType(radio);
            userdb.insertUser(user);
        } else {
            if ("Caixa".equals(radio)) {
                user.setName(name);
                user.setPassword(password);
                user.setUsername(login);
                user.setUserType(radio);
                userdb.insertUser(user);
            }
        }

        ArrayList users = userdb.selectAllUsers();
        request.setAttribute("users", user);
        RequestDispatcher mandar = request.getRequestDispatcher("cadastrousuario.jsp");
        mandar.forward(request, response);

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
