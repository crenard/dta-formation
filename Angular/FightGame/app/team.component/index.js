import template from './team.html';

class controller {
    $onInit(){
        this.teamForce = this.fighters.length;
    }
    attackEnd(){
        this.onAfterFight();
    }

    setDamages(damages) {
        this.damages = damages;
    }

    teamMemberDied() {
        this.teamForce--;
    }
}

export const TeamComponent = {
    bindings: {
        mode: '=',
        fighters: '<',
        name: '<',
        damages: '=',
        onFight: '&',
        onAfterFight: '&'
    },
    controller,
    template
}