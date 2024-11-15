package mars.parse;

import mars.Instruction;

import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;

public class InstructionParser {
    public static List<Instruction> parse(String input) throws IllegalArgumentException {
        if (input == null) {
            throw new IllegalArgumentException("Cannot parse null string");
        }

        if (!input.matches(".*[LlRrMm].*")) {
            throw new IllegalArgumentException("Cannot parse string without an instruction");
        }
        //remove anything that isn't the instruction
        String stringInstruction = input.replaceAll("[^LlRrMm]", "");

        List<Instruction> instructions = new ArrayList<>();
        for (int i = 0; i < stringInstruction.length(); i++){
            instructions.add(Instruction.valueOf(String.valueOf(stringInstruction.charAt(i)).toUpperCase()));
        }
        return instructions;

    }
}
