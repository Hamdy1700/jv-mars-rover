package mars;

import java.awt.Point;
import java.util.List;

public abstract class MissionControl {

    private static Plateau plateau;

    public static void findPlateau(PlateauSize size) {
        if (plateau == null) {
            plateau = new Plateau(size);
        }
    }

    public static void landNewRover(Position position) throws CollisionException, PlateauOutOfBoundsException{
        plateau.addToPlateau(new Rover(position), position);
    }

    public static void moveRover(Rover rover, List<Instruction> instructions) {
        instructions.forEach(i -> {
            if (i == Instruction.M) {
                Point originalCoordinates = rover.getPosition().getCoordinate();
                rover.moveForward();
                try {
                    plateau.addToPlateau(rover, rover.getPosition());
                    plateau.deleteFromPlateau(originalCoordinates);
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                    rover.moveBackwards();
                }
            } else {
                rover.rotate(i);
            }
        });
    }

}
