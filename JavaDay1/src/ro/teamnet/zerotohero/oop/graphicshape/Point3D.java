package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Gabi on 01-Jul-16.
 */
public class Point3D extends Point {
    int zPos;
    public Point3D(int xPos, int yPos, int zPos) {
        super(xPos, yPos);
        this.zPos = zPos;
    }
}
