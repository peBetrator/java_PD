package task22;

public class Point {
    private double _x_, _y_;
    public double y;
    public double x;

    public Point() {
        _x_ = 0;
        _y_ = 0;
    }

    public Point(double x, double y) {
        setX(x);
        setY(y);
    }

    public double getX() {
        return _x_;
    }

    public double getY() {
        return _y_;
    }

    public void setX(double x) {
        assert x > 0;
        _x_ = x;
    }

    public void setY(double y) {
        assert y > 0;
        _y_ = y;
    }

    public double dist(Point p) {
        double dx = getX() - p.getX();
        double dy = getY() - p.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    public String toString() {
        return ((int) getX() + " " + (int) getY());
    }

    public Point createPoint() {
        return new Point();
    }

    public Point createPoint(double x, double y) {
        return new Point(x, y);
    }
}