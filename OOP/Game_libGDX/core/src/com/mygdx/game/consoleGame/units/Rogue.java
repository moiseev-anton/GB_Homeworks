package com.mygdx.game.consoleGame.units;

import com.badlogic.gdx.graphics.Texture;

public class Rogue extends Warrior {
    public Rogue(int x, int y) {
        super(40, 7, 6, new Texture("units/Rogue.png"), x, y, 40);
    }
}
