import { random } from 'lodash';

export class FightService {
    constructor() {
        window.f = this;
        this.teams = [
            {
                name: 'ByteClub',
                fighters: [
                    {
                        email: 'tmoyse@gmail.com',
                        life: 20,
                        mana: 10,
                        attack: [3, 5],
                    },
                    {
                        email: 'delapouite@gmail.com',
                        life: 20,
                        mana: 10,
                        attack: [3, 5],
                    },
                    {
                        email: 'lehardy.david@live.fr',
                        life: 200,
                        mana: 10,
                        attack: [10, 30],
                    }
                ]
            },
            {
                name: 'P. de code',
                fighters: [
                    {
                        email: 'finalboss@esn.fr',
                        life: 100,
                        mana: 0,
                        attack: [1, 4],
                    }
                ]
            },
        ];
        
        this.round = 0;
        this.waitingForTarget = false;
        this.nextRound();
    }

    nextRound() {
        this.updateMana();
        this.round++;
        this.attackers = this.getFighters().map(f => f.email);
        if (this.round % 2 === 1) {
            this.autoPlay();
        }
    }

    getDamage(email) {
        const fighter = this.getFighter(email);
        return fighter ? random(...fighter.attack) : 0;
    }

    getFighter(email, side = 0) { // att 0 to look in attacker team, 1 to look in def 
        return this.getFighters(side).find(f => f.email === email);
    }

    getFighters(side = 0) {
        return this.teams[(this.round + side) % 2]
            .fighters
            .filter(f => f.life > 0);
    }

    globalAttack(fighter) {
        if (fighter.mana < 5) return;
        fighter.mana -= 5;
        this.resolveAttack(this.getFighters(1).map(f => f.email));
    }

    resolveAttack(targets) {
        const activeAttacker = this.attackers.shift();
        const damages = this.getDamage(activeAttacker);

        targets.forEach(email => {
            let fighter = this.getFighter(email, 1);
            fighter.life = Math.max(fighter.life - damages, 0);
        });
        this.waitingForTarget = false;
        if (this.attackers.length === 0) this.nextRound();
    }

    updateMana() {
        this.teams.forEach(team =>
            team.fighters.forEach(f =>
                f.mana = Math.min(10, f.mana + 1)
            )
        )
    }

    getRandomFighter() {
        let opponents = this.getFighters(1);
        return opponents[Math.floor(Math.random() * opponents.length)];
    }

    attackFighter(boss, isRandom) {
        if (boss.mana >= 5) {
            console.log('BOOM !!');
            this.globalAttack(boss);
        }
        else {
            console.log('Prends ça !');
            if (isRandom) {
                this.resolveAttack([this.getRandomFighter().email]);
            }
            else {
                this.resolveAttack([this.getFighters(1).reduce((acc, fighter) => {
                    return (fighter.life < acc.life) ? fighter : acc;
                }, { life: 100 }).email]);
            }
        }
    }

    nuageToxique(boss, damage) {
        if (!this.thresholds)
            this.thresholds = [75, 50, 25];
        if (this.thresholds.length > 0 && boss.life <= this.thresholds[0]) {
            this.getFighters(1).map(fighter => fighter.life = Math.max( fighter.life - damage, 0));
            console.log('Nuage toxique !');
            this.thresholds.shift();
        }
    }

    autoAction(boss) {
        if (boss.life > 75) {
            console.log('Prends ça !')
            this.resolveAttack([this.getRandomFighter().email]);
        }
        else if (boss.life > 50) {
            boss.attack = [2, 5];
            this.nuageToxique(boss, 1);
            this.attackFighter(boss, true);
        }
        else if (boss.life > 25) {
            boss.attack = [2, 6];
            this.nuageToxique(boss, 2);
            this.attackFighter(boss, false);
        }
        else {
            boss.attack = [3, 7];
            this.nuageToxique(boss, 3);
            this.attackFighter(boss, false);
        }
    }

    autoPlay() {
        while(this.attackers.length > 0 && this.round % 2 === 1){
            this.autoAction(this.getFighter(this.attackers[0]))
        };
    }
}