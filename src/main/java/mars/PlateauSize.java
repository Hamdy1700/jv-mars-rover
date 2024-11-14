import java.awt.*;

public class PlateauSize {
    private final Point TOP_RIGHT_COORDINATE;
    private final Point BOTTOM_LEFT_COORDINATE = new Point(0, 0);
    private final int Y_MAX = (int) TOP_RIGHT_COORDINATE.getY();;
    private final int X_MAX = (int) TOP_RIGHT_COORDINATE.getX();;
    private final int Y_MIN = (int) BOTTOM_LEFT_COORDINATE.getY();
    private final int X_MIN = (int) BOTTOM_LEFT_COORDINATE.getX();
}
