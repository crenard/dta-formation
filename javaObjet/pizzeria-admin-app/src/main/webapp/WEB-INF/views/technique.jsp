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
		<div>
			<h1>Nombre de sessions ouvertes :
				${applicationScope.sessionCount}</h1>
		</div>
		<div>
			Pizzas ajoutees :
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
					<c:forEach var="pizza" items="${stats.creerPizzas}">
						<tr>
							<td>${pizza.pizza.code}</td>
							<td>${pizza.pizza.nom}</td>
							<td>${pizza.pizza.prix}</td>
							<td>${pizza.pizza.categorie}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			Pizzas modifiees :
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
					<c:forEach var="pizza" items="${stats.modifierPizzas}">
						<tr>
							<td>${pizza.pizza.code}</td>
							<td>${pizza.pizza.nom}</td>
							<td>${pizza.pizza.prix}</td>
							<td>${pizza.pizza.categorie}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			Pizzas supprimees :
			<table class="table table-striped">
				<c:forEach var="pizza" items="${stats.supprimerPizzas}">
					<tr>
						<td>${pizza.code}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<a href="pizzas/list"><button type="button"
				class="btn btn-primary">Retour</button></a>

	</div>
</body>
</html>