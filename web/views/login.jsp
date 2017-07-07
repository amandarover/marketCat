<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../assets/css/standard.css">
    <link rel="stylesheet" type="text/css" href="../assets/css/navbar.css">
    <link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>

    <script src="../assets/bootstrap/js/validator.min.js"></script>
    <script src="../assets/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="login.jsp" text-align="center">MarketCat</a>
            </div>
        </div>
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <div class="container">
            </div>
        </div>
    </nav>

    <div class="container">
        <div class="row vertical-offset-100">
            <div class="col-md-4 col-md-offset-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                            <h3 class="panel-title">Tela de Login</h3>
                    </div>
                    <div class="panel-body">
                        <form accept-charset="UTF-8" data-toggle="validator" role="form" method="post" action="${pageContext.request.contextPath}/ControllerLogin">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Usuário" name="usuario" type="text" data-error="Insira um usuÃ¡rio" required>
                                    <div class="help-block with-errors"></div>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Senha" name="senha" type="password" value="" data-error="Insira uma senha" required>
                                    <div class="help-block with-errors"></div>
                                </div>

                                <input class="btn btn-lg btn-primary btn-block" type="submit" value="Login">
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>


</body>
</html>
