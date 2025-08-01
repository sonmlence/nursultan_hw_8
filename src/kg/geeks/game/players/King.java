package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class King extends Hero {
    public King(int health, int damage, String name) {
        super(health, 0, name, SuperAbility.NONE); // урона 0
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {

    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {

        int chance = RPG_Game.random.nextInt(100);
        if (chance < 20) {
            System.out.println(getName() + " призывает Saitama!");
            Saitama saitama = new Saitama(1, 1000, "Saitama");
            saitama.superPowerKillBoss(boss);
        }
    }
}
