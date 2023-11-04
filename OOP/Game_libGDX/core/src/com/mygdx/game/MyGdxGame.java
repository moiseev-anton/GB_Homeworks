package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.consoleGame.main.Main;
import com.mygdx.game.consoleGame.units.Character;

import java.util.Random;


public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    BitmapFont font;
    Texture background, deadUnit;
    Music battleMusic;
    Music endMusic;
    Main game;
    float x, y;

    boolean play, clk;

    @Override
    public void create() {
        game = new Main();
        game.main();
        batch = new SpriteBatch();
        background = new Texture("backgrounds/" + Backgrounds.values()[new Random().nextInt(Backgrounds.values().length)] + ".png");
        battleMusic = Gdx.audio.newMusic(Gdx.files.internal("music/paul-romero-rob-king-combat-theme-0" + (new Random().nextInt(4) + 1) + ".mp3"));
        endMusic = Gdx.audio.newMusic(Gdx.files.internal("music/endMusic.mp3"));
        battleMusic.setLooping(true);
        battleMusic.setVolume(0.075f);
        endMusic.setVolume(0.5f);
        battleMusic.play();
        deadUnit = new Texture("units/Deadunit.png");
        play = clk = true;
        font = new BitmapFont();
    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 0, 0, 1);
        int kx = Gdx.graphics.getWidth() / 12;
        int ky = Gdx.graphics.getHeight() / 15;
        x = Gdx.input.getX();
        y = Gdx.graphics.getHeight() - Gdx.input.getY();
        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // отрисовка мертвых персонажей
        for (Character unit : game.unitsListForRendering) {
            if (unit.isDead()) {
                if (game.greenTeam.contains(unit)) {
                    batch.draw(deadUnit, unit.getPosition().getX() * kx, unit.getPosition().getY() * ky);
                } else {
                    batch.draw(deadUnit, (unit.getPosition().getX() + 1) * kx, unit.getPosition().getY() * ky, -unit.getTexture().getWidth(), unit.getTexture().getHeight());
                }
            }
        }

        // отрисовка живых персонажей
        for (Character unit : game.unitsListForRendering) {
            if (!unit.isDead()) {
                if (game.greenTeam.contains(unit)) {
                    batch.draw(unit.getTexture(), unit.getPosition().getX() * kx, unit.getPosition().getY() * ky);
                } else {
                    batch.draw(unit.getTexture(), (unit.getPosition().getX() + 1) * kx, unit.getPosition().getY() * ky, -unit.getTexture().getWidth(), unit.getTexture().getHeight());
                }
            }
        }

        if (!play) {
            font.draw(batch, "Game over!", 0, Gdx.graphics.getHeight()/2, Gdx.graphics.getWidth(), Align.center, false);
        }
            batch.end();

        if (Gdx.input.isTouched() & play & clk) {
            if (!game.run()) {
                play = false;
                battleMusic.stop();
                endMusic.play();
            }
            clk = false;
        }


        if (!Gdx.input.isTouched()) {
            clk = true;
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
        background.dispose();
        battleMusic.dispose();
        endMusic.dispose();
        deadUnit.dispose();
        for (Character unit : game.allUnits) {
            unit.getTexture().dispose();
        }
    }
}
