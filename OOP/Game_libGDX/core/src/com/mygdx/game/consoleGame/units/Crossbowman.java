package com.mygdx.game.consoleGame.units;

import com.badlogic.gdx.graphics.Texture;

public class Crossbowman extends Shooter {
    public Crossbowman(int x, int y) {
        super(15, 8, 4, new Texture("units/CrossBowMan.png"), x, y, 0.7, 7);
    }
}
