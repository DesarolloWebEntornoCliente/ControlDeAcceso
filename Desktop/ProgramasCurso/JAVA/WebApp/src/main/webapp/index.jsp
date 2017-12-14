<html>
<head>
<title>Web Bootstrap</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- Stylesheets -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">

<style type="text/css">
.container {
	margin-top: 30px;
}

.subscriber {
	margin-top: 30px;
}

</style>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 col-xs-12">
				<h1>Login</h1>
				
				<%
					String error = request.getParameter("mensaje");
					if(error != null){
						%>
							<div class="alert alert-warning alert-dismissable">
								<button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
								<strong>Error!!! </strong><%=error %>
							</div>
						<%
					}
				%>
				
				
				<hr>
				<form action="validarUsuario" method="POST" role="form">
					<div class="form-group">
						<label for="usuario">Usuario</label> <input type="text"
							class="form-control" id="usuario" name="usuario" placeholder="Usuario"
							autofocus="autofocus" aria-describedby="usuarioH"> <small
							id="usuarioH" class="form-text text-muted">Utilize su Nombre de Usuario
							para Login</small>
					</div>
					<div class="form-group">
						<label for="password">Password</label> <input type="password"
							class="form-control" id="password" name="password" placeholder="Password">
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input"> Recordar
						</label>
					</div>
					<button type="submit" class="btn btn-primary ">
						<i class="fa fa-sign-in"></i> Enviar
					</button>
					<button type="submit" class="btn btn-success">
						<i class="fa fa-user-plus"></i> Registrar
					</button>							
				</form>
			</div>
		</div>
	</form>

</div>



	<script src="js/jquery-3.2.1.slim.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>
