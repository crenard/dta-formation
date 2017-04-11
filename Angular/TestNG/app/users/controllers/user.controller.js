export class UserController {
    constructor(UsersService, $routeParams, $location, AlertService) {
        this.UsersService = UsersService;
        this.$location = $location;
        this.AlertService = AlertService;
        this.UsersService.getUser($routeParams.id)
            .then(user => this.user = user);
    }

    save(addForm) {
        if (addForm.$valid) {
            this.UsersService.saveUser(this.user)
                .then(() => this.AlertService.addAlert('Modification de la BDD'))
                .then(() => this.$location.path('/users'))
                .catch(() => this.AlertService.addAlert('Aucune modification', 'danger'));
        }
    }
}