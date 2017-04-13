class ToppingsDirectiveController {
    constructor() { }
    click(topping) {
        this.onSelect({
            $event: topping
        });
    }
}

export function ToppingsDirective() {
    return {
        restrict: 'E',
        template: `
                <button type="button" class="list-group-item" ng-repeat="topping in ctrl.toppings track by $index" ng-click="ctrl.click(topping) ">{{ topping }}
                </button>`,
        controller: ToppingsDirectiveController,
        controllerAs: 'ctrl',
        bindToController: {
            toppings: '=',
            onSelect: '&'
        },
        scope: {}
    }
}