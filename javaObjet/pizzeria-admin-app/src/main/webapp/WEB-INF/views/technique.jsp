<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Infos techniques</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h1 class="jumbotron">Technique</h1>
		Nombre de sessions ouvertes : ${applicationScope.sessionCount} <br>
		<br> <a href="pizzas/list"><button type="button"
				class="btn btn-primary">Retour</button></a>

	</div>
</body>
</html>