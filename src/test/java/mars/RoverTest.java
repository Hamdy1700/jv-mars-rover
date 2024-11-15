package mars;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.Point;

import static mars.parse.PositionParser.parse;
import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    Rover max = new Rover("Max", new Position(new Point(0, 5), CardinalDirection.N));

    @Test
    void testRotateStandard() {
        var input1 = Instruction.R;
        var input2 = Instruction.L;

        var expectedOutput1 = CardinalDirection.E;
        var expectedOutput2 = CardinalDirection.S;
        var expectedOutput3 = CardinalDirection.W;
        var expectedOutput4 = CardinalDirection.N;
        var expectedOutput5 = CardinalDirection.W;
        var expectedOutput6 = CardinalDirection.S;
        var expectedOutput7 = CardinalDirection.E;
        var expectedOutput8 = CardinalDirection.N;

        max.rotate(input1);
        var result1 = max.getPosition().getFacing();
        max.rotate(input1);
        var result2 = max.getPosition().getFacing();
        max.rotate(input1);
        var result3 = max.getPosition().getFacing();
        max.rotate(input1);
        var result4 = max.getPosition().getFacing();
        max.rotate(input2);
        var result5 = max.getPosition().getFacing();
        max.rotate(input2);
        var result6 = max.getPosition().getFacing();
        max.rotate(input2);
        var result7 = max.getPosition().getFacing();
        max.rotate(input2);
        var result8 = max.getPosition().getFacing();

        assertAll(
                () -> assertEquals(expectedOutput1, result1),
                () -> assertEquals(expectedOutput2, result2),
                () -> assertEquals(expectedOutput3, result3),
                () -> assertEquals(expectedOutput4, result4),
                () -> assertEquals(expectedOutput5, result5),
                () -> assertEquals(expectedOutput6, result6),
                () -> assertEquals(expectedOutput7, result7),
                () -> assertEquals(expectedOutput8, result8)
        );
    }

    @Test
    void testRotateExceptional() {

        var input1 = Instruction.M;

        assertThrows(IllegalArgumentException.class,
                () -> max.rotate(input1)
        );

    }

}