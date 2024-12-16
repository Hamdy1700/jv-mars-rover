package mars;

import mars.parse.CoordinateParser;
import mars.parse.PositionParser;

import java.awt.Point;
import java.util.Scanner;

public abstract class UI {

    public static Scanner scanner;

    public static void promptForPlateauSize() {
        while (true) {
            System.out.println("Enter a coordinate for the top right corner in the format <int> <int>:");
            String input = scanner.nextLine();
            try {
                Point coordinates = CoordinateParser.parse(input);
                MissionControl.findPlateau(new PlateauSize(coordinates));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void promptForPosition() {
        while (true) {
            System.out.println("Enter a position for the rover to land in the format: <int> <int> <CardinalDirection>");
            String input = scanner.nextLine();
            try {
                Position position = PositionParser.parse(input);
                MissionControl.landNewRover(position);
                break;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void promptForInstructions() {
        while (true) {
            System.out.println("Enter instructions to move the rover (L)eft or (R)ight to rotate and (M)ove" +
                    "to move forward");

        }
    }

}
