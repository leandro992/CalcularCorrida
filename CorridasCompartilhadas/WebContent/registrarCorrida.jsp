<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
 <!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="vendor/bootstrap/css/estiloMenu.css" rel="stylesheet">
    
<title>Registrar Corrida</title>
</head>
<body>


<!-- Navegação -->
 	<nav class="navbar navbar-expand-lg navbar-dark bg-primary" >
		<div class="container" >
		
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
	  	<h3 class="display-5">Registrar Corrida</h2>		
	  	<hr class="bg-dark">
	  	<form action="CorridaServlet" method="post">
	  		<div class="row form-group">
	  			<label for="nomeMotorista" class="col-form-label col-md-4">MOTORISTA</label>
	  			<div class="col-md-8">
	  				 <select name="motoristaSelecionado" id="motoristaSelecionado">
			          <c:forEach var="motorista" items="${motoristas}">
			            <option value="${motorista.id}">${motorista.nome}</option>
			          </c:forEach>
			        </select>
	  			</div>
	  		</div>
	  		
  		    <div class="row form-group">
	  		   <label for="nomePassageiro" class="col-form-label col-md-4">PASSAGEIRO</label>
	  		   <div class="col-md-8">
	  				<div class="col-md-8">
	  				 <select name="passageiroSelecionado" id="passageiroSelecionado">
			          <c:forEach var="passageiro" items="${passageiros}">
			            <option value="${passageiro.id}">${passageiro.nome}</option>
			          </c:forEach>
			        </select>
	  			</div>
  			  </div>
  			</div>
  			
  			
  			   <div class="row form-group">
	  		   <label for="valorCorrida" class="col-form-label col-md-4">VALOR CORRIDA</label>
	  		   <div class="col-md-8">
	  				<input type="text" name="valorCorrida" value="" id="valorCorrida" class="form-control" >
  			  </div>
  			</div>
  			
  			
  			<button type="submit" class="btn btn-info">Enviar</button>
	  	</form>
	  </div>
	</div>
</div>


<div class=" col-md-offset-3 table-bordered">
	  <table class="table table-striped table-hover table-condensed">
		 <tr>
		  <th>Nome Motorista</th>
		  <th>Modelo do Carro</th>
		  <th>Nome Passageiro</th>
		  <th>Valor</th>
		  <th>Data Inclusão</th>
		 </tr>
	     
	     <tbody>
			<c:forEach var="corrida" items="${corridas}">
				<tr>
					<td><c:out value="${corrida.motorista.nome}" /></td>
					<td><c:out value="${corrida.motorista.modeloCarro}" /></td>
					<td><c:out value="${corrida.passageiro.nome}" /></td>
					<td><c:out value="${corrida.valorCorrida}" /></td>
					<td><c:out value="${corrida.dataInicio}" /></td>
				</tr>
			</c:forEach>	
		</tbody>
	  </table>
	</div>


  <!-- Rodape -->
    <footer class="py-2 bg-primary">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy;Victor Santos leandro 2018</p>
      </div>
    </footer>


    	<!-- Bootstrap  JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/popper/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript" src="vendor/bootstrap/js/estiloJS.js"></script>

</body>
</html>