package units;

import java.util.ArrayList;

public abstract class Shooter extends Character {
    private double minAccuracy; // вероятность попадания при масимальном удалении от цели
    private int maxArrows;
    private int arrows;

    /**
     * Конструктор стрелков
     *
     * @param maxHealth    max здоровье
     * @param attackDamage наносимый урон
     * @param defence      защита
     * @param x            x
     * @param y            y
     * @param minAccuracy  меткость
     * @param maxArrows    количество стрел
     */
    public Shooter(int maxHealth, int attackDamage, int defence, int x, int y, double minAccuracy, int maxArrows) {
        super(maxHealth, attackDamage, defence, 3, x, y);
        this.minAccuracy = minAccuracy;
        this.arrows = this.maxArrows = maxArrows;
    }


    @Override
    public void step(ArrayList<Character> targetTeam, ArrayList<Character> friendTeam) {
        if (this.isDead()) return;
        if (arrows <= 0) {
            this.state = States.EMPTY;
        } else {
            Character target = findNearestTarget(targetTeam);
            if (target != null) {
                this.attack(target);
                arrows--;
            }
        }
        for (Character friend : friendTeam) {
            if (friend instanceof Peasant && friend.state.equals(States.READY)) {
                arrows++;
                friend.state = States.CRAFTING;
                return;
            }
        }
    }


    // метод атаки с зависимостью меткости и урона от расстояния до цели
    @Override
    public void attack(Character target) {
        double distance = this.getDistanceTo(target);
        double accuracy = this.minAccuracy + (1 - this.minAccuracy) * (1 - distance / 13); // вычисляем коэффициент попадания и урона, зависящий от расстояния
        int damage = (int) Math.round(this.attackDamage * accuracy);
        if (Math.random() <= accuracy) {
            target.takeDamage(damage);
            this.state = States.ATTACK;
        }
    }


    @Override
    public String getInfo() {
        return super.getInfo() + " arrows: " + this.arrows + "/" + this.maxArrows;
    }
}

