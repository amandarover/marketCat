<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="models.Sale"%>
<%@page import="models.SaleItem"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="../assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/standard.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/navbar.css">

        <link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha256-k2WSCIexGzOj3Euiig+TlR8gA0EmPjuc79OEeY5L45g=" crossorigin="anonymous"></script>
        <script src="../assets/javascript/navbar.js"></script>
        <script src="../assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="../assets/bootstrap/js/validator.min.js"></script>


    </head>
    <body>
        <div id="navbar"></div>


        <!-- Modal -->
        <div class="modal fade" id="newSaleModal" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Adicionar item à venda:</h4>
                    </div>
                    <div class="modal-body">

                        <form id="formNewProduct" data-toggle="validator" method="post" action = "${pageContext.request.contextPath}/ControllerSale" role="form">
                            <div class="form-group row">
                                <div class="col-10">
                                    <label for="sel1">Nome</label>
                                    <select class="form-control" id="sel1" name="Nome">
                                        <option>Feijão</option>
                                        <option>Alface</option>
                                        <option>Couve</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="example-email-input" class="col-2 col-form-label">Quantidade</label>
                                <div class="col-10">
                                    <input class="form-control required" type="number" min="0" name="QuantidadeProduto" placeholder="0" id="new-product-amount" data-error="Informe a quantidade" required>
                                    <div class="help-block with-errors"></div>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-10">
                                    <label for="example-tel-input" class="col-2 col-form-label">Valor por unidade</label>
                                    <div class="input-group">
                                        <span class="input-group-addon">$</span>
                                        <input class="form-control required" type="number" min="0"  name="ValorUnidade" placeholder="0,00" disabled="true" id="new-product-price">
                                    </div>
                                    <div class="help-block with-errors"></div>
                                </div>
                            </div>

                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                                <button type="submit" class="btn btn-primary">Adicionar Produto</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Modal -->

        <div class="container">
            <h2>Vendas</h2>
            <div class="container" align="right">
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#newSaleModal">
                    Adicionar item
                </button>
            </div>

            <br>
            <br>
            <table class="table-striped table table-hover">
                <thead class="thead-default">
                    <tr>
                        <th>Produto</th>
                        <th>Quantidade</th>
                        <th>Valor Unitario</th>
                        <th>Valor Total do Produto</th>
                        <th>Imagem do Produto</th>
                        <th>Ação</th>
                    </tr>
                </thead>
                <tbody>



                    <c:forEach var="u" items="${listsale}">
                        <tr>
                            <td>${u.totalSale}</td>
                            <td>${u.saleDate}</td>
                            <td class="text-center">
                                <button type="button" class="btn btn-default btn-xs" data-toggle="modal" data-target="#newLogin"> Editar
                                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                </button>
                                <br><br>
                                <button type="button" class="btn btn-default btn-xs btn btn-danger"  > Excluir
                                    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                </button>
                            </td>
                        </tr>
                        <c:forEach var="c" items="${listitem}">

                            <tr>
                                <td>${u.product}</td>
                                <td>${u.quantity}</td>                               
                                <td class="text-center">
                                    <button type="button" class="btn btn-default btn-xs" data-toggle="modal" data-target="#newLogin"> Editar
                                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                    </button>
                                    <br><br>
                                    <button type="button" class="btn btn-default btn-xs btn btn-danger"  > Excluir
                                        <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                    </button>
                                </td>
                            </tr>
                        </c:forEach> 

                    </c:forEach> 













                    <tr>
                        <td>Feijão</td>
                        <td>2</td>
                        <td>R$3,00</td>
                        <td>R$6,00</td>
                        <td> <img src="../assets/images/feijao.jpg" alt="Feijão" id="imagem-produto"></td>
                        <td>
                            <button type="button" class="btn btn-default btn-xs" data-toggle="modal" data-target="#newSaleModal"> Editar
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                            </button>
                            <br><br>
                            <button type="button" class="btn btn-default btn-xs btn btn-danger"  onclick="confirmacao()"> Excluir
                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                            </button>
                        </td>
                    </tr>
                    <tr>
                        <td>Alface</td>
                        <td>1</td>
                        <td>R$5,00</td>
                        <td>R$5,00</td>
                        <td> <img src="../assets/images/alface.jpg" alt="Feijão" id="imagem-produto"></td>
                        <td>
                            <button type="button" class="btn btn-default btn-xs" data-toggle="modal" data-target="#newSaleModal"> Editar
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                            </button>
                            <br><br>
                            <button type="button" class="btn btn-default btn-xs btn btn-danger" onclick="confirmacao()"> Excluir
                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                            </button>
                        </td>					
                    </tr>
                    <tr>
                        <td>Couve</td>
                        <td>3</td>
                        <td>R$3,00</td>
                        <td>R$9,00</td>
                        <td> <img src="../assets/images/couve.jpg" alt="Feijão" id="imagem-produto"></td>
                        <td>
                            <button type="button" class="btn btn-default btn-xs" data-toggle="modal" data-target="#newSaleModal"> Editar
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                            </button>
                            <br><br>
                            <button type="button" class="btn btn-default btn-xs btn btn-danger" onclick="confirmacao()"> Excluir
                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                            </button>
                        </td>					
                    </tr>
                    <tr>
                        <td><strong>Valor total</strong></td>
                        <td> </td>
                        <td> </td>
                        <td><strong>R$ 20,00</strong></td>
                        <td> </td>
                    </tr>

                </tbody>
            </table>

            <div class="container" align="right">
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-primary">
                    Concluir Venda
                </button>
            </div>
        </div>



        <script>
            function confirmacao() {
                confirm("Deseja Apagar?");
            }
        </script>

    </body>
</html>
