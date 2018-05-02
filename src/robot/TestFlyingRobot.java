package robot;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * A class that implements test cases aimed at identifying bugs in the
 * implementations of classes Robot and FlyingRobot.
 *
 * @author Preet Patel
 *
 */

public class TestFlyingRobot {
    // Fixture object that is used by the tests.
    private MockPainter _painter;

    @Before
    public void setUp() {
        _painter = new MockPainter();
    }

    @Test
    public void testSimpleMove() {
        FlyingRobot robot = new FlyingRobot(100, 20, 12, 15);
        robot.paint(_painter);
        robot.move(500, 500);
        robot.paint(_painter);
        assertEquals("(oval 100,20,25,35)(oval 112,35,25,35)",
                _painter.toString());
    }

    /**
     * Test to perform a bounce movement off the right-most boundary and to
     * ensure that the Robot's position after the movement is correct.
     */
    @Test
    public void testRobotMoveWithBounceOffRight() {
        FlyingRobot robot = new FlyingRobot(100, 20, 12, 15);
        robot.paint(_painter);
        robot.move(135, 10000);
        robot.paint(_painter);
        robot.move(135, 10000);
        robot.paint(_painter);
        assertEquals("(oval 100,20,25,35)(oval 110,35,25,35)"
                + "(oval 98,50,25,35)", _painter.toString());
    }

    /**
     * Test to perform a bounce movement off the left-most boundary and to
     * ensure that the Robot's position after the movement is correct.
     */
    @Test
    public void testRobotMoveWithBounceOffLeft() {
        FlyingRobot robot = new FlyingRobot(10, 20, -12, 15);
        robot.paint(_painter);
        robot.move(10000, 10000);
        robot.paint(_painter);
        robot.move(10000, 10000);
        robot.paint(_painter);
        assertEquals("(oval 10,20,25,35)(oval 0,35,25,35)"
                + "(oval 12,50,25,35)", _painter.toString());
    }

    /**
     * Test to perform a bounce movement off the bottom right corner and to
     * ensure that the Robot's position after the movement is correct.
     */
    @Test
    public void testRobotMoveWithBounceOffBottomAndRight() {
        FlyingRobot robot = new FlyingRobot(10, 90, -12, 15);
        robot.paint(_painter);
        robot.move(125, 135);
        robot.paint(_painter);
        robot.move(125, 135);
        robot.paint(_painter);
        assertEquals("(oval 10,90,25,35)(oval 0,100,25,35)"
                + "(oval 12,85,25,35)", _painter.toString());
    }
}
