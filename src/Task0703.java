/**
 * Created by DL on 03-07-17.
 */
public class Task0703 {
    public static void main(String[] args) {
        Point a = new Point(10, 10, "A");
        Point b = new Point(20, 10, "B");
        Point c = new Point(20, 20, "C");
        Point d = new Point(10, 20, "D");
        Point e = new Point(0, 0, "E");

        Figure figure3 = new Figure(a, b, c);
        Figure figure4 = new Figure(a, b, c, d);
        Figure figure5 = new Figure(a, b, c, d,e);

        figure3.perimeter();
        figure4.perimeter();
        figure5.perimeter();
    }
}

class Point {
    int x;
    int y;
    String name;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }
}

class Figure {
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

    double lengthSide(Point a, Point b) {

        double length = 0;

        length = (a.getX() - b.getX()) * (a.getX() - b.getX()) + (a.getY() - b.getY()) * (a.getY() - b.getY());
        length = Math.sqrt(length);
        return length;
    }

    void perimeter() {
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