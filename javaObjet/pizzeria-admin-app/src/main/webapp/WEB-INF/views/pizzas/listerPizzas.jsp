<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<%@ page import="java.util.List,fr.pizzeria.model.Pizza"%>
	<%!List<Pizza> pizzas;%>
	<div class="container">
		<h1 class="jumbotron">Liste des pizzas</h1>
		<table class="table table-striped">
			<tr>
				<th align="left">Code</th>
				<th align="left">Description</th>
				<th align="left">Prix</th>
				<th align="left">Categorie</th>
			<tr>
				<%
					pizzas = (List<Pizza>) request.getAttribute("liste");
					for (Pizza pizza : pizzas) {
				%>
			
			<tr>
				<td><%=pizza.getCode()%></td>
				<td><%=pizza.getNom()%></td>
				<td><%=pizza.getPrix()%></td>
				<td><%=pizza.getCategorie().toString()%></td>
				<td><a href=<%="edit?code=" + pizza.getCode()%>><button
							type="button" class="btn btn-primary btn-block">
							Editer <span class="glyphicon glyphicon-pencil"></span>
						</button></a>
				<td><a href=<%="suppr?code=" + pizza.getCode()%>><button
							type="button" class="btn btn-danger btn-block">
							Supprimer <span class="glyphicon glyphicon-remove"></span>
						</button></a>
			<tr>
				<%
					}
				%>
			
			<tr>
				<td colspan="5">
				<td><a href="new"><button type="button"
							class="btn btn-success btn-block">
							Nouvelle pizza <span class="glyphicon glyphicon-star"></span></button></a>
		</table>
	</div>
</body>
</html>