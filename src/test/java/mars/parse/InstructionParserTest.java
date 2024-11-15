package mars.parse;

import mars.Instruction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static mars.parse.InstructionParser.parse;
import static org.junit.jupiter.api.Assertions.*;

class InstructionParserTest {

    @Test
    @DisplayName("When given standard inputs [LlRrMm], output list of correct Instruction enum")
    void testStandardInputs() {
        var input1 = "124234L";
        var input2 = "124234l";
        var input3 = "124234R";
        var input4 = "124234r";
        var input5 = "124234M";
        var input6 = "512521m";
        var input7 = "LMMRrml";
        var input8 = "LfMdMRbbrml";

        var expectedOutput1 = List.of(Instruction.L);
        var expectedOutput2 = List.of(Instruction.L);
        var expectedOutput3 = List.of(Instruction.R);
        var expectedOutput4 = List.of(Instruction.R);
        var expectedOutput5 = List.of(Instruction.M);
        var expectedOutput6 = List.of(Instruction.M);
        var expectedOutput7 = List.of(Instruction.L, Instruction.M, Instruction.M, Instruction.R, Instruction.R, Instruction.M, Instruction.L);
        var expectedOutput8 = List.of(Instruction.L, Instruction.M, Instruction.M, Instruction.R, Instruction.R, Instruction.M, Instruction.L);

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
    @DisplayName("When given exceptional inputs [blank, null, empty, not containing a valid instruction], output null")
    void testExceptionalInput() {
        var input1 = " ";
        var input2 = "";
        var input3 = "124234";
        var input4 = "BHG";

        assertAll(
                () -> assertThrows(IllegalArgumentException.class ,
                        () -> CardinalDirectionParser.parse(input1)
                ),

                () -> assertThrows(IllegalArgumentException.class ,
                        () -> CardinalDirectionParser.parse(input2)
                ),

                () -> assertThrows(IllegalArgumentException.class ,
                        () -> CardinalDirectionParser.parse(input2)
                ),

                () -> assertThrows(IllegalArgumentException.class ,
                        () -> CardinalDirectionParser.parse(input3)
                ),

                () -> assertThrows(IllegalArgumentException.class ,
                        () -> CardinalDirectionParser.parse(input4)
                ),

                () -> assertThrows(IllegalArgumentException.class,
                        () -> CardinalDirectionParser.parse(null)
                )
        );


    }

}