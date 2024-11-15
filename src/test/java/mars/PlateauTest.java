package mars;

import org.junit.jupiter.api.Test;

import java.awt.Point;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    void testIsSingleton() {

        Plateau plateau = Plateau.getInstance(new PlateauSize(new Point(0, 5)));
        Plateau newPlateau = Plateau.getInstance(new PlateauSize(new Point(0, 5)));

        assertEquals(plateau, newPlateau);

    }

}