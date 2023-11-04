package com.mygdx.game.consoleGame.units;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public abstract class Magician extends Character {
    private int mana;
    private int maxMana;


    /**
     * Конструктор магов
     *
     * @param maxHealth    max здоровье
     * @param maxMana      max мана
     * @param attackDamage наносимый урон
     * @param defence      защита
     * @param texture      иконка
     * @param x            x
     * @param y            y
     */
    public Magician(int maxHealth, int maxMana, int attackDamage, int defence, Texture texture, int x, int y) {
        super(maxHealth, attackDamage, defence, 1, texture, x, y);
        this.mana = maxMana;
        this.maxMana = maxMana;
    }


    @Override
    public void step(ArrayList<Character> targetTeam, ArrayList<Character> friendTeam) {
        if (this.isDead()) return;
        if (mana > attackDamage) {
            Character target = findWeakestUnit(friendTeam);
            if (getHealthPercent(target) <= 0.5) {
                target.heal(attackDamage);
                mana -= attackDamage;
                this.state = States.HEAL;
            } else {
                target = findNearestTarget(targetTeam);
                if (target != null) {
                    this.attack(target);
                    mana -= attackDamage;
                    if (target.isDead()) {
                        mana = Math.min(mana + (int) (maxMana * 0.25), maxMana); // бонус маны за "ласт хит"
                    }
                }
            }
        } else {
            mana += (int) (attackDamage * 0.5);
            this.state = States.EMPTY;
        }
    }


    // метод нахождения юнита с наименьшим здоровьем.
    protected Character findWeakestUnit(ArrayList<Character> targetTeam) {
        Character weakest = null;
        double minHealth = Double.MAX_VALUE;
        for (Character unit : targetTeam) {
            if (unit.isDead()) {
                continue;
            }
            double healthPercent = getHealthPercent(unit);
            if (healthPercent < minHealth) {
                weakest = unit;
                minHealth = healthPercent;
            }
        }
        return weakest;
    }


    private double getHealthPercent(Character unit) {
        return unit.health / unit.maxHealth;
    }


    // метод получения урона. маг тратит ману на защиту
    @Override
    public void takeDamage(int damage) {
        int currentDefence = Math.min(mana, defence);
        health -= Math.max(damage - currentDefence, 0);
        if (health <= 0) {
            health = 0;
            this.state = States.DEAD;
        }
        mana -= currentDefence;
    }


    @Override
    public String getInfo() {
        return super.getInfo() + " mana: " + this.mana + "/" + this.maxMana;
    }
}

