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

        <script src="../assets/javascript/highcharts.js"></script>
        <script src="https://code.highcharts.com/modules/data.js"></script>
        <script src="https://code.highcharts.com/modules/drilldown.js"></script>
        <script src="../assets/javascript/chart.js"></script>
        <script src="../assets/bootstrap/js/bootstrap.min.js"></script>



    </head>
    <body>
        <div id="navbar"></div>
        <div id="grafico" style="min-width: 310px; height: 400px; margin: 0 auto"></div>

        <div class="container">
            <h2>Relatório Vencido</h2>
            <br>
            <br>
            <table class="table-striped table table-hover">
                <thead class="thead-default">
                    <tr>
                        <th>Produto</th>
                        <th>Quantidade</th>
                        <th>Valor Unitario</th>
                        <th>Valor Total do Produto</th>
                        <th>Data Vencido</th>
                        <th>Imagem</th>
                    </tr>
                </thead>
                <tbody>



                <c:forEach var="u" items="${sales}">

                    <tr>
                        <td>${u.cpfCostumer}</td>
                        <td>${u.saleDate}</td>
                        <td>${u.totalSale}</td>
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







                <tr>
                    <td><strong>Valor total</strong></td>
                    <td> </td>
                    <td> </td>
                    <td><strong></strong></td>
                    <td> </td>
                </tr>

                </tbody>
            </table>

    </body>
</html>
