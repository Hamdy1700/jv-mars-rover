package mars;

import java.util.List;

import static mars.CardinalDirection.*;

public class Rover {

    private Position position;

    public Rover(Position position) {
        this.position = position;
    }

    public void rotate(Instruction leftOrRight) throws IllegalArgumentException {
        if (!(leftOrRight == Instruction.R || leftOrRight == Instruction.L)) {
            throw new IllegalArgumentException("Instruction other than rotate passed to rotate()");
        }
        List<CardinalDirection> directions = List.of(N, E, S, W);
        int incrementValue = leftOrRight == Instruction.R ? 1 : -1;
        int indexOfNewDirection = directions.indexOf(position.getFacing()) + incrementValue;
        indexOfNewDirection = indexOfNewDirection < 0 ? directions.size() - 1 : indexOfNewDirection % directions.size();
        CardinalDirection newDirection = directions.get(indexOfNewDirection);
        position.setFacing(newDirection);
    }

    public void moveForward() {
        switch (position.getFacing()) {
            case N -> position.translateCoordinates(0, 1);
            case E -> position.translateCoordinates(1, 0);
            case S -> position.translateCoordinates(0, -1);
            case W -> position.translateCoordinates(-1, 0);
        }
    }

    public void moveBackwards() {
        switch (position.getFacing()) {
            case N -> position.translateCoordinates(0, -1);
            case E -> position.translateCoordinates(-1, 0);
            case S -> position.translateCoordinates(0, 1);
            case W -> position.translateCoordinates(1, 0);
        }
    }

    public Position getPosition() {
        return position;
    }
}
