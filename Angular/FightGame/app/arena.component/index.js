import template from './arena.html';

class controller {
    $onInit() {
        // this.team1 = {
        //     name: 'Pizzayolos',
        //     mode: 'attack',
        //     fighters: [{ email: 'renard.cyrille@gmail.com', hp: 40, strength: 2 }, 
        //     { email: 'charlery.christopher@gmail.com', hp: 20, strength: 5 },
        //     { email: 'dark.pl@hotmail.fr', hp: 30, strength: 3 }]
        // };
        // this.team2 = {
        //     name: 'TeamNoVice',
        //     mode: 'defense',
        //     fighters: [{ email: 'paolalambroni@gmail.com', hp: 60, strength: 0 }, 
        //     { email: 'lehardy.david@live.fr', hp: 30, strength: 3 },
        //     { email: 'gigarelt@gmail.com', hp: 10, strength: 10 }]
        // };
        this.teams = [{
            name: 'Pizzayolos',
            mode: 'attack',
            fighters: [{ email: 'renard.cyrille@gmail.com', hp: 40, strength: 2 },
            { email: 'charlery.christopher@gmail.com', hp: 20, strength: 5 },
            { email: 'dark.pl@hotmail.fr', hp: 30, strength: 3 }]
        },
        {
            name: 'TeamNoVice',
            mode: 'defense',
            fighters: [{ email: 'paolalambroni@gmail.com', hp: 60, strength: 1 },
            { email: 'lehardy.david@live.fr', hp: 30, strength: 3 },
            { email: 'gigarelt@gmail.com', hp: 10, strength: 10 }]
        }];

    }

    setDamages(damages) {
        this.damages = damages;
    }

    attackEnd() {
        this.damages = 0;
    }

    nextTurn() {
        this.teams.forEach(team => 
            team.mode = team.mode === 'defense' ? 'attack' : 'defense'
        )
    }
}

export const ArenaComponent = {
    bindings: {},
    controller,
    template
}