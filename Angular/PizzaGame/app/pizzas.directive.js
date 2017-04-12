class PizzaDirectiveController {
    constructor() {}
    click(pizza) {
        this.onSelect({
            $event: pizza
        });
    }
}

export function PizzasDirective () {
    return {
        restrict: 'E',
        template: `
            <ul id="commands" class="list-group">
                <li class="list-group-item" ng-repeat="pizza in ctrl.pizzas track by $index" ng-click="ctrl.click(pizza) ">{{ pizza.recipe }}
                </li>
            </ul>`,
        controller: PizzaDirectiveController,
        controllerAs: 'ctrl',
        bindToController: {
            pizzas: '=',
            onSelect: '&'
        },
        scope: {}
    }
}