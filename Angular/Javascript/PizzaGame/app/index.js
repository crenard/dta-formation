import { RecipeService } from './recipes';
import { PizzaService } from './pizzas';
import { PizzeriaService } from './pizzeria';

let recipeService = new RecipeService;
let pizzaService = new PizzaService;
let pizzeriaService = new PizzeriaService;

let domPizzaHeading = document.getElementById('pizzaName');
let domCommandList = document.getElementById('commands');
let domToppingList = document.getElementById('toppings');
let domPizzaToppings = document.getElementById('pizzaToppings');

recipeService.getToppings().then(toppings => addToppingsToList(toppings, 'toppings'));

pizzeriaService.start(addCommandToList);

domCommandList.addEventListener('click', eventAddCommand, false);

domToppingList.addEventListener('click', eventAddTopping, false);

function eventAddCommand(event) {
    if (event.target && event.target.nodeName === "LI" && JSON.parse(event.target.getAttribute('clickable'))) {
        printPizza(event.target.getAttribute('data-pizza'));
    }
}

function eventAddTopping(event) {
    if (event.target && event.target.nodeName === "LI") {
        let topping = event.target.innerText;
        let pizzaId = domPizzaHeading.getAttribute('id-pizza');
        pizzaService.addTopping(pizzaId, topping)
            .then(pizza => {
                printPizza(pizzaId);
                recipeService.getRecipe(pizza.recipe)
                    .then(recipe => checkPizza(pizza, recipe));
            })
    }
}

function checkPizza(pizza, recipe) {
    let result = recipe.toppings.reduce((acc, top) => {
        let first = pizza.toppings.indexOf(top);
        let last = pizza.toppings.lastIndexOf(top);
        if (first !== -1 && first === last) acc.ok++;
        else acc.ko++;
        return acc;
    }, { ok: 0, ko: 0 });
    if (result.ok < pizza.toppings.length) {
        disableCommand(pizza.id);
    }
    else if (result.ko === 0) {
        pizzeriaService.completeOne();
        removePizza(pizza.id);
    }

}

function disableCommand(pizzaId) {
    let li = document.querySelector(`[data-pizza="${pizzaId}"]`);
    li.setAttribute('class', li.getAttribute('class') + ' list-group-item-danger');
    li.setAttribute('clickable', false);
    li.style.cursor = 'default';
}

function addToppingsToList(toppings, listName) {
    toppings.forEach(top => {
        let li = document.createElement('li');
        li.style.cursor = 'pointer';
        li.innerText = top;
        addItemToList(li, listName);
    });
}

function addCommandToList(pizza) {
    let li = document.createElement('li');
    li.style.cursor = 'pointer';
    li.setAttribute('data-pizza', pizza.id);
    li.setAttribute('clickable', true);
    li.innerHTML = pizza.recipe;
    addItemToList(li, 'commands');
}

function addItemToList(li, listName) {
    li.setAttribute('class', 'list-group-item');
    document.getElementById(listName).appendChild(li);
}

function printPizza(pizzaId) {
    pizzaService.getPizza(pizzaId)
        .then(pizza => {
            domPizzaHeading.innerText = pizza.recipe;
            domPizzaHeading.setAttribute('id-pizza', pizzaId);
            domPizzaToppings.innerText = "";
            pizza.toppings.forEach(top => {
                let li = document.createElement('li');
                li.innerText = top;
                addItemToList(li, 'pizzaToppings')
            });
        });
}

function removePizza(pizzaId) {
    domCommandList.querySelector(`[data-pizza="${pizzaId}"]`).remove();
}
