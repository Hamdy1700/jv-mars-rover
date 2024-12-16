package mars;

import org.junit.jupiter.api.Test;

import java.awt.Point;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    void testAddToPlateauStandard() {
        Plateau plateau1 = new Plateau(new PlateauSize(new Point(100, 100)));

        var position1 = new Position(new Point(5, 5), CardinalDirection.N);
        var position2 = new Position(new Point(10, 15), CardinalDirection.E);
        var rover1 = new Rover(position1);
        var rover2 = new Rover(position2);

        plateau1.addToPlateau(rover1,position1 );
        plateau1.addToPlateau(rover2,position2 );

        Map<Point, Object> expectedOutput1 = Map.of(position1.getCoordinate(), rover1, position2.getCoordinate(), rover2);


        assertEquals(expectedOutput1, plateau1.getMap().toString());

    }

    @Test
    void testAddToPlateauExceptional() {
        Plateau plateau1 = new Plateau(new PlateauSize(new Point(100, 100)));
        var position1 = new Position(new Point(5, 5), CardinalDirection.N);
        plateau1.addToPlateau(new Rover(position1),position1 );

        assertAll(
                () -> assertThrows(CollisionException.class,
                        plateau1.addToPlateau(new Rover(position1),position1 ))
        );
    }

}