package com.mygdx.game.consoleGame.units;

import com.badlogic.gdx.graphics.Texture;

public class Archer extends Shooter {
    public Archer(int x, int y) {
        super(15, 6, 4,  new Texture("units/Archer.png"), x, y, 0.8, 10);
    }
}
