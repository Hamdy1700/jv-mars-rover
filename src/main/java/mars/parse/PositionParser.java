package mars.parse;

import mars.CardinalDirection;
import mars.Position;

import java.awt.Point;
import java.util.IllegalFormatException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PositionParser {

    public static Position parse(String input) throws IllegalArgumentException {
        if (input == null) {
            throw new IllegalArgumentException("Cannot parse null string");
        }

        Pattern positionFinder = Pattern.compile("^(\\d+)\\s(\\d+)\\s([NnEeSsWw])$");
        Matcher matchPosition = positionFinder.matcher(input);

        if (!matchPosition.matches()) {
            throw new IllegalArgumentException("Cannot parse string with invalid format. Correct format: <int> <int> <CardinalDirection>");
        }

        int x = Integer.parseInt(matchPosition.group(1));
        int y = Integer.parseInt(matchPosition.group(2));

        Point coordinates = new Point(x, y);
        CardinalDirection direction = CardinalDirection.valueOf(matchPosition.group(3).toUpperCase());

        return new Position(coordinates, direction);

    }

}
