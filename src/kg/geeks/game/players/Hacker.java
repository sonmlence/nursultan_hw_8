package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

import java.util.Random;

public class Hacker extends Hero {

    private final int stealAmount = 30;
    private final Random random = new Random();

    public Hacker(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.HACK);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {

        if (RPG_Game.getRoundNumber() % 2 == 0 && boss.getHealth() > 0) {
            boss.setHealth(boss.getHealth() - stealAmount);


            Hero target;
            do {
                int index = random.nextInt(heroes.length);
                target = heroes[index];
            } while (target == this || target.getHealth() <= 0);


            target.setHealth(target.getHealth() + stealAmount);

            System.out.println("💻 Hacker украл " + stealAmount + " HP у босса и передал " +
                    target.getName() + ". У босса осталось: " + boss.getHealth());
        }
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {

    }
}

