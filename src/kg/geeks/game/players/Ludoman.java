package kg.geeks.game.players;

import java.util.Random;

public class Ludoman extends Hero {
    private Random random = new Random();

    public Ludoman(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.GAMBLING);

    }

    public void applySuperPower(Boss boss, Hero[] heroes) {
        int dice1 = random.nextInt(6) + 1;
        int dice2 = random.nextInt(6) + 1;

        System.out.println("🎲 Лудоман бросает кости: " + dice1 + " и " + dice2);

        if (dice1 == dice2) {
            int damage = dice1 * dice2;
            boss.setHealth(boss.getHealth() - damage);

        }
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {

    }
}
