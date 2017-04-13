import template from './fighter.html';
import css from './fighter.css';
import md5 from 'md5';

class controller {
    $onInit() {
        this.md5 = md5(this.email)
    }

    fight() {
        this.onFight({
            $event: (this.strength + Math.floor(Math.random() * 3))
        });
    }

    suffer() {
        this.hp = Math.max(this.hp - this.damages, 0);
        this.afterInjured();
    }
}

export const FighterComponent = {
    bindings: {
        email: "<",
        hp: "=",
        strength: "<",
        onFight: '&',
        damages: '<',
        mode: '<',
        afterInjured: '&'
    },
    controller,
    template
}