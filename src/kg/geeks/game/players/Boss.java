package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Boss extends GameEntity {
    private SuperAbility defence;

    public Boss(int health, int damage, String name) {
        super(health, damage, name);
    }

    public void attack(Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                if (hero instanceof Berserk && this.defence != SuperAbility.BLOCK_REVERT) {
                    int blocked = RPG_Game.random.nextInt(1, 3) * 5; // 1, 2
                    ((Berserk) hero).setBlockedDamage(blocked);
                    hero.setHealth(hero.getHealth() - (this.getDamage() - blocked));
                } else {
                    hero.setHealth(hero.getHealth() - this.getDamage());
                }
            }
        }
    }

    public void chooseDefence() {
        // [BOOST, CRITICAL_DAMAGE, BLOCK_REVERT, HEAL]
        SuperAbility[] variants = SuperAbility.values();
        int randomIndex = RPG_Game.random.nextInt(variants.length); // 0,1,2,3
        this.defence = variants[randomIndex];
    }

    public SuperAbility getDefence() {
        return defence;
    }

    @Override
    public String toString() {
        return "BOSS " + super.toString() + " defence: " + this.defence;
    }
}
