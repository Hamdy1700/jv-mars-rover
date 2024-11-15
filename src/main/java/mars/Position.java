package mars;

import java.awt.Point;

public class Position{

    private Point coordinate;
    private CardinalDirection facing;

    public Position(Point coordinate, CardinalDirection facing) {
        this.facing = facing;
        this.coordinate = coordinate;
    }

    public CardinalDirection getFacing() {
        return facing;
    }

    public Point getCoordinate() {
        return coordinate;
    }

    public void setFacing(CardinalDirection facing) {
        this.facing = facing;
    }

    public void translateCoordinates(int dx, int dy) {
        coordinate.translate(dx, dy);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
