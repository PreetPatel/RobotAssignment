package robot;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTrackedRobot {

    // Fixture object that is used by the tests.
    private MockPainter _painter;

    @Before
    public void setUp() {
        _painter = new MockPainter();
    }

    @Test
    public void testSimpleMoveWithSmallDimensions() {
        TrackedRobot robot = new TrackedRobot(100, 20, 12, 15);
        robot.paint(_painter);
        robot.move(500, 500);
        robot.paint(_painter);
        assertEquals("(line 100,37,112,20)(line 112,20,125,37)(line 125,37,112,55)(line 112,55,100,37)(line 112,52,124,35)(line 124,35,137,52)(line 137,52,124,70)(line 124,70,112,52)",
                _painter.toString());
    }

    @Test
    public void testSimpleMoveWithRegularDimensions() {
        TrackedRobot robot = new TrackedRobot(100, 20, 12, 15, 50,50);
        robot.paint(_painter);
        robot.move(500, 500);
        robot.paint(_painter);
        assertEquals("(line 100,45,120,20)(line 120,20,130,20)(line 130,20,150,45)(line 150,45,130,70)(line 130,70,120,70)(line 120,70,100,45)(line 112,60,132,35)(line 132,35,142,35)(line 142,35,162,60)(line 162,60,142,85)(line 142,85,132,85)(line 132,85,112,60)",
                _painter.toString());
    }

    /**
     * Test to perform a bounce movement off the right-most boundary and to
     * ensure that the Robot's position after the movement is correct.
     */
    @Test
    public void testRobotMoveWithBounceOffRight() {
        TrackedRobot robot = new TrackedRobot(100, 20, 12, 15);
        robot.paint(_painter);
        robot.move(135, 10000);
        robot.paint(_painter);
        robot.move(135, 10000);
        robot.paint(_painter);
        assertEquals("(line 100,37,112,20)(line 112,20,125,37)(line 125,37,112,55)(line 112,55,100,37)(line 110,52,122,35)(line 122,35,135,52)(line 135,52,122,70)(line 122,70,110,52)(line 98,67,110,50)(line 110,50,123,67)(line 123,67,110,85)(line 110,85,98,67)", _painter.toString());
    }

    /**
     * Test to perform a bounce movement off the left-most boundary and to
     * ensure that the Robot's position after the movement is correct.
     */
    @Test
    public void testRobotMoveWithBounceOffLeft() {
        TrackedRobot robot = new TrackedRobot(10, 20, -12, 15);
        robot.paint(_painter);
        robot.move(10000, 10000);
        robot.paint(_painter);
        robot.move(10000, 10000);
        robot.paint(_painter);
        assertEquals("(line 10,37,22,20)(line 22,20,35,37)(line 35,37,22,55)(line 22,55,10,37)(line 0,52,12,35)(line 12,35,25,52)(line 25,52,12,70)(line 12,70,0,52)(line 12,67,24,50)(line 24,50,37,67)(line 37,67,24,85)(line 24,85,12,67)", _painter.toString());
    }

    /**
     * Test to perform a bounce movement off the bottom right corner and to
     * ensure that the Robot's position after the movement is correct.
     */
    @Test
    public void testRobotMoveWithBounceOffBottomAndRight() {
        TrackedRobot robot = new TrackedRobot(10, 90, -12, 15);
        robot.paint(_painter);
        robot.move(125, 135);
        robot.paint(_painter);
        robot.move(125, 135);
        robot.paint(_painter);
        assertEquals("(line 10,107,22,90)(line 22,90,35,107)(line 35,107,22,125)(line 22,125,10,107)(line 0,117,12,100)(line 12,100,25,117)(line 25,117,12,135)(line 12,135,0,117)(line 12,102,24,85)(line 24,85,37,102)(line 37,102,24,120)(line 24,120,12,102)", _painter.toString());
    }
}
