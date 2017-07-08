package Lecture07.Lecture07Classes;

public class Figure {
    int points = 0;
    String name = "";
    Point a;
    Point b;
    Point c;
    Point d;
    Point e;

    public Figure() {
    }

    public Figure(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        points = 3;
        name = "Треугольник";
    }

    public Figure(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        points = 4;
        name = "Четырехугольник";
    }

    public Figure(Point a, Point b, Point c, Point d, Point e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        points = 5;
        name = "Пятиугольник";
    }

    public double lengthSide(Point a, Point b) {

        double length = 0;

        length = (a.getX() - b.getX()) * (a.getX() - b.getX()) + (a.getY() - b.getY()) * (a.getY() - b.getY());
        length = Math.sqrt(length);
        return length;
    }

    public void perimeter() {
        double perim = 0;
        switch (points) {
            case 3:
                perim= lengthSide(a, b) + lengthSide(b, c) + lengthSide(c, a);
                break;
            case 4:
                perim = lengthSide(a, b) + lengthSide(b, c) + lengthSide(c, d) + lengthSide(d, a);
                break;
            case 5:
                perim = lengthSide(a, b) + lengthSide(b, c) + lengthSide(c, d) + lengthSide(d, e)
                        + lengthSide(e, a);
                break;
            default:
                break;
        }
        System.out.println(name);
        System.out.println("Длина периметра " + perim);
        System.out.println();
    }
}