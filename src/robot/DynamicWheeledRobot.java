package robot;

import java.awt.*;

public class DynamicWheeledRobot extends WheeledRobot{
    private Color _RobotColor;
    private boolean hasBouncedOffVertical = false;

    public DynamicWheeledRobot() {
        super();
        _RobotColor = Color.black;
    }


    public DynamicWheeledRobot(int x, int y, int deltaX, int deltaY) {
        super(x,y,deltaX,deltaY);
        _RobotColor = Color.black;
    }

    public DynamicWheeledRobot(int x, int y, int deltaX, int deltaY, Color robotColor) {
        super(x,y,deltaX,deltaY);
        _RobotColor = robotColor;
    }


    public DynamicWheeledRobot(int x, int y, int deltaX, int deltaY, int width, int height) {
        super(x,y,deltaX,deltaY,width,height);
        _RobotColor = Color.black;

    }

    public DynamicWheeledRobot(int x, int y, int deltaX, int deltaY, int width, int height, Color robotColor) {
        super(x,y,deltaX,deltaY,width,height);
        _RobotColor = robotColor;

    }

    public void drawFilledRobot(Painter painter) {

        painter.setColor(_RobotColor);
        painter.fillRect(_x,_y,_width,_height);
        hasBouncedOffVertical = true;
    }

    /**
     * Paints this WheeledRobot object using the supplied Painter object.
     */
    public void paint(Painter painter) {

        if (this.didBounceOffVertical() && this.didBounceOffVertical()) {
           drawFilledRobot(painter);
        } else if (this.didBounceOffVertical()) {
            drawFilledRobot(painter);
        } else if (this.didBounceOffHorizontal()) {
            painter.drawRect(_x, _y, _width, _height);
            hasBouncedOffVertical = false;
        } else {
            if (!hasBouncedOffVertical) {
                painter.drawRect(_x, _y, _width, _height);
            } else {
                drawFilledRobot(painter);
            }
        }
    }
}
