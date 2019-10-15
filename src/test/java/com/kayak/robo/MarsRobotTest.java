package com.kayak.robo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MarsRobotTest {

    private String command;
    private Point endPoint;
    private Direction endDirection;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    public MarsRobotTest(final String command, final Point endPoint, final Direction endDirection, final Class<? extends Throwable> exception) {
        this.command = command;
        this.endPoint = endPoint;
        this.endDirection = endDirection;
        if (exception == null) {
            expectedException = ExpectedException.none();
        } else {
            expectedException.expect(exception);
        }
    }

    @Test
    public void testRobotsLocationShouldMatch() {
        final MarsRobot robot = new MarsRobot();

        robot.runCommand(command);

        assertLocation(endPoint, robot);
        assertDirection(endDirection, robot);
    }

    private void assertLocation(final Point point, final MarsRobot robot) {
        assertEquals(point.getX(), robot.getLocation().getX());
        assertEquals(point.getY(), robot.getLocation().getY());
    }

    private void assertDirection(final Direction direction, final MarsRobot robot) {
        assertEquals(direction, robot.getDirection());
    }

    @Parameters(name = "{index}: expected {1} {2} for command {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"LLLLLLLLLLLL", new Point(0, 0), Direction.NORTH, null},
                {"RRRRRRRRRRRR", new Point(0, 0), Direction.NORTH, null},
                {"LR", new Point(0, 0), Direction.NORTH, null},
                {"LLRR", new Point(0, 0), Direction.NORTH, null},
                {"FF", new Point(0, 2), Direction.NORTH, null},
                {"FFRFFRFFRFF", new Point(0, 0), Direction.WEST, null},
                {"FFFLLFFF", new Point(0, 0), Direction.SOUTH, null},
                {"FFRFFLFL", new Point(2, 3), Direction.WEST, null},
                {"LFFLF", new Point(-2, -1), Direction.SOUTH, null},

                {"LFFFRFFFRRFFF", new Point(-3, 0), Direction.SOUTH, null}, // Actual question

                {"LFFFL", new Point(-3, 0), Direction.SOUTH, null},
                {"", new Point(0, 0), Direction.NORTH, null},
                {null, new Point(0, 0), Direction.NORTH, IllegalArgumentException.class},
                {"INVALID_COMMAND", new Point(0, 0), Direction.NORTH, UnsupportedOperationException.class}
        });
    }
}
