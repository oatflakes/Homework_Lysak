/**
 * Created by DL on 06-07-17.
 */
public class Task0702 {
    public static void main(String[] args) {

        String arr1[][] =
                {{"1", "2", "2"},
                        {"0", "3", "1"},
                        {"1", "0", "0"}};

        String arr2[][] =
                {{"0", "0", "1"},
                        {"-1/4", "1/2", "1/4"},
                        {"3/4", "-1/2", "-7/10"}};


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

        Matrix mx1 = new Matrix(arrFrac1.length,arrFrac1[0].length, arrFrac1);
        Matrix mx2 = new Matrix(arrFrac2.length,arrFrac2[0].length, arrFrac2);
        mx1.matrixPrint();
        System.out.println();
        mx2.matrixPrint();
    }
}


class Matrix {
    int x;
    int y;
    SimpleFraction[][] elements = new SimpleFraction[x][y];

    public Matrix() {
    }

    public Matrix(int x, int y, SimpleFraction[][] elements) {
        this.x = x;
        this.y = y;
        this.elements = elements;
    }

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

    public SimpleFraction[][] getElements() {
        return elements;
    }

    public void setElements(SimpleFraction[][] elements) {
        this.elements = elements;
    }

    public void matrixPrint() {
        for (SimpleFraction row[] : elements) {
            for (SimpleFraction element : row) {
                element.showFraction();
                System.out.print(" ");
            }
            System.out.println();
        }
    }


}