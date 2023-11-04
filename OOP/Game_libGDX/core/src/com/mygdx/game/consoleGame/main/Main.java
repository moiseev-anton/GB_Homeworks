package com.mygdx.game.consoleGame.main;

import com.mygdx.game.consoleGame.units.*;
import com.mygdx.game.consoleGame.units.Character;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Main {
    public ArrayList<Character> greenTeam = new ArrayList<>();
    public ArrayList<Character> blueTeam = new ArrayList<>();
    public ArrayList<Character> allUnits = new ArrayList<>();
    public ArrayList<Character> unitsListForRendering = new ArrayList<>();

    public void main() {

        fillLightSideTeam(greenTeam, 10, true);
        fillDarkSideTeam(blueTeam, 10, false);
        allUnits.addAll(greenTeam);
        allUnits.addAll(blueTeam);
        unitsListForRendering.addAll(allUnits);

        // сортировка по инициативе
        allUnits.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return Integer.compare(o2.getInitiative(), o1.getInitiative());
            }
        });

        // сортировка по координате Y (для отображения)
        unitsListForRendering.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return Integer.compare(o2.getPosition().getY(), o1.getPosition().getY());
            }

        });
    }

    public boolean run() {
        for (Character unit : allUnits) {
            if (greenTeam.contains(unit)) {
                unit.step(blueTeam, greenTeam);
            } else {
                unit.step(greenTeam, blueTeam);
            }
        }
        return (isTeamHasAlive(greenTeam) && isTeamHasAlive(blueTeam));
    }


    public static void fillDarkSideTeam(ArrayList<Character> team, int teamSize, boolean isLeftTeam) {
        Random random = new Random();
        int startX = isLeftTeam ? 1 : 10;

        for (int i = 1; i <= teamSize; i++) {
            int randomNum = random.nextInt(4);
            switch (randomNum) {
                case 0:
                    team.add(new Crossbowman(startX, i));
                    break;
                case 1:
                    team.add(new Wizard(startX, i));
                    break;
                case 2:
                    team.add(new Rogue(startX, i));
                    break;
                default:
                    team.add(new Peasant(startX, i));
                    break;
            }
        }
    }


    public static void fillLightSideTeam(ArrayList<Character> team, int teamSize, boolean isLeftTeam) {
        Random random = new Random();
        int startX = isLeftTeam ? 1 : 10;

        for (int i = 1; i <= teamSize; i++) {
            int randomNum = random.nextInt(4);
            switch (randomNum) {
                case 0:
                    team.add(new Archer(startX, i));
                    break;
                case 1:
                    team.add(new Monk(startX, i));
                    break;
                case 2:
                    team.add(new Spearman(startX, i));
                    break;
                default:
                    team.add(new Peasant(startX, i));
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