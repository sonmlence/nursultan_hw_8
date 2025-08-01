package kg.geeks.game.players;

public class Saitama extends Hero {

    public Saitama(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.SUPER_KILL);
    }

    // Метод, который убивает босса с одного удара
    public void superPowerKillBoss(Boss boss) {
        boss.setHealth(0);
        System.out.println(getName() + " убивает босса с одного удара!");
    }


    public void applySuperPower(Boss boss, Hero[] heroes) {

    }

    public void applySuperAbility(Boss boss, Hero[] heroes) {
        superPowerKillBoss(boss);
    }
}
