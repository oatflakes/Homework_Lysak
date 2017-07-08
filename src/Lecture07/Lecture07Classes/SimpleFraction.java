package Lecture07.Lecture07Classes;

import java.util.Scanner;

public class SimpleFraction {
    int num;
    int denom;

    public SimpleFraction() {

    }

    public SimpleFraction(int num) {
        this.num = num;
        this.denom = 1;
    }

    public SimpleFraction(int num, int denom) {
        this.num = num;
        this.denom = denom;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getDenom() {
        return denom;
    }

    public void setDenom(int denom) {
        this.denom = denom;
    }

    public SimpleFraction revFraction() {
        SimpleFraction simpleFraction;
        return simpleFraction = new SimpleFraction(denom, num);
    }

    public void showFraction() {
        if (denom == 1 || num == 0) {
            System.out.print(num);
        } else {
            System.out.print(num + "/" + denom);
        }
    }

    public void reduceFraction() {
        if (denom == num) {
            num = 1;
            denom = 1;
        } else if (num != 1 && denom != 1) {
            int k = 0;
            k = Math.min(num, denom);
            int divisor = 1;
            for (int i = 2; i <= k; i++) {
                if (num % i == 0 && denom % i == 0) {
                    divisor = i;
                }
            }
            num = num / divisor;
            denom = denom / divisor;
        }
    }

    public static SimpleFraction addFraction(SimpleFraction... fractions) {
        int mnum = fractions[0].getNum();
        int mdenom = fractions[0].getDenom();


        for (int i = 1; i < fractions.length; i++) {
            mnum = mnum * fractions[i].getDenom() + fractions[i].getNum() * mdenom;
            mdenom = mdenom * fractions[i].getDenom();
            SimpleFraction tmpFraction = new SimpleFraction(mnum, mdenom);
            tmpFraction.reduceFraction();
            mnum = tmpFraction.getNum();
            mdenom = tmpFraction.getDenom();
        }

        SimpleFraction sumFractions = new SimpleFraction(mnum, mdenom);
        sumFractions.reduceFraction();
        return sumFractions;
    }

    public static SimpleFraction subFractions(SimpleFraction frac1, SimpleFraction frac2) {
        int mnum = 0;
        int mdenom = 0;

        mnum = frac1.getNum() * frac2.getDenom() - frac2.getNum() * frac1.getDenom();
        mdenom = frac1.getDenom() * frac2.getDenom();

        SimpleFraction substractedFractions = new SimpleFraction(mnum, mdenom);
        substractedFractions.reduceFraction();
        return substractedFractions;
    }

    public static SimpleFraction prodFractions(SimpleFraction... fractions) {
        int mnum = 1;
        int mdenum = 1;
        for (int i = 0; i < fractions.length; i++) {
            mnum = mnum * fractions[i].getNum();
            mdenum = mdenum * fractions[i].getDenom();
        }
        SimpleFraction prodFraction = new SimpleFraction(mnum, mdenum);
        prodFraction.reduceFraction();
        return prodFraction;
    }

    public static SimpleFraction inputFraction() {
        Scanner scanner = new Scanner(System.in);
        int mnum = 0;
        int mdenom = 0;
        String strFraction = scanner.next();
        if (strFraction.contains("/")) {
            int endInd = 0;
            endInd = strFraction.indexOf('/', 0) - 1;
            mnum = Integer.getInteger(strFraction.substring(0, endInd).trim());
            mdenom = Integer.getInteger(strFraction.substring(endInd + 2).trim());
        } else {
            mnum = Integer.getInteger(strFraction);
            mdenom = 1;
        }
        SimpleFraction simpleFraction = new SimpleFraction(mnum, mdenom);
        return simpleFraction;

    }

    public static SimpleFraction inputFraction(String strFraction) {
        int mnum = 0;
        int mdenom = 0;
        if (strFraction.contains("/")) {
            int endInd = 0;
            endInd = strFraction.indexOf('/', 0);
            mnum = Integer.parseInt(strFraction.substring(0, endInd).trim());
            mdenom = Integer.parseInt(strFraction.substring(endInd + 1).trim());
        } else {
            mnum = Integer.parseInt(strFraction.trim());
            mdenom = 1;
        }
        SimpleFraction simpleFraction = new SimpleFraction(mnum, mdenom);
        return simpleFraction;

    }
}