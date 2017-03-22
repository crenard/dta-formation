<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Creer une nouvelle pizza</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body><%@ page import="java.util.List,fr.pizzeria.model.Pizza"%>
	<div class="container">
		<form class="form-horizontal" method="post"
			action=<%=request.getContextPath() + "/pizzas/new"%>>

			<fieldset>

				<!-- Form Name -->
				<legend>Editez votre pizza</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">New
						code</label>
					<div class="col-md-4">
						<input id="textinput" name="code" class="form-control input-md"
							type="text">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">Description</label>
					<div class="col-md-4">
						<input id="textinput" name="nom" class="form-control input-md"
							type="text">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">Prix</label>
					<div class="col-md-4">
						<input id="textinput" name="prix" class="form-control input-md"
							type="text">

					</div>
				</div>
				<!-- Select Basic -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="selectbasic">Categorie</label>
					<div class="col-md-4">
						<select id="selectbasic" name="categorie" class="form-control">
							<option selected
								value="VIANDE">VIANDE</option>
							<option value="POISSON">POISSON</option>
							<option value="VEGETARIEN">VEGETARIEN</option>
						</select>
					</div>
				</div>

				<div class="form-group">
					<button type="submit"
						class="btn btn-success glyphicon glyphicon-ok">Valider</button>
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