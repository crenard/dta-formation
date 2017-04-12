class ToppingsDirectiveController {
    constructor() {}
    click(topping) {
        this.onSelect({
            $event: topping
        });
    }
}

export function ToppingsDirective () {
    return {
        restrict: 'E',
        template: `
            <ul id="toppings" class="list-group">
                <li class="list-group-item" ng-repeat="topping in ctrl.toppings track by $index" ng-click="ctrl.click(topping) ">{{ topping }}
                </li>
            </ul>`,
        controller: ToppingsDirectiveController,
        controllerAs: 'ctrl',
        bindToController: {
            toppings: '=',
            onSelect: '&'
        },
        scope: {}
    }
}