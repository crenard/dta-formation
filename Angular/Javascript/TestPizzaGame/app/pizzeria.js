import { RecipeService } from './recipes';
import { PizzaService } from './pizzas';

let recipeService = new RecipeService;
let pizzaService = new PizzaService;

export class PizzeriaService {
    constructor() {
        this.pizzaCounter = 0;
    }

    start(cb) {
        this.speed = 3000;
        pizzaService.deletePizzas()
            .then(() => this.open(cb));
    }

    open(cb) {
        this.x = () => {
            recipeService.getRandomRecipe()
                .then(recipe =>
                    ({ recipe: recipe.name, toppings: [] }))
                .then(pizza => pizzaService.addPizza(pizza))
                .then(pizza => {
                    this.pizzaCounter++;
                    if (this.pizzaCounter > 10) {
                        clearInterval(this.interval);
                        alert('PERDU');
                        return false;
                    }
                    return pizza;
                })
                .then(cb)
        }

        this.interval = setInterval(this.x, this.speed);
    }

    completeOne() {
        this.pizzaCounter--;
        this.speedUp();
    }

    speedUp() {
        clearInterval(this.interval);
        this.speed = this.speed * 9/10;
        this.interval = setInterval(this.x, this.speed);
    }
}