package com.mygdx.game.consoleGame.units;

import com.badlogic.gdx.graphics.Texture;

public class Wizard extends Magician {
    public Wizard(int x, int y) {
        super(30, 70, 5, 4, new Texture("units/Wizard.png"), x, y);
    }
}
