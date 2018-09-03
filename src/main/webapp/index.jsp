<!DOCTYPE html>
<html>
<head>
<title>FAPI - Orientação a Objetos II - Servlets</title>
</head>
<body>
	<div id="formLogin">
		Login:
		<form action="login" method="post">
			<label>Email:</label> <input type="text" name="email"> <label>Senha:</label><input
				type="password" name="senha"> <input type="submit"
				value="Enviar">
		</form>
	</div>
	<hr>
	<div id="formLoginSession">
		Login Session:
		<form action="loginSession" method="post">
			<label>Email:</label> <input type="text" name="email"> <label>Senha:</label><input
				type="password" name="senha"> <input type="submit"
				value="Enviar">
		</form>
	</div>
	<hr>
	<div id="formLogout">
		<form action="logout" method="post">
			<input type="submit" value="Deslogar">
		</form>
	</div>

</body>
</html>
