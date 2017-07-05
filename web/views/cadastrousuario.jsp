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
		<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#newLogin">
			Cadastrar Usuário
		</button>
	</div>
	<div class="container">
		<h2>Cadastro de Usuário</h2>
		<br>
		<br>
		<table class="table-striped table table-hover">
			<thead class="thead-default">
				<tr>
					<th>Nome do usuário</th>
					<th>Login</th>
					<th>Perfil</th>
					<th>Ação</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Joãozinho</td>
					<td>joao_zinho</td>
					<td>Caixa</td>
					<td>
						<button type="button" class="btn btn-default btn-xs" data-toggle="modal" data-target="#newLogin"> Editar
							<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
						</button>
						<br><br>
						<button type="button" class="btn btn-default btn-xs btn btn-danger"  > Excluir
							<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
						</button>
					</td>
				</tr>
				<tr>
					<td>Mariazinha</td>
					<td>maria_zinha</td>
					<td>Gerente</td>
					<td>
						<button type="button" class="btn btn-default btn-xs" data-toggle="modal" data-target="#newLogin"> Editar
							<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
						</button>
						<br><br>
						<button type="button" class="btn btn-default btn-xs btn btn-danger"> Excluir
							<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
						</button>
					</td>					
				</tr>
				<tr>
					<td>Pedro</td>
					<td>pedro</td>
					<td>Caixa</td>
					<td>
						<button type="button" class="btn btn-default btn-xs" data-toggle="modal" data-target="#newLogin"> Editar
							<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
						</button>
						<br><br>
						<button type="button" class="btn btn-default btn-xs btn btn-danger"> Excluir
							<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
						</button>
					</td>					
				</tr>
			</tbody>
		</table>

		<!-- MODAL new product -->
		<div class="modal fade" id="newLogin" tabindex="-1" role="dialog">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title">Novo Usuário</h4>
					</div>
					<div class="modal-body">

						<form id="formNewProduct" data-toggle="validator" method="post" action = "${pageContext.request.contextPath}/ControllerRegisterUser" role="form"  >
							<div class="form-group row">

							</div>
							<div class="form-group row">
								<label for="new-product-name" class="col-2 col-form-label">Nome Usuário</label>
								<div class="col-10">
									<input class="form-control required" type="text" name="Nome" placeholder="Nome do usuário" id="new-name" data-error="Informe o nome do usuário" required>
									<div class="help-block with-errors"></div>
								</div>
							</div>
							<div class="form-group row">
								<label for="new-product-name" class="col-2 col-form-label">Login</label>
								<div class="col-10">
									<input class="form-control required" type="text" name="Login" placeholder="Nome do login" id="new-name" data-error="Informe o nome do login" required>
									<div class="help-block with-errors"></div>
								</div>
							</div>
							<div class="form-group row">
								<label for="example-search-input" class="col-2 col-form-label">Senha</label>
								<div class="col-10">
									<input class="form-control required" type="password" name="Senha" placeholder="Senha" id="new-product-description" data-error="Informe a senha" required>
									<div class="help-block with-errors"></div>
								</div>
							</div>


							<div class="form-group row">
								<div class="col-10">
									<label for="new-product-name" class="col-2 col-form-label">Perfil</label>
									<div class="radio">
										<label><input type="radio" name="optradio" value ="Gerencia">Gerência</label>
									</div>
									<div class="radio">
										<label><input type="radio" name="optradio" value = Caixa>Caixa</label>
									</div>
								</div>
							</div>



							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
								<button type="submit" class="btn btn-primary">Cadastrar Usuário</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- MODAL END -->
	</body>
	</html>