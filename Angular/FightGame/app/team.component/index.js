import template from './team.html';

class controller {
    attackEnd(){
        this.onAfterFight();
    }

    setDamages(damages) {
        this.damages = damages;
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