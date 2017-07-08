package Lecture07;

import Lecture07.Lecture07Classes.Figure;
import Lecture07.Lecture07Classes.Point;

public class Lecture0703 {
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


