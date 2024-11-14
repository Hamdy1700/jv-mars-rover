package mars.parse;

import mars.Instruction;

public class InstructionParser {
    public static Instruction parse(String input) {
        //remove anything that isn't the instruction
        String instruction = input.replaceAll("[^LlRrMm]", "");
        return Instruction.valueOf(instruction.toUpperCase());
    }
}
