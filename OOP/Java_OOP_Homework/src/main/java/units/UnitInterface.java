package units;

import java.util.ArrayList;

public interface UnitInterface {
    void step(ArrayList<Character> targetTeam, ArrayList<Character> friendTeam);

    String getInfo();
}
