package mars;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Plateau {

    private Map<Point, Rover> map;
    private static Plateau instance;

    private Plateau() {
        map = new HashMap<>();
    }

    public static Plateau getInstance(/*as per constructor*/) {
        if (instance == null) {
            instance = new Plateau();
        }
        return instance;
    }
}
