package com.mygdx.game.consoleGame.units;

import com.mygdx.game.consoleGame.map.Position;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.Texture;

public abstract class Character implements UnitInterface {
    protected String name;
    protected int health, maxHealth;
    protected int attackDamage;
    protected int defence;
    protected int initiative;
    protected Position position;
    protected States state;
    protected Texture texture;

    /**
     * Конструктор персонажа
     *
     * @param maxHealth    Максимальное здоровье
     * @param attackDamage Наносимый урон
     * @param defence      Защита
     * @param initiative   Приоритет
     * @param texture      Иконка персонажа
     * @param x            Координата X
     * @param y            Координата Y
     */
    public Character(int maxHealth, int attackDamage, int defence, int initiative, Texture texture, int x, int y) {
        this.name = getRandomName();
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.defence = defence;
        this.attackDamage = attackDamage;
        this.initiative = initiative;
        this.position = new Position(x, y);
        this.state = States.READY;
        this.texture = texture;
    }

    public String getName() {
        return name;
    }


    public Position getPosition() {
        return position;
    }


    public int getInitiative() {
        return this.initiative;
    }


    // метод присвоения персонажу рандомного имени
    private String getRandomName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length)]);
    }


    // метод поиска близжайшей к юниту цели
    protected Character findNearestTarget(ArrayList<Character> targetTeam) {
        Character nearest = null;
        double minDistance = Double.MAX_VALUE;
        for (Character unit : targetTeam) {
            if (unit.isDead()) {
                continue;
            }
            double distanceToTarget = this.getDistanceTo(unit);
            if (distanceToTarget < minDistance) {
                nearest = unit;
                minDistance = distanceToTarget;
            }
        }
        return nearest;
    }


    // метод возвращает название класса, к которому относится юнит
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }


    @Override
    public String getInfo() {
        return this.toString() + " " + this.name + " " + this.state + " \u2764: " + this.health + "/" + this.maxHealth
                + " \u2694: " + this.attackDamage + " \u26CA: " + this.defence + " ";
    }


    // метод получения урона
    public void takeDamage(int damage) {
        this.health -= Math.max(damage - defence, 0);
        if (health <= 0) {
            health = 0;
            this.state = States.DEAD;
        }
    }


    public double getDistanceTo(Character target) {
        return this.position.getDistance(target.position);
    }


    public void attack(Character target) {
        target.takeDamage(this.attackDamage);
        this.state = States.ATTACK;
    }


    public void heal(int hp) {
        this.health = Math.min(this.health + hp, this.maxHealth);
    }


    public boolean isDead() {
        return this.state.equals(States.DEAD);
    }


    public Texture getTexture() {
        return this.texture;
    }
}
