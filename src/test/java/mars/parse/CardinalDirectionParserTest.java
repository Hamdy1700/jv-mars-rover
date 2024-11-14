package mars.parse;

import mars.CardinalDirection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static mars.parse.CardinalDirectionParser.parse;
import static org.junit.jupiter.api.Assertions.*;

class CardinalDirectionParserTest {

    @Test
    @DisplayName("When given standard inputs [NnEeSsWw], output correct CardinalDirection enum")
    void testStandardInputs() {
        var input1 = "124234N";
        var input2 = "124234n";
        var input3 = "124234E";
        var input4 = "124234e";
        var input5 = "124234S";
        var input6 = "512521s";
        var input7 = "512521W";
        var input8 = "512521w";

        var expectedOutput1 = CardinalDirection.N;
        var expectedOutput2 = CardinalDirection.N;
        var expectedOutput3 = CardinalDirection.E;
        var expectedOutput4 = CardinalDirection.E;
        var expectedOutput5 = CardinalDirection.S;
        var expectedOutput6 = CardinalDirection.S;
        var expectedOutput7 = CardinalDirection.W;
        var expectedOutput8 = CardinalDirection.W;

        var result1 = parse(input1);
        var result2 = parse(input2);
        var result3 = parse(input3);
        var result4 = parse(input4);
        var result5 = parse(input5);
        var result6 = parse(input6);
        var result7 = parse(input7);
        var result8 = parse(input8);

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
    @DisplayName("When given exceptional inputs [blank, null, empty, not containing a valid direction], output null")
    void testExceptionalInput() {
        var input1 = " ";
        var input2 = "";
        var input3 = "124234";
        var input4 = "BHG";

        var result1 = parse(input1);
        var result2 = parse(input2);
        var result3 = parse(input3);
        var result4 = parse(input4);

        assertAll(
                () -> assertNull(result1),
                () -> assertNull(result2),
                () -> assertNull(result3),
                () -> assertNull(result4),
                () -> assertNull(null)
        );
    }
}