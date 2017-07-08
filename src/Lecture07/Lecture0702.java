package Lecture07;

import Lecture07.Lecture07Classes.Matrix;
import Lecture07.Lecture07Classes.SimpleFraction;

public class Lecture0702 {
    public static void main(String[] args) {

        String arr1[][] = {{"1", "2", "2"}, {"0", "3", "1"}, {"1", "0", "0"}};
        String arr2[][] = {{"0", "0", "1"}, {"-1/4", "1/2", "1/4"}, {"3/4", "-1/2", "-7/10"}};

        //String arr1[][] = {{"1", "1", "1"}, {"1", "1", "1"}, {"1", "1", "1"}};
        //String arr2[][] = {{"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};

        SimpleFraction arrFrac1[][] = new SimpleFraction[arr1.length][arr1[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                arrFrac1[i][j] = SimpleFraction.inputFraction(arr1[i][j]);
            }
        }
        SimpleFraction arrFrac2[][] = new SimpleFraction[arr2.length][arr2[0].length];
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                arrFrac2[i][j] = SimpleFraction.inputFraction(arr2[i][j]);
            }
        }

        Matrix mx1 = new Matrix(arrFrac1.length, arrFrac1[0].length, arrFrac1);
        Matrix mx2 = new Matrix(arrFrac2.length, arrFrac2[0].length, arrFrac2);
        mx1.matrixPrint();
        System.out.println();
        mx2.matrixPrint();

        System.out.println("Сложение двух матриц");
        Matrix mx3 = Matrix.mxAdd(mx1, mx2);
        mx3.matrixPrint();

        System.out.println("Умножение двух матриц");
        mx3 = Matrix.mxProduct(mx1, mx2);
        mx3.matrixPrint();

    }
}


