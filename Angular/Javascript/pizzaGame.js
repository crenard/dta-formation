// let recipes = [
//     {
//         name: 'Regina',
//         toppings: ['jambon', 'fromage', 'champignon']
//     },
//     {
//         name: '3 fromages',
//         toppings: ['Mozzarella', 'Chevre', 'Bleu']
//     }
// ];

let recipes = [];

fetch('http://10.1.0.136:3000/recipes')
    .then(resp => resp.json())
    .then(recipes => recipes.forEach(addRecipe));

function findRecipe(recipeName) {
    return recipes.find(recipe => recipe.name === recipeName);
}

let piz1 = { recipe: 'Regina', toppings: ['jambon'] };

let pizzaPool = [piz1];

recipes.forEach(recipe =>
    document.getElementById('recipeList').appendChild(document.createElement('li')).innerHTML = recipe.name);

console.log(getStatus(piz1));
piz1.toppings.push('oeuf');
console.log(getStatus(piz1));

console.log(findStatus('wrong'));
console.log(findStatus('complete'));
console.log(nbStatus('wrong'));
console.log(nbStatus('complete'));

addRecipe({ name: 'Bolo', toppings: ['Tomate', 'Boeuf'] });

document.getElementById('clickMe').addEventListener('click', addClick, false);

document.getElementById('flush').addEventListener('click', flushClick, false);


function getStatus(pizza) {
    let recipe = findRecipe(pizza.recipe);
    let result = recipe.toppings.reduce((acc, top) => {
        let first = pizza.toppings.indexOf(top);
        let last = pizza.toppings.lastIndexOf(top);
        if (first !== -1 && first === last) acc.ok++;
        else acc.ko++;
        return acc;
    }, { ok: 0, ko: 0 });
    if (result.ok < pizza.toppings.length) return 'wrong';
    else if (result.ko > 0) return 'incomplete';
    else return 'complete';
}

function findStatus(status) {
    return pizzaPool.filter(p => getStatus(p) === status);
}

function nbStatus(status) {
    return findStatus(status).length;
}

function removePizza(pizza) {
    return pizzaPool.filter(p => p.name === pizza.name);
}

function addRecipe(recipe) {
    recipes.push(recipe);
    document.getElementById('recipeList').appendChild(document.createElement('li')).innerHTML = recipe.name;
}

function addClick() {
    let input = document.getElementById('recipeName');
    addRecipe({ name: input.value, toppings: [] });
    input.value = "";
}

function flushClick() {
    recipes = [];
    document.getElementById('recipeList').innerHTML = "";
}
