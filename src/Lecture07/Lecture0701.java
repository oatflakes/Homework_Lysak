package Lecture07;
import Lecture07.Lecture07Classes.SimpleFraction;


import java.util.Scanner;

public class Lecture0701 {
    public static void main(String[] args) {
        SimpleFraction r1 = new SimpleFraction(5, 12);
        SimpleFraction r2 = new SimpleFraction(3);
        SimpleFraction r3 = new SimpleFraction(1, 3);
        SimpleFraction r4;

        r1.showFraction();
        System.out.println();
        r2.showFraction();
        System.out.println();
        r3.showFraction();
        System.out.println();

        r1.showFraction();
        System.out.print("+");
        r2.showFraction();
        System.out.print("=");
        r4 = SimpleFraction.addFraction(r1, r2);
        r4.showFraction();

        System.out.println();

        r2.showFraction();
        System.out.print("-");
        r3.showFraction();
        System.out.print("=");
        r4 = SimpleFraction.subFractions(r2, r3);
        r4.showFraction();

        System.out.println();

        r1.showFraction();
        System.out.print("*");
        r2.showFraction();
        System.out.print("*");
        r3.showFraction();
        System.out.print("=");
        r4 = SimpleFraction.prodFractions(r1, r2, r3);
        r4.showFraction();

        System.out.println();

        System.out.print("(");
        r1.showFraction();
        System.out.print("+");
        r2.showFraction();
        System.out.print(")*(");
        r1.showFraction();
        System.out.print("+");
        r3.showFraction();
        System.out.print(")=");
        r4 = SimpleFraction.prodFractions(SimpleFraction.addFraction(r1, r2), SimpleFraction.addFraction(r1, r3));
        r4.showFraction();
        System.out.println();
        System.out.println("Обратная дробь");
        r4.revFraction().showFraction();
    }
}

