package mars.parse;

import mars.CardinalDirection;
import mars.Instruction;

import java.util.IllegalFormatException;

public class CardinalDirectionParser {

    public static CardinalDirection parse(String input) throws IllegalFormatException {
        if (input == null) {
            throw new IllegalArgumentException("Cannot parse null string");
        }

        if (!input.matches(".*[NnEeSsWw].*")) {
            throw new IllegalArgumentException("Cannot parse string without a direction");
        }

        String direction = input.replaceAll("[^NnEeSsWw]", "");

        return CardinalDirection.valueOf(direction.toUpperCase());
    }

}
