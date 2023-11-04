package com.mygdx.game.consoleGame.units;

import com.badlogic.gdx.graphics.Texture;

public class Spearman extends Warrior {
    public Spearman(int x, int y) {
        super(50, 8, 4, new Texture("units/SpearMan.png"), x, y, 30);
    }
}
