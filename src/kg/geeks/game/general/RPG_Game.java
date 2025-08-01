package kg.geeks.game.general;

import kg.geeks.game.players.*;

import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();

    public static int getRoundNumber() {
        return roundNumber;
    }

    private static int roundNumber;

    public static void startGame() {
        Boss boss = new Boss(1500, 50, "Dragon");

        Warrior warrior1 = new Warrior(270, 20, "Ahiles");
        Warrior warrior2 = new Warrior(280, 15, "Hercules");
        Magic magic = new Magic(290, 10, "Dumbledore");
        Medic doc = new Medic(250, 5, "Aibolit", 15);
        Medic assistant = new Medic(300, 5, "Junior", 5);
        Berserk berserk = new Berserk(260, 10, "Viking");
        Ludoman ludoman = new Ludoman(250, 15, "Ivan");
        Hacker hacker = new Hacker(220, 10, "Nolan");
        King king = new King(150, 0, "King");
        Saitama saitama = new Saitama(1000, 10000, "Saitama");
        Hero[] heroes = {warrior1, doc, magic, warrior2, berserk, assistant, ludoman, hacker, king, saitama};

        printStatistics(boss, heroes);
        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
            return true;
        }
        return false;
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence();
        boss.attack(heroes);
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0 &&
                boss.getDefence() != hero.getAbility()) {
                hero.attack(boss);
                hero.applySuperPower(boss, heroes);
            }
        }
        printStatistics(boss, heroes);
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " -----------");
        System.out.println(boss);
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }
}
