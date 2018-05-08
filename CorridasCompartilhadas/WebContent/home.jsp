<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="vendor/bootstrap/css/estiloMenu.css" rel="stylesheet">


<title></title>
</head>
<body>

	<!-- Navega��o -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<div class="container">

			<div class="collapse navbar-collapse" id="navbarsite">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item"><a class="nav-link"
						href="MotoristaServlet">Cadastrar Motorista</a></li>
					<li class="nav-item"><a class="nav-link"
						href="PassageiroServlet">Cadastrar Passageiro</a></li>
					<li class="nav-item"><a class="nav-link"
						href="CorridaServlet">Registrar Corrida</a></li>
				</ul>
			</div>
		</div>
	</nav>


	<div id="carouselSite" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselSite" data-slide-to="0" class="active"></li>
			<li data-target="#carouselSite" data-slide-to="1"></li>
			<li data-target="#carouselSite" data-slide-to="2"></li>
		</ol>

		<div class="carousel-item active">
			<img alt="" src="vendor/img/pessoa01.jpg" class="img-fluid d-block">
			<div class="carousel-caption">
				<h3 class="text-primary">Dirija quando quiser</h3>
				<h4 class="text-primary">Ganhe o dinheiro que voc� precisa</h4>
				<p class="text-primary">Dirigir com Corridas Compartilhadas �
					uma oportunidade flex�vel que ajuda os motoristas parceiros a
					alcan�arem seus objetivos pessoas.</p>
			</div>
		</div>

		<div class="carousel-item">
			<img alt="" src="vendor/img/pessoa02.jpg" class="img-fluid d-block">
			<div class="carousel-caption">
				<h3 class="text-primary">Um jeito diferente</h3>
				<h4 class="text-primary">Aproveite melhor o seu tempo</h4>
				<p class="text-primary">Com apenas um toque, um carro
					compartilhado vai at� voc�. Depois � s� embarcar, pois seu
					motorista vai saber exatamente para onde ir. Quando chegar ao
					destino, basta sair do carro. O pagamento � feito sem complica��es</p>
			</div>
		</div>

		<div class="carousel-item">
			<img alt="" src="vendor/img/pessoa03.jpg" class="img-fluid d-block">

			<div class="carousel-caption">
				<h3 class="text-primary">Corridas Compartilhadas</h3>
				<h4 class="text-primary">Mais passageiros. Mais viagens.</h4>
				<p class="text-primary">Corridas compartilhadas � como uma
					viagem economica pois voc� compartilha a corrida com diferentes
					passageiros que t�m destinos ou rotas similares.</p>
			</div>

		</div>


		<!-- Left and right controls -->
		<a class="carousel-control-prev" href="#carouselSite" role="button"
			data-slide="prev"> <span class="carousel-control-prev-icon"></span>
			<span class="sr-only">Anterior</span>
		</a> <a class="carousel-control-next" href="#carouselSite" role="button"
			data-slide="next"> <span class="carousel-control-next-icon"></span>
			<span class="sr-only">Avan�ar</span>
		</a>

	</div>


	<!-- Bootstrap  JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/popper/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.js"></script>

</body>
</html>