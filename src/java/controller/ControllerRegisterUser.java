package controller;
        
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hirob
 */
@WebServlet("/ControllerRegisterUser")
public class ControllerRegisterUser extends HttpServlet {

    public void getParameters(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        String name = request.getParameter("Nome");
        String login = request.getParameter("Login");
        String password = request.getParameter("Senha");
        String radio = request.getParameter("optradio");

        System.out.println("Nome: " + name);
        System.out.println("Login: " + login);
        System.out.println("Password: " + password);
        System.out.println("Perfil: "+ radio);
        
        User user = new User();
        
        //user.g
        if("Gerencia".equals(radio)){
            //TODO
        }else{
            if("Caixa".equals(radio)){
                //TODO
            }else{
                
            }
        }

        response.sendRedirect("/marketCat/faces/views/cadastrousuario.jsp");
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        getParameters(request, response);

    }

}
