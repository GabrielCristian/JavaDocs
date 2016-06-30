package ro.teamnet.zerotohero.oop.graphicshape;


public class Circle extends Shape {

    private int xPos, yPos, radius;
    public Circle() {
        xPos = 0;
        yPos = 0;
        radius = 1;
    }
    public Circle(int xPos) {
        this.xPos = xPos;
        yPos = 0;
        radius = 1;
    }
    public Circle(int xPos, int yPos) {
       this.xPos = xPos;
        this.yPos = yPos;
    }
    public Circle(int xPos, int yPos, int radius) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
    }

    public double area () {
        double area = 0;
        area = Math.PI * radius * radius;
        return area;

    }
    public void fillColour () {
        System.out.println(super.color);
    }
    public void fillColour (int color) {
        setColor(color);
        System.out.println("The circle color is now " + color);
    }
    public void fillColour (float color) {
        super.setSaturation(color);
        System.out.println();
    }


    @Override
    public String toString() {
        String s ="center=(" + xPos + "," + yPos + ") and radius=" + radius;
        return s;
    }
}
