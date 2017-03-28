var API_PIZZAS = "http://localhost:8080/pizzeria-admin-app/api/rest/pizzas";

$(document).ready(function () {
    $.get({
        url: API_PIZZAS
    }).then(function (pizzas) {
        var bodyLines = pizzas.map(function (pizza) {
            var linePizza = "<tr>"
                + "<td>" + pizza.code + "</td>"
                + "<td>" + pizza.nom + "</td>"
                + "<td>" + pizza.prix + "</td>"
                + "<td>" + pizza.categorie + "</td>"
                + "</tr>";
            return linePizza;
        });
        $(".table tbody").html(bodyLines);
    });
});

//$("#connect").onclick = connect();

function connecter(){

    $("#connectLogin").append($("#login").val());
    $("#connectPassword").append($("#password").val());
    $("#connection").show();
}