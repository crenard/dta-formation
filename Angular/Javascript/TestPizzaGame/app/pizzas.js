const URL = 'http://localhost:3000/pizzas';
let headers = new Headers();
headers.set('Content-Type', 'application/json');

export class PizzaService {
    addPizza(pizza) {
        return fetch(URL, {
            method: 'POST',
            headers,
            body: JSON.stringify(pizza)
        }).then(resp => resp.json());
    }

    savePizza(pizza) {
        return fetch(`${URL}/${pizza.id}`, {
            method: 'PUT',
            headers,
            body: JSON.stringify(pizza)
        }).then(resp => resp.json());
    }

    getPizzas() {
        return fetch(URL)
            .then(resp => resp.json());
    }

    getPizza(id) {
        return fetch(`${URL}/${id}`)
            .then(resp => resp.json());
    }

    deletePizza(id) {
        return fetch(`${URL}/${id}`, {
            method: 'DELETE'
        }).then(resp => resp.json());
    }

    deletePizzas() {
        return this.getPizzas()
            .then(pizzas => Promise.all(pizzas.map(({ id }) =>
                this.deletePizza(id))))
            .then(res => console.log('All deleted'));
    }

    addTopping(pizzaId, topping) {
        return this.getPizza(pizzaId).then(pizza => {
            pizza.toppings.push(topping);
            return this.savePizza(pizza)
        });
    }
}
