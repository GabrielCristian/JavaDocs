package ro.teamnet.zerotohero.oop.RunApp;

import ro.teamnet.zerotohero.oop.graphicshape.*;
import ro.teamnet.zerotohero.canvas.Canvas;

public class RunApp {

    public void method1 () throws MyException{
        method2();
    }
    public void method2() throws MyException{
        method3();
    }
    public void method3() throws MyException {
        throw new MyException("alt exemplu");
    }
    public static void main(String[] args) throws MyException{
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

        Object p1 = new Point(10,20);
        Object p2 = new Point(50,100);
        Object p3 = new Point(10,20);
        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));

        //throw new MyException("exceptie");
        RunApp runApp = new RunApp();
        try {
            runApp.method1();
        } catch(MyException e) {
            System.out.println("First exception -> " + e.getMessage());
            runApp.method1();
        }
    }
}
