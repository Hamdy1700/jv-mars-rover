package mars.parse;

import mars.CardinalDirection;
import mars.Instruction;

public class CardinalDirectionParser {

    public static CardinalDirection parse(String input) {
        String direction = input.replaceAll("[^NnEeSsWw]", "");
        try {
            return CardinalDirection.valueOf(direction.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Input doesn't contain a valid direction");
        }
        return null;
    }

}
