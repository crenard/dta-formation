class CommandsController {
    constructor() {}
    click(pizza) {
        this.onSelect({
            $event: pizza
        });
    }
}

export const Commands = {
        bindings: {
            pizzas: '=',
            onSelect: '&'
        },
        controller: CommandsController,
        template: `
                <button type="button" class="list-group-item" ng-repeat="pizza in $ctrl.pizzas track by $index" ng-click="$ctrl.click(pizza)" ng-class="{'list-group-item-danger': pizza.status === 'WRONG'}" ng-disabled="pizza.status === 'WRONG'">{{ pizza.recipe }}
                </button>`
}