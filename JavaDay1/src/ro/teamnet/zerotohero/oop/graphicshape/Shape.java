package ro.teamnet.zerotohero.oop.graphicshape;


public class Shape extends AbstractShape implements ShapeBehaviour  {
    protected int color=5;

    protected float saturation;
    public void setColor(int color) {
        this.color = color;
    }
    public void setSaturation(float saturation) {
        this.saturation = saturation;
    }

    @Override
    public double area() {
        return 0;
    }


}
