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
			<h3>
				Nombre de sessions ouvertes <span class="badge">${applicationScope.sessionCount}</span>
			</h3>
		</div>
		<div>
			<div class="panel panel-primary">
				<div class="panel-heading">Pizzas ajoutees :</div>
				<div class="panel-body">
					<table class="table table-striped">
						<thead>
							<tr>
								<th align="left">Heure de creation</th>
								<th align="left">Code</th>
								<th align="left">Description</th>
								<th align="left">Prix</th>
								<th align="left">Categorie</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="pizza" items="${stats.creerPizzas}">
								<tr>
									<td class="col-md-3">${pizza.date}</td>
									<td class="col-md-3">${pizza.pizza.code}</td>
									<td>${pizza.pizza.nom}</td>
									<td>${pizza.pizza.prix}</td>
									<td>${pizza.pizza.categorie}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

			<div class="panel panel-primary">
				<div class="panel-heading">Pizzas modifiees :</div>
				<div class="panel-body">
					<table class="table table-striped">
						<thead>
							<tr>
								<th align="left">Heure de modification</th>
								<th align="left">Code</th>
								<th align="left">Description</th>
								<th align="left">Prix</th>
								<th align="left">Categorie</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="pizza" items="${stats.modifierPizzas}">
								<tr>
									<td class="col-md-3">${pizza.date}</td>
									<td class="col-md-3">${pizza.pizza.code}</td>
									<td>${pizza.pizza.nom}</td>
									<td>${pizza.pizza.prix}</td>
									<td>${pizza.pizza.categorie}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

			<div class="panel panel-primary">
				<div class="panel-heading">Pizzas supprimees :</div>
				<div class="panel-body">
					<table class="table table-striped">
						<thead>
							<tr>
								<th align="left">Heure de suppression</th>
								<th align="left">Code</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="pizza" items="${stats.supprimerPizzas}">
								<tr>
									<td class="col-md-3">${pizza.date}</td>
									<td class="col-md-3">${pizza.code}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<a href="pizzas/list"><button type="button"
				class="btn btn-primary">Retour</button></a>

	</div>
</body>
</html>