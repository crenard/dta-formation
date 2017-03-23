<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Authentification</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<form class="form-horizontal" method="post">
			<fieldset>

				<!-- Form Name -->

				<legend class="jumbotron">Authentification</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">Login</label>
					<div class="col-md-4">
						<input name="login" class="form-control input-md" required
							type="text">
					</div>
				</div>

				<!-- Password input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="passwordinput">Password</label>
					<div class="col-md-4">
						<input name="password" class="form-control input-md" required
							type="password">
					</div>
				</div>

				<div class="form-group col-md-4 pull-right">
					<button type="submit" class="btn btn-success">
						Se connecter <span class="glyphicon glyphicon-ok"></span>
					</button>
				</div>
			</fieldset>
		</form>
	</div>
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>