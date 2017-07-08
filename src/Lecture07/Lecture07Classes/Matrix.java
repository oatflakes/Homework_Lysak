package Lecture07.Lecture07Classes;
public class Matrix {
    int x;
    int y;
    SimpleFraction[][] elements = new SimpleFraction[y][x];

    public Matrix() {
    }

    public Matrix(int y, int x, SimpleFraction[][] elements) {
        this.x = x;
        this.y = y;
        this.elements = elements;
    }

    public Matrix(int y, int x, int i) {
        this.x = 1;
        this.y = 0;
        SimpleFraction arr[][] = new SimpleFraction[1][1];
        arr[0][0] = SimpleFraction.inputFraction("0");
        this.elements = arr;

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


    public static boolean mxSameDim(Matrix... matrices) {
        int mx = matrices[0].getX();
        int my = matrices[0].getY();
        boolean matricesEqual = false;
        for (int i = 1; i < matrices.length; i++) {
            if (matrices[i].getY() == my && matrices[i].getX() == mx) {
                matricesEqual = true;
            } else {
                matricesEqual = false;
                break;
            }
        }
        return matricesEqual;
    }

    public static boolean mxAligned(Matrix mx1, Matrix mx2) {
        boolean mxTranspose = false;
        if (mx1.getX() == mx2.getY()) {
            mxTranspose = true;
        }
        return mxTranspose;
    }


    public static Matrix mxAdd(Matrix... matrices) {

        boolean mMatricesEqual = false;
        SimpleFraction arr[][] = new SimpleFraction[matrices[0].y][matrices[0].x];
        Matrix tmpMx = new Matrix(matrices[0].y, matrices[0].x, arr);
        mMatricesEqual = Matrix.mxSameDim(matrices);
        if (!mMatricesEqual) {
            System.out.println("Матрицы разной размерности!\n" +
                    "Сложение невозможно\n" +
                    "Возвращена нулевая матрица");
            Matrix tmpMx1 = new Matrix(1, 1, 0);
            tmpMx = tmpMx1;
        } else {
            for (int i = 0; i < matrices[0].y; i++) {
                for (int j = 0; j < matrices[0].x; j++) {
                    for (int k = 0; k < matrices.length; k++) {
                        if (k == 0) {
                            tmpMx.elements[i][j] = SimpleFraction.inputFraction("0");
                        }
                        tmpMx.elements[i][j] =
                                SimpleFraction.addFraction(tmpMx.elements[i][j], matrices[k].elements[i][j]);
                    }
                }
            }
        }

        return tmpMx;

    }

    public static Matrix mxProduct(Matrix mx1, Matrix mx2) {

        Matrix mxResult;
        boolean mxAligned = false;
        mxAligned = Matrix.mxAligned(mx1, mx2);
        if (!mxAligned) {
            System.out.println("Матрицы несогласованы\n" +
                    "Возвращена нулевая матрица");
            mxResult = new Matrix(1, 1, 0);
        } else {
            SimpleFraction[][] tmpMx = new SimpleFraction[mx1.getY()][mx2.getX()];
            for (int i = 0; i < mx1.getY(); i++) {
                for (int j = 0; j < mx2.getX(); j++) {
                    tmpMx[i][j] = SimpleFraction.inputFraction("0");
                }
            }
            SimpleFraction fr1;
            for (int i = 0; i < mx1.getY(); i++) {
                for (int j = 0; j < mx2.getX(); j++) {
                    for (int k = 0; k < mx1.getX(); k++) {
                        fr1 = SimpleFraction.prodFractions(mx1.elements[i][k], mx2.elements[k][j]);
                        tmpMx[i][j] = SimpleFraction.addFraction(tmpMx[i][j], fr1);
                    }
                }
            }
            mxResult = new Matrix(mx1.getY(), mx2.getX(), tmpMx);
        }
        return mxResult;
    }
}