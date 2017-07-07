<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="models.Product"%>
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

        <div class="container" align="right">
            <button type="button" id="newProductButton" class="btn btn-primary" data-toggle="modal" data-target="#newProductModal">
                Criar novo Produto
            </button>
        </div>

        <!-- MODAL new product -->
        <div class="modal fade" id="newProductModal" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Informações do novo Produto:</h4>
                    </div>
                    <div class="modal-body">

                        <form id="formNewProduct" data-toggle="validator" method="post" action = "${pageContext.request.contextPath}/ControllerProduct" role="form">
                            <div class="form-group row">
                                <div class="col-10">
                                    <label for="new-product-name" class="col-2 col-form-label">Imagem</label>
                                    <input id="new-product-image" type="file" name="Imagem" class="file required" data-error="Adicione uma imagem" required>
                                    <div class="help-block with-errors"></div>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="new-product-name" class="col-2 col-form-label">Nome</label>
                                <div class="col-10">
                                    <input class="form-control required" type="text" name="Nome" placeholder="Nome do produto" id="new-product-name" data-error="Informe o nome" required>
                                    <div class="help-block with-errors"></div>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="example-search-input" class="col-2 col-form-label">Descrição</label>
                                <div class="col-10">
                                    <input class="form-control required" type="text" name="Descricao" placeholder="Breve descriÃ§Ã£o do produto" id="new-product-description" data-error="Informe a descriÃ§Ã£o" required>
                                    <div class="help-block with-errors"></div>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="example-email-input" class="col-2 col-form-label">Quantidade do produto</label>
                                <div class="col-10">
                                    <input class="form-control required" type="number" min="0" name="QuantidadeProduto" placeholder="0" id="new-product-amount" data-error="Informe a quantidade" required>
                                    <div class="help-block with-errors"></div>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="example-url-input" class="col-2 col-form-label">Unidade de medida</label>
                                <div class="col-10">
                                    <input class="form-control required" type="text" name="UnidadeMedida" placeholder="litros, gramas" id="new-product-measurement" data-error="Informe a unidade de medida" required>
                                    <div class="help-block with-errors"></div>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="example-number-input" class="col-2 col-form-label">Quantidade mínima do estoque</label>
                                <div class="col-10">
                                    <input class="form-control required" type="number" min="0" step="1" name="QuantidadeMinEstoque" placeholder="0" id="new-product-min-amount" data-error="Informe a quantidade mÃ­nima de estoque" required>
                                    <div class="help-block with-errors"></div>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="example-tel-input" class="col-2 col-form-label">Valor por unidade</label>
                                <div class="col-10">
                                    <div class="input-group">
                                        <span class="input-group-addon">$</span>
                                        <input class="form-control" type="number" min="0" name="ValorUnidade" placeholder="0" id="new-product-price" data-error="Informe a valor por unidade" required>
                                    </div>
                                    <div class="help-block with-errors"></div>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="example-datetime-local-input" class="col-2 col-form-label">Data de validade</label>
                                <div class="col-10">
                                    <input class="form-control required" type="date" name="DataValidade" value="12-06-2017" id="new-product-expiration-date" data-error="Informe a data de validade" required>
                                    <div class="help-block with-errors"></div>
                                </div> <!-- validaÃ§ao de data mÃ­nima min="26-05-2017" -->
                            </div>

                            <!-- PROMOÃ‡ÃƒO -->
                            <div class="checkbox">
                                <label><input id="checkbox-sale" type="checkbox" value="" onclick="toggleSale()">Este produto tem promoção§Ã£o?</label>
                            </div>
                            <div class="form-group row" id="saleFieldDate" style="display:none;">
                                <div class="col-10">
                                    <label for="example-datetime-local-input" class="col-2 col-form-label">Data final da promoção</label>
                                    <input class="form-control required-sale" type="date" name="DataFinalProm" value="12-06-2017" id="new-product-expiration-date-sale">
                                </div> <!-- validaÃ§ao de data mÃ­nima min="26-05-2017" -->
                            </div>
                            <div class="form-group row" id="saleFieldPercent" style="display:none;">
                                <label for="example-tel-input" class="col-2 col-form-label">Porcentagem da promoção</label>
                                <div class="col-10">
                                    <div class="input-group">
                                        <span class="input-group-addon">%</span>
                                        <input class="form-control required-sale" type="number" min="0" name="PorProm" placeholder="0" id="new-product-percent-sale">
                                    </div>
                                    <div class="help-block with-errors"></div>
                                </div>
                            </div>
                            <div class="form-group row" id="saleFieldUnit" style="display:none;">
                                <div class="col-10">
                                    <label for="example-tel-input" class="col-2 col-form-label">Unidade de produto mínima para essa promoção</label>
                                    <input class="form-control required-sale" type="number" min="0" name="MinUnProm" placeholder="0" id="new-product-min-unity-sale">
                                    <div class="help-block with-errors"></div>
                                </div>
                            </div>

                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                                <button type="submit" class="btn btn-primary">Criar Produto</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- MODAL END -->
        <!-- TABLE -->
        <div class="container">
            <h2>Produto</h2>
            <div class="container" align="right">
            </div>

            <br>
            <br>
            <table class="table-striped table table-hover">
                <thead class="thead-default">
                    <tr>
                        <th>Nome</th>
                        <th>Descrição</th>
                        <th>Quantidade no estoque</th>
                        <th>Unidade de Medida</th>
                        <th>Valor Unitario</th>
                        <th>Promoção</th>
                        <th>Data de Validade</th>
                        <th>Estoque mínimo</th>
                        <th>Imagem do Produto</th>
                        <th>Ação</th>
                    </tr>
                </thead>
                <tbody>
                    
                    
                    
                    <c:forEach var="u" items="${listproducts}">

                        <tr>
                            <td>${u.name}</td>
                            <td>${u.description}</td>
                            <td>${u.unitOfMeasure}</td>
                            <td>${u.pricePerUnit}</td>
                            <td>${u.minimumStock}</td>
                            <td>${u.validateDate}</td>
                            <td>${u.stock}</td>
                            <td>${u.closeout}</td>
                            <td>${u.expirationDateCloseout}</td>
                            <td>${u.minimumCloseout}</td>
                            <td>${u.percentageCloseout}</td>
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






                </tbody>
            </table>
        </div>
        <!-- END TABLE -->

        <script>
            function toggleSale() {
                $("#saleFieldDate").toggle();
                $("#saleFieldPercent").toggle();
                $("#saleFieldUnit").toggle();

                handleValidateSale();
            }
            function handleValidateSale() {
                if (document.getElementById("checkbox-sale").checked) {
                    $("#new-product-expiration-date-sale").attr("data-error", "Informe a data final da promoÃ§Ã£o");
                    $("#new-product-expiration-date-sale").attr("required", "true");

                    $("#new-product-percent-sale").attr("data-error", "Informe a porcentagem");
                    $("#new-product-percent-sale").attr("required", "true");

                    $("#new-product-min-unity-sale").attr("data-error", "Informe a quantidade minima do produto");
                    $("#new-product-min-unity-sale").attr("required", "true");
                } else {
                    $("#new-product-expiration-date-sale").removeAttr("data-error", "Informe a data final da promoÃ§Ã£o");
                    $("#new-product-expiration-date-sale").removeAttr("required", "false");

                    $("#new-product-percent-sale").removeAttr("data-error", "Informe a porcentagem");
                    $("#new-product-percent-sale").removeAttr("required", "false");

                    $("#new-product-min-unity-sale").removeAttr("data-error", "Informe a quantidade minima do produto");
                    $("#new-product-min-unity-sale").removeAttr("required", "false");
                }

            }
            $(document).ready(
                    function () {
                        $('#newProductModal').on('hidden.bs.modal', function () {
                            cleanModal();
                        });
                    }
            );

            function cleanModal() {
                $('#new-product-expiration-date').val("");
                $('#new-product-price').val('');
                $('#new-product-min-amount').val('');
                $('#new-product-measurement').val('');
                $('#new-product-amount').val('');
                $('#new-product-description').val('');
                $('#new-product-name').val('');
                $('#new-product-image').val('');
                if (document.getElementById("checkbox-sale").checked) {
                    $('new-product-min-unity-sale').val('');
                    $('new-product-percent-sale').val('');
                    $('new-product-expiration-date-sale').val('');
                }
            }
        </script>

        <script>
            function confirmacao() {
                confirm("Deseja Apagar?");
            }
        </script>

    </body>
</html>
