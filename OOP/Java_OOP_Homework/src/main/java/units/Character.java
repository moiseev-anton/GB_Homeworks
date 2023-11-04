package units;

import map.Position;

import java.util.ArrayList;
import java.util.Random;

public abstract class Character implements UnitInterface {
    protected String name;
    protected int health, maxHealth;
    protected int attackDamage;
    protected int defence;
    protected int initiative;
    protected Position position;
    protected States state;

    /**
     * Конструктор персонажа
     *
     * @param maxHealth    Максимальное здоровье
     * @param attackDamage Наносимый урон
     * @param defence      Защита
     * @param initiative   Приоритет хода
     * @param x            Координата X персонажа на поле
     * @param y            Координата Y персонажа на поле
     */
    public Character(int maxHealth, int attackDamage, int defence, int initiative, int x, int y) {
        this.name = getRandomName();
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.defence = defence;
        this.attackDamage = attackDamage;
        this.initiative = initiative;
        this.position = new Position(x, y);
        this.state = States.READY;
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

    @Override
    public void step(ArrayList<Character> targetTeam, ArrayList<Character> friendTeam) {
        Character nearestUnit = findNearestTarget(targetTeam);
        System.out.println(nearestUnit.toString() + " " + nearestUnit.getName() + " is nearest for "
                + this.toString() + " " + this.getName());
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

    // метод атаки
    public void attack(Character target) {
        target.takeDamage(this.attackDamage);
        this.state = States.ATTACK;
    }

    // метод лечения
    public void heal(int hp) {
        this.health = Math.min(this.health + hp, this.maxHealth);
    }

    public boolean isDead() {
        return this.state.equals(States.DEAD);
    }
}
