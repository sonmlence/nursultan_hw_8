package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;
public class Magic extends Hero {
    private boolean[] boostedHeroes = new boolean[10];

    public Magic(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (RPG_Game.getRoundNumber() <= 4) {
            System.out.println("Magic использует способность увеличения урона!");
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i] != this && heroes[i].getHealth() > 0 && !boostedHeroes[i]) {
                    heroes[i].setDamage(heroes[i].getDamage() + 10);
                    boostedHeroes[i] = true;
                    System.out.println(heroes[i].getClass().getSimpleName() + " урон теперь: " + heroes[i].getDamage());
                }
            }
        }
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {

    }
}
