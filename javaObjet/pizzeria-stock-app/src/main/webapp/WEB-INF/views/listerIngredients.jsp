<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Liste des ingredients</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1 class="jumbotron">Liste des ingredients</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th align="left">Nom</th>
					<th align="left">Prix</th>
					<th align="left">Quantite</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ingredient" items="${liste}">
					<tr>
						<td>${ingredient.nom}</td>
						<td>${ingredient.prix}</td>
						<td>${ingredient.quantite}</td>
						<td><a href="ingredients/edit/${ingredient.id}"><button
									type="button" class="btn btn-info btn-block">
									Editer <span class="glyphicon glyphicon-pencil"></span>
								</button></a></td>
						<td><a href="ingredients/suppr/${ingredient.id}"><button
									type="button" class="btn btn-danger btn-block">
									Supprimer <span class="glyphicon glyphicon-remove"></span>
								</button></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>