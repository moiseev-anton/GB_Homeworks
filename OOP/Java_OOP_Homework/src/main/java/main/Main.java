package main;

import units.*;
import units.Character;
import views.View;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static ArrayList<Character> greenTeam = new ArrayList<>();
    public static ArrayList<Character> blueTeam = new ArrayList<>();
    public static ArrayList<Character> allUnits = new ArrayList<>();

    public static void main(String[] args) {
        fillLightSideTeam(greenTeam, 10, true);
        fillDarkSideTeam(blueTeam, 10, false);
        allUnits.addAll(greenTeam);
        allUnits.addAll(blueTeam);
        allUnits.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return Integer.compare(o2.getInitiative(), o1.getInitiative());
            }
        });

        Scanner in = new Scanner(System.in);
        while (isTeamHasAlive(greenTeam) && isTeamHasAlive(blueTeam)) {
            View.view();
            in.nextLine();
            for (Character unit : allUnits) {
                if (greenTeam.contains(unit)) {
                    unit.step(blueTeam, greenTeam);
                } else {
                    unit.step(greenTeam, blueTeam);
                }
            }
        }
        View.view(); // вывод победителя
    }


    public static void fillDarkSideTeam(ArrayList<Character> team, int teamSize, boolean isLeftTeam) {
        Random random = new Random();
        int startY = isLeftTeam ? 1 : 10;

        for (int i = 1; i <= teamSize; i++) {
            int randomNum = random.nextInt(4);
            switch (randomNum) {
                case 0:
                    team.add(new Crossbowman(i, startY));
                    break;
                case 1:
                    team.add(new Wizard(i, startY));
                    break;
                case 2:
                    team.add(new Rogue(i, startY));
                    break;
                default:
                    team.add(new Peasant(i, startY));
                    break;
            }
        }
    }

    public static void fillLightSideTeam(ArrayList<Character> team, int teamSize, boolean isLeftTeam) {
        Random random = new Random();
        int startY = isLeftTeam ? 1 : 10;

        for (int i = 1; i <= teamSize; i++) {
            int randomNum = random.nextInt(4);
            switch (randomNum) {
                case 0:
                    team.add(new Archer(i, startY));
                    break;
                case 1:
                    team.add(new Monk(i, startY));
                    break;
                case 2:
                    team.add(new Spearman(i, startY));
                    break;
                default:
                    team.add(new Peasant(i, startY));
                    break;
            }
        }
    }

    public static boolean isTeamHasAlive(ArrayList<Character> team) {
        for (Character unit : team) {
            if (!unit.isDead()) return true;
        }
        return false;
    }
}