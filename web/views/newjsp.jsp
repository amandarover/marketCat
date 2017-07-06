<%-- 
    Document   : newjsp
    Created on : 05/07/2017, 23:41:23
    Author     : hirob
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div align="center">
            <P>Lista de Alunos</P>
            <table border="1">
                <tr>
                    <td>Matricula</td>
                    <td>Nome</td>
                    <td>Telefone</td>
                    <td>Data Cadastro</td>
                    <td>Comandos</td>
                </tr>
                <c:forEach var="aluno" items="${listaAluno}">
                    <tr>
                        <td>${aluno.matricula}</td>
                        <td>${aluno.nome}</td>
                        <td>${aluno.telefone}</td>
                        <td><fmt:formatDate value="${aluno.dataCadastro}" type="both" pattern="dd/MM/yyyy"/>  
                        <td><a href="AlunoServlet?acao=Excluir&matricula=${aluno.matricula}">Excluir</a></td>
                    </tr>
                </c:forEach>
            </table>
            <c:if test="${fn:length(listaAluno) > 0}">
                Existem ${fn:length(listaAluno)} alunos!
            </c:if><br> 		
        </div>
        <a href="menu.jsp">Voltar</a>
    </body>
</html>
