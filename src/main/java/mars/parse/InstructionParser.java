package mars.parse;

import mars.Instruction;

public class InstructionParser {
    public static Instruction parse(String input) {
        //remove anything that isn't the instruction
        String stringInstruction = input.replaceAll("[^LlRrMm]", "");
        try {
            return Instruction.valueOf(stringInstruction.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Input doesn't contain a valid instruction");
        }
        return null;
        //handle illegal ARG E
    }
}
