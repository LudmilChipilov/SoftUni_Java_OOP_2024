package shapes;

public class Circle extends Shape
{
    private Double radius;
    public Circle (Double radius)
    {
        this.setRadius(radius);
        this.calculatePerimeter();
        this.calculateArea();
    }
    public final Double getRadius() {
        return radius;
    }
    @Override
    protected void calculatePerimeter()
    {
         setPerimeter(this.radius*2*Math.PI);
    }

    @Override
    protected void calculateArea()
    {
        setArea(Math.pow(this.radius, 2)*Math.PI);
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

}
