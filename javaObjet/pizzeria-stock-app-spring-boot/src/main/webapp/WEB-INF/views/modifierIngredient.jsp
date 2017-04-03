<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Modifier un ingredient</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
	<div class="container">
		<form:form class="form-horizontal" method="post" modelAttribute="ingredient">

			<fieldset>

				<!-- Form Name -->
				<legend class="jumbotron">Modifiez votre ingredient</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">Nom
						</label>
					<div class="col-md-4">
						<form:input name="nom" class="form-control input-md"
							type="text" path="nom" value="${ingredient.nom}"/>

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">Prix</label>
					<div class="col-md-4">
						<form:input name="prix" class="form-control input-md"
							type="text" path="prix" value="${ingredient.prix}"/>

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">Quantite</label>
					<div class="col-md-4">
						<form:input name="quantite" class="form-control input-md"
							type="text" path="quantite" value="${ingredient.quantite}"/>

					</div>
				</div>

				<div class="form-group col-md-4 pull-right">
					<button type="submit"
						class="btn btn-success">Valider <span class="glyphicon glyphicon-ok"></span></button>
				</div>
			</fieldset>
		</form:form>
	</div>

</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</html>