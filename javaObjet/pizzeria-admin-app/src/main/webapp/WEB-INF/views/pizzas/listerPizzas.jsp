<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des pizzas</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
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
			<tr>
				<%
					}
				%>
			
		</table>
	</div>
</body>
</html>