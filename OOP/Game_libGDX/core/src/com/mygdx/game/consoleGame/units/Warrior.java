package com.mygdx.game.consoleGame.units;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.consoleGame.map.Position;

import java.util.ArrayList;

public abstract class Warrior extends Character {
    private int armor;

    /**
     * Конструктор войнов
     *
     * @param maxHealth    max здоровье
     * @param attackDamage наносимый урон
     * @param defence      защита
     * @param texture      иконка
     * @param x            x
     * @param y            y
     * @param armor        броня
     */
    public Warrior(int maxHealth, int attackDamage, int defence, Texture texture, int x, int y, int armor) {
        super(maxHealth, attackDamage, defence, 2, texture, x, y);
        this.armor = armor;
    }


    @Override
    public void step(ArrayList<Character> targetTeam, ArrayList<Character> friendTeam) {
        if (this.isDead()) return;
        Character target = findNearestTarget(targetTeam);
        if (target != null) {
            double distance = this.getDistanceTo(target);
            if (distance == 1) {
                this.attack(target);
            } else {
                moveTo(target, friendTeam);

            }
        }
    }


    public void moveTo(Character target, ArrayList<Character> friendTeam) {
        Position nextPosition = this.getPosition().getNextPosition(target.getPosition());
        if (nextPosition.isEmpty(friendTeam)) {
            this.position = nextPosition;
            this.state = States.MOVE;
        }
    }


    // метод получения урона c расходом брони (броня не восстанавливается)
    @Override
    public void takeDamage(int damage) {
        damage = Math.max(damage - defence, 0);
        if (armor > 0) { // сперва расходуется броня
            armor = Math.max(armor - damage, 0);
        } else {
            health -= damage;
            if (health <= 0) {
                health = 0;
                this.state = States.DEAD;
            }
        }
    }


    @Override
    public String getInfo() {
        return super.getInfo() + " armor: " + this.armor;
    }
}
