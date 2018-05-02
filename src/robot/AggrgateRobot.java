package robot;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class AggrgateRobot extends Robot{

    Robot _first;
    Robot _second;

    public AggrgateRobot() {
        super();
        _first = new FlyingRobot();
        _second = new WheeledRobot();
    }

    public AggrgateRobot(int x, int y) {
        super(x, y);
        _first = new FlyingRobot();
        _second = new WheeledRobot();
    }

    public AggrgateRobot(int x, int y, Robot first, Robot second) {
        super(x, y);
        _first = first;
        _second = second;
    }

    public AggrgateRobot(int x, int y, int deltaX, int deltaY) {
        super(x, y, deltaX, deltaY);
        _first = new FlyingRobot();
        _second = new WheeledRobot();
    }

    public AggrgateRobot(int x, int y, int deltaX, int deltaY, Robot first, Robot second) {
        super(x, y, deltaX, deltaY);
        _first = first;
        _second = second;
    }

    public AggrgateRobot(int x, int y, int deltaX, int deltaY, int width, int height) {
        super(x, y, deltaX, deltaY, width, height);
    }

    /*public AggrgateRobot(int x, int y, int deltaX, int deltaY, int width, int height) {
        super(x, y, deltaX, deltaY, width, height);
    }*/

    @Override
    public void paint(Painter painter) {
        try{
            File image2 = new File("robot.png");
            Image image = ImageIO.read(image2);
            image = image.getScaledInstance(_width, _height, Image.SCALE_DEFAULT);
            painter.drawImage(image, _x,_y,null);

        }
        catch (IOException e){
            System.out.println("Not found");
            e.printStackTrace();
        }
    }
}
