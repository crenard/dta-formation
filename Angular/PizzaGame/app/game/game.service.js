export class GameService {
    constructor($timeout, RecipesService, $q) {
        this.RecipesService = RecipesService;
        this.$timeout = $timeout;
        this.pizzas = [];
        this.speed = 1000;
        this.$q = $q;
        this.score = 0;
        this.id =1;
    }

    start() {
        return new this.$q(resolve => {
            this.getRandomPizza = () => {
                this.RecipesService.getRandomRecipe()
                    .then(recipe =>
                        ({ id: this.id++, recipe: recipe.name, toppings: [] }))
                    .then(pizza => this.pizzas.push(pizza))
                    .then(() => {
                        if (this.pizzas.length > 10) {
                            clearInterval(this.interval);
                            resolve(this.score);
                        }
                    })
            }

            this.interval = setInterval(this.getRandomPizza, this.speed);
        });
    }

    speedUp() {
        this.score++;
        clearInterval(this.interval);
        this.speed = this.speed * 9 / 10;
        this.interval = setInterval(this.getRandomPizza, this.speed);
    }

    removePizza(pizza) {
        const pizzaIndex = this.pizzas.findIndex(p => pizza === p);
        if (pizzaIndex !== -1) {
            this.pizzas.splice(pizzaIndex, 1);
        }
    }

    validPizza(pizza, status){
        if (status === 'COMPLETE'){
            this.speedUp();
            this.removePizza(pizza);
        }
    }
}