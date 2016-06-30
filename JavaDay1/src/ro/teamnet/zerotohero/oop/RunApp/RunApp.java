package ro.teamnet.zerotohero.oop.RunApp;

import ro.teamnet.zerotohero.oop.graphicshape.*;
import ro.teamnet.zerotohero.canvas.Canvas;

public class RunApp {
    public static void main(String[] args) {
        Circle circle = new Circle();
        //System.out.println(circle.area());
        System.out.println(circle);
        circle.fillColour();
        circle.fillColour(2);
        Circles circles = new Circles();
        circles.getAreaDef();
        Canvas canvas = new Canvas();
        Shape shape = new Circle(10);
        System.out.println("shape " + shape);
        ShapeBehaviour square= new Square(10);
        System.out.println("square " + square);
    }
}
