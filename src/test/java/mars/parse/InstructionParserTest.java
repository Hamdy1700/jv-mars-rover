package mars.parse;

import mars.Instruction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static mars.parse.InstructionParser.parse;
import static org.junit.jupiter.api.Assertions.*;

class InstructionParserTest {

    @Test
    @DisplayName("When given standard inputs [LlRrMm], output correct Instruction enum")
    void testStandardInputs() {
        var input1 = "124234L";
        var input2 = "124234l";
        var input3 = "124234R";
        var input4 = "124234r";
        var input5 = "124234M";
        var input6 = "512521m";

        var expectedOutput1 = Instruction.L;
        var expectedOutput2 = Instruction.L;
        var expectedOutput3 = Instruction.R;
        var expectedOutput4 = Instruction.R;
        var expectedOutput5 = Instruction.M;
        var expectedOutput6 = Instruction.M;

        var result1 = parse(input1);
        var result2 = parse(input2);
        var result3 = parse(input3);
        var result4 = parse(input4);
        var result5 = parse(input5);
        var result6 = parse(input6);

        assertAll(
                () -> assertEquals(expectedOutput1, result1),
                () -> assertEquals(expectedOutput2, result2),
                () -> assertEquals(expectedOutput3, result3),
                () -> assertEquals(expectedOutput4, result4),
                () -> assertEquals(expectedOutput5, result5),
                () -> assertEquals(expectedOutput6, result6)
        );

    }

    @Test
    @DisplayName("When given exceptional inputs [blank, null, empty, not containing an instruction], output null")
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