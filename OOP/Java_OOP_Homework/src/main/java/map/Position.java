package map;

import units.Character;

import java.util.ArrayList;

public class Position {
    private int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }


    public void setX(int x) {
        this.x = x;
    }


    public int getY() {
        return y;
    }


    public void setY(int y) {
        this.y = y;
    }


    // метод нахождения расстояния между двумя позициями
    public double getDistance(Position otherPosition) {
        int dX = otherPosition.x - this.x;
        int dY = otherPosition.y - this.y;
        return Math.sqrt(dX * dX + dY * dY);
    }


    // проверка не занята ли ячейка
    public boolean isEmpty(ArrayList<Character> team) {
        for (Character unit : team) {
            if (this.isEqual(unit.getPosition()) && !unit.isDead()) {
                return false;
            }
        }
        return true;
    }


    // метод выбора следующей ячейки
    public Position getNextPosition(Position targetPosition) {
        if (Math.abs(this.x - targetPosition.x) > Math.abs(this.y - targetPosition.y)) {
            if (this.x > targetPosition.x) {
                return new Position(this.x - 1, this.y);
            } else {
                return new Position(this.x + 1, this.y);
            }
        } else {
            if (this.y > targetPosition.y) {
                return new Position(this.x, this.y - 1);
            } else {
                return new Position(this.x, this.y + 1);
            }
        }
    }


    @Override
    public String toString() {
        return "x: " + x + " y: " + y;
    }


    public boolean isEqual(Position position) {
        return this.x == position.x && this.y == position.y;
    }
}
