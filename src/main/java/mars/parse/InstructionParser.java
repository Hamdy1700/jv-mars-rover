package mars.parse;

import mars.Instruction;

import java.util.ArrayList;
import java.util.List;

public class InstructionParser {
    public static List<Instruction> parse(String input) {
        //remove anything that isn't the instruction
        String stringInstruction = input.replaceAll("[^LlRrMm]", "");
        try {
            List<Instruction> instructions = new ArrayList<>();
            for (int i = 0; i < stringInstruction.length(); i++){
                instructions.add(Instruction.valueOf(String.valueOf(stringInstruction.charAt(i)).toUpperCase()));
            }
            return instructions;
        } catch (IllegalArgumentException e) {
            System.out.println("Input doesn't contain a valid instruction");
        }
        return null;
    }
}
