package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Gabi on 01-Jul-16.
 */
public class Point {
    int xPos, yPos;
    public Point (int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (other instanceof Point) {
            Point anotherPoint = (Point) other;
            if (xPos == anotherPoint.xPos && yPos == anotherPoint.yPos) {
                return true;
            }
        }
        return false;

    }

}
