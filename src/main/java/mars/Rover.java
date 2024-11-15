package mars;

import java.util.List;

import static mars.CardinalDirection.*;

public class Rover {

    private final String name;
    private Position position;

    public Rover(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void rotate(Instruction leftOrRight) throws IllegalArgumentException {
        if (!(leftOrRight == Instruction.R || leftOrRight == Instruction.L)) {
            throw new IllegalArgumentException("Cannot rotate by moving forward! (Move instruction passed to rotate)");
        }
        List<CardinalDirection> directions = List.of(N, E, S, W);
        int incrementValue = leftOrRight == Instruction.R ? 1 : -1;
        int indexOfNewDirection = directions.indexOf(position.getFacing()) + incrementValue;
        indexOfNewDirection = indexOfNewDirection < 0 ? directions.size() - 1 : indexOfNewDirection % directions.size();
        CardinalDirection newDirection = directions.get(indexOfNewDirection);
        position.setFacing(newDirection);
    }

    public Position getPosition() {
        return position;
    }
}