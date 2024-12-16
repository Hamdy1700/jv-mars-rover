package mars;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Plateau {

    private Map<Point, Rover> map;
    private final PlateauSize size;
    private static Plateau instance;

    public Plateau(PlateauSize size) {
        this.map = new HashMap<>();
        this.size = size;
    }

    public void addToPlateau(Rover rover, Position position) throws CollisionException, PlateauOutOfBoundsException {
        Point coordinates = position.getCoordinate();
        int x = (int) coordinates.getX();
        int y = (int) coordinates.getY();

        if (map.containsKey(coordinates)) {
            throw new CollisionException("Cannot add object to preoccupied point");
        }

        if (x > size.getX_MAX() || x < size.getX_MIN() || y > size.getY_MAX() || y < size.getY_MIN()) {
            throw new PlateauOutOfBoundsException("Cannot add object to outside of plateau");
        }

        map.put(position.getCoordinate(), rover);
    }

    public void deleteFromPlateau(Point coordinate) {
        map.remove(coordinate);
    }

    public Map<Point, Rover> getMap() {
        return map;
    }

}
