<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List,fr.pizzeria.model.Pizza"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Liste des pizzas</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<a href="../disconnect"><button type="button" class="btn btn-primary">
				Disconnect</button></a> 
		<a href="../technique"><button type="button"
				class="btn btn-primary">Technique</button></a>

		<h1 class="jumbotron">Liste des pizzas</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th align="left">Code</th>
					<th align="left">Description</th>
					<th align="left">Prix</th>
					<th align="left">Categorie</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="pizza" items="${liste}">
					<tr>
						<td>${pizza.code}</td>
						<td>${pizza.nom}</td>
						<td>${pizza.prix}</td>
						<td>${pizza.categorie}</td>
						<td><a href="edit?code=${pizza.code}"><button
									type="button" class="btn btn-primary btn-block">
									Editer <span class="glyphicon glyphicon-pencil"></span>
								</button></a></td>
						<td><a href="suppr?code=${pizza.code}"><button
									type="button" class="btn btn-danger btn-block">
									Supprimer <span class="glyphicon glyphicon-remove"></span>
								</button></a></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5"></td>
					<td><a href="new"><button type="button"
								class="btn btn-success btn-block">
								Nouvelle pizza <span class="glyphicon glyphicon-star"></span>
							</button></a></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>