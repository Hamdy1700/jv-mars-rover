package mars;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Plateau {

    private Map<Point, Rover> map;
    private final PlateauSize size;
    private static Plateau instance;

    private Plateau(PlateauSize size) {
        this.map = new HashMap<>();
        this.size = size;
    }

    public Map<Point, Rover> getMap() {
        return map;
    }

    public static Plateau getInstance(PlateauSize size) {
        if (instance == null) {
            instance = new Plateau(size);
        }
        return instance;
    }
}
