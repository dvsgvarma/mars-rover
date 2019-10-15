package com.kayak.robo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MarsRover {

    private Point location;
    private Direction direction;

    public MarsRover() {
        location = new Point(0, 0);
        direction = Direction.NORTH;
    }

    private void turnLeft() {
        Direction result = null;
        switch (direction) {
            case EAST:
                result = Direction.NORTH;
                break;
            case NORTH:
                result = Direction.WEST;
                break;
            case WEST:
                result = Direction.SOUTH;
                break;
            case SOUTH:
                result = Direction.EAST;
                break;
            default:
                break;
        }
        direction = result;
    }

    private void turnRight() {
        Direction result = null;
        switch (direction) {
            case EAST:
                result = Direction.SOUTH;
                break;
            case NORTH:
                result = Direction.EAST;
                break;
            case WEST:
                result = Direction.NORTH;
                break;
            case SOUTH:
                result = Direction.WEST;
                break;
            default:
                break;
        }
        direction = result;
    }

    private void goForward() {
        switch (direction) {
            case EAST:
                location.setX(location.getX() + 1);
                break;
            case NORTH:
                location.setY(location.getY() + 1);
                break;
            case WEST:
                location.setX(location.getX() - 1);
                break;
            case SOUTH:
                location.setY(location.getY() - 1);
                break;
            default:
                break;
        }
    }

    /**
     * The method runs instructive commands for rover EX: LFFFRFFFRRFFF,
     * where "L" is a "turn 90 degrees left", "R" is a "turn 90 degrees right",
     * and "F" is "go forward one space.
     */
    public void runCommand(final String command) {
        if (command == null) {
            throw new IllegalArgumentException("Command must not be null.");
        }
        for (int i = 0; i < command.length(); i++) {
            switch (command.charAt(i)) {
                case 'F':
                    goForward();
                    break;
                case 'L':
                    turnLeft();
                    break;
                case 'R':
                    turnRight();
                    break;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }
}
