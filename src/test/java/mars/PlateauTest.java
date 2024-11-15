package mars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    void testIsSingleton() {

        Plateau plateau = Plateau.getInstance();
        Plateau newPlateau = Plateau.getInstance();

        assertEquals(plateau, newPlateau);

    }

}