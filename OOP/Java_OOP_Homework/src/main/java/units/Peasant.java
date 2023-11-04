package units;

import java.util.ArrayList;

public class Peasant extends Character {
    public Peasant(int x, int y) {
        super(5, 1, 3, 0, x, y);
    }


    @Override
    public String getInfo() {
        return super.getInfo();
    }


    @Override
    public void step(ArrayList<Character> targetTeam, ArrayList<Character> friendTeam) {
        if (state.equals(States.DEAD)) {
            return;
        }
        state = States.READY;
    }
}
