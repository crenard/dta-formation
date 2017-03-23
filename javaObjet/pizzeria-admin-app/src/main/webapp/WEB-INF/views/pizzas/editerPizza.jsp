<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List,fr.pizzeria.model.Pizza"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Editez votre pizza</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
	<div class="container">
		<form class="form-horizontal" method="post">

			<fieldset>

				<!-- Form Name -->
				<legend class="jumbotron">Editez votre pizza</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">New
						code</label>
					<div class="col-md-4">
						<input id="textinput" name="code" class="form-control input-md"
							type="text" value="${pizza.code}" required>

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">Description</label>
					<div class="col-md-4">
						<input id="textinput" name="nom" class="form-control input-md"
							type="text" value="${pizza.nom}" required>

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">Prix</label>
					<div class="col-md-4">
						<input id="textinput" name="prix" class="form-control input-md"
							type="text" value="${pizza.prix}" required>

					</div>
				</div>
				<!-- Select Basic -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="selectbasic">Categorie</label>
					<div class="col-md-4">
						<select id="selectbasic" name="categorie" class="form-control">
							<c:set var="categorie" scope="request" value="${pizza.categorie}"></c:set>
							<option ${categorie == 'VIANDE' ? 'selected' : ''} value="VIANDE">VIANDE</option>
							<option ${categorie == 'POISSON' ? 'selected' : ''}
								value="POISSON">POISSON</option>
							<option ${categorie == 'VEGETARIEN' ? 'selected' : ''}
								value="VEGETARIEN">VEGETARIEN</option>
						</select>
					</div>
				</div>

				<div class="form-group col-md-4 pull-right">
					<button type="submit"
						class="btn btn-success">Valider <span class="glyphicon glyphicon-ok"></span></button>
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