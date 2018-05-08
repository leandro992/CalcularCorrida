<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="vendor/bootstrap/css/estiloMenu.css" rel="stylesheet">


<!--<title> Corridas Compartilhadas </title>-->
</head>
<body>

	<!-- Navegação -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<div class="container">

			<div class="collapse navbar-collapse" id="navbarsite">
				<div class="collapse navbar-collapse" id="navbarsite">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item"><a class="nav-link"
							href="home.jsp">Home</a></li>
						<li class="nav-item"><a class="nav-link"
							href="MotoristaServlet">Cadastrar Motorista</a></li>
						<li class="nav-item"><a class="nav-link"
							href="PassageiroServlet">Cadastrar Passageiro</a></li>
						<li class="nav-item"><a class="nav-link"
							href="CorridaServlet">Registrar Corrida</a></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>

	<div class="container">
		<div class="row justify-content-center mt-5 pt-5">
			<div class="col-md-7">
				<h3 class="display-5">
					Cadastrar Passageiro
					</h2>
					<hr class="bg-dark">
					<form action="PassageiroServlet" method="post">
						<input type="hidden" name="idPassageio" id="idPassageio"/>
						<div class="row form-group">
							<label for="nomePassageiro" class="col-form-label col-md-2">NOME</label>
							<div class="col-md-8">
								<input type="text" name="nomePassageiro" value="" id="nomePassageiro"
									class="form-control">
							</div>
						</div>

						<div class="row form-group">
							<label for="cpf" class="col-form-label col-md-2">CPF</label>
							<div class="col-md-8">
								<input type="text" name="cpf" value="" id="cpf"
									class="form-control">
							</div>
						</div>

						<div class="row form-group">
							<label for="cpf" class="col-form-label col-md-2">SEXO</label>
							<div class="col-md-8">
								<label for="radios-0">
									<input type="radio" name="sexo" id="sexo" value="Masculino" checked="checked"> Masculino 
								</label>
								<label for="radios-1">
									<input type="radio" name="sexo" id="sexo" value="Feminino" checked="checked"> Feminino  
								</label>
							</div>
						</div>

						<div class="row form-group">
							<label for="cpf" class="col-form-label col-md-2">STATUS</label>
							<div class="col-md-8">
								<select id="statusPassageiro" name="statusPassageiro"
									class="form-control">
									<option value="true">Ativo</option>
									<option value="false">Desativado</option>
								</select>
							</div>
						</div>

						<div class="row form-group">
							<label for="dataNascimento" class="col-form-label col-md-5">Data de
								Nascimento</label> <input id="dataNascimento" name="dataNascimento"
								type="date" placeholder="" class="form-control input-md">
						</div>

						<button type="submit" class="btn btn-Success">
						Salvar</button>

					</form>
			</div>
		</div>
	</div>

	<div class=" col-md-offset-3 table-bordered">
		<table class="table table-striped table-hover table-condensed">
			<thead>
				<tr>
					<td>Código</td>
					<td>Nome</td>
					<td>Data de Nascimento</td>
					<td>CPF</td>
					<td>Sexo</td>
					<td>Status</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="passageiro" items="${listPassageiro}">
					<tr>
						<td><c:out value="${motorista.id}" /></td>
						<td><c:out value="${motorista.nome}" /></td>
						<td><c:out value="${motorista.dataNascimento}" /></td>
						<td><c:out value="${motorista.cpf}" /></td>
						<td><c:out value="${motorista.sexo}" /></td>
						<td><c:out value="${motorista.ativo}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


	<!-- Rodape -->
	<footer class="py-2 bg-primary">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy;Victor
				Santos leandro 2018</p>
		</div>
	</footer>



	<!-- Bootstrap  JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/popper/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="vendor/bootstrap/js/estiloJS.js"></script>
</body>
</html>