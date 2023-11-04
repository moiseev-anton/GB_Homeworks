package com.mygdx.game.consoleGame.units;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class Peasant extends Character {
    public Peasant(int x, int y) {
        super(5, 1, 3, 0, new Texture("units/Peasant.png"), x, y);
    }


    @Override
    public void step(ArrayList<Character> targetTeam, ArrayList<Character> friendTeam) {
        if (state.equals(States.DEAD)) {
            return;
        }
        state = States.READY;
    }
}
