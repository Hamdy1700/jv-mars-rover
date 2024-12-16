package mars.parse;

import mars.CardinalDirection;
import mars.Position;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoordinateParser {

    public static Point parse(String input) throws IllegalArgumentException {
        if (input == null) {
            throw new IllegalArgumentException("Cannot parse null string");
        }

        Pattern positionFinder = Pattern.compile("^(\\d+)\\s(\\d+)$");
        Matcher matchPosition = positionFinder.matcher(input);

        if (!matchPosition.matches()) {
            throw new IllegalArgumentException("Cannot parse string with invalid format. Correct format: <int> <int>");
        }

        int x = Integer.parseInt(matchPosition.group(1));
        int y = Integer.parseInt(matchPosition.group(2));

        return new Point(x, y);

    }

}
