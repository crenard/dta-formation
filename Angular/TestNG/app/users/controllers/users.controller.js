export class UsersController {
    constructor(UsersService) {
        this.UsersService = UsersService;
        this.sorter = "name";
        this.UsersService.getUsers()
            .then(users => this.users = users);
    }

    sortBy(sortType) {
        this.sorter = sortType;
    }

    limitQty(qty = this.users.length) {
        this.quantity = qty;
    }

    editForm(user) {
        this.user = angular.copy(user);
    }
    
    deleteUser(user) {
        this.UsersService.deleteUser(user)
            .catch(() => {
                console.log('Erreur de suppression');
                this.users.push(user);
            })
        this.users = this.users.filter(u => u.id !== user.id);
    }
}
