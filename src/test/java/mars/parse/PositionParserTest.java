package mars.parse;

import mars.CardinalDirection;
import mars.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static mars.parse.PositionParser.parse;
import static org.junit.jupiter.api.Assertions.*;

class PositionParserTest {

    @Test
    @DisplayName("When given standard inputs [NnEeSsWw], output correct CardinalDirection enum")
    void testStandardInputs() {
        var input1 = "12 23 N";
        var input2 = "0 5 e";
        var input3 = "9 4 s";
        var input4 = "100 2000 W";

        var expectedOutput1 = new Position(new Point(), CardinalDirection.N);
        var expectedOutput2 = new Position(new Point(), CardinalDirection.E);
        var expectedOutput3 = new Position(new Point(), CardinalDirection.S);
        var expectedOutput4 = new Position(new Point(), CardinalDirection.W);

        var result1 = parse(input1);
        var result2 = parse(input2);
        var result3 = parse(input3);
        var result4 = parse(input4);

        assertAll(
                () -> assertEquals(expectedOutput1, result1),
                () -> assertEquals(expectedOutput2, result2),
                () -> assertEquals(expectedOutput3, result3),
                () -> assertEquals(expectedOutput4, result4)
        );

    }

    @Test
    @DisplayName("When given exceptional inputs [blank, null, empty, not containing a valid direction], output null")
    void testExceptionalInput() {
        var input1 = " ";
        var input2 = "";
        var input3 = "124234";
        var input4 = "BHG";
        var input5 = "12 N N";
        var input6 = "12 N 45";

        assertAll(
                () -> assertThrows(IllegalArgumentException.class ,
                        () -> parse(input1)
                ),

                () -> assertThrows(IllegalArgumentException.class ,
                        () -> parse(input2)
                ),

                () -> assertThrows(IllegalArgumentException.class ,
                        () -> parse(input2)
                ),

                () -> assertThrows(IllegalArgumentException.class ,
                        () -> parse(input3)
                ),

                () -> assertThrows(IllegalArgumentException.class ,
                        () -> parse(input4)
                ),

                () -> assertThrows(IllegalArgumentException.class ,
                        () -> parse(input5)
                ),

                () -> assertThrows(IllegalArgumentException.class ,
                        () -> parse(input6)
                ),

                () -> assertThrows(IllegalArgumentException.class,
                        () -> parse(null)
                )
        );
    }

}