package MyClasses;

import java.util.Random;

public class MyArray {
    public void printIt(String[][] array) {
        for (String[] str : array) {                        //печать массива
            for (String element : str) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public void clearIt(String[][] array) {                        //заполнение массива прочерками
        for (int j = 0; j < array.length; j++) {
            for (int k = 0; k < array[j].length; k++) {
                array[j][k] = "-";
            }
        }
    }

    public boolean victory(String[][] array) {                          //проверяем текущий массив на победу любого игрока
        boolean setFinished1 = false;
        for (int j = 0; j < array.length; j++) {
            for (int k = 0; k < array[j].length; k++) {
                if (!array[j][0].equals("-") && !array[j][1].equals("-") && !array[j][2].equals("-")
                        && array[j][0].equals(array[j][1]) && array[j][1].equals(array[j][2])) {
                    setFinished1 = true;
                    break;
                }
                if (!array[0][k].equals("-") && !array[1][k].equals("-") && !array[2][k].equals("-")
                        && array[0][k].equals(array[1][k]) && array[1][k].equals(array[2][k])) {
                    setFinished1 = true;
                    break;
                }
            }
        }
        if (!array[0][0].equals("-") && !array[1][1].equals("-") && !array[2][2].equals("-")
                && array[0][0].equals(array[1][1]) && array[1][1].equals(array[2][2])) {
            setFinished1 = true;
        }
        if (!array[2][0].equals("-") && !array[1][1].equals("-") && !array[0][2].equals("-")
                && array[2][0].equals(array[1][1]) && array[1][1].equals(array[0][2])) {
            setFinished1 = true;
        }
        return setFinished1;
    }

    public int checkIt(String[][] array, String mplayerSymbol) {       //метод для вычисления ходов компьютера
        Random random = new Random();
        if (array[1][1].equals("-")) {
            return 4;                                           //приоритет 5-й ячейке
        }
        for (int i = 0; i < 2; i++) {
            if (i == 1) {
                if (mplayerSymbol.equals("X")) {
                    mplayerSymbol = "O";
                } else {
                    mplayerSymbol = "X";
                }
            }
            int mPlayerMove = 0;
            String param1 = "-" + mplayerSymbol + mplayerSymbol;
            String param2 = mplayerSymbol + "-" + mplayerSymbol;
            String param3 = mplayerSymbol + mplayerSymbol + "-";

            for (int k = 0; k < 2; k++) {
                for (int j = 0; j < 3; j++) {
                    int shift = 3;
                    int shiftD = 3;
                    String oxo = "";
                    String oxoDiagonal = "";

                    for (int l = 0; l < 3; l++) {
                        if (k == 0) {
                            oxo = oxo.concat(array[j][l]);
                            oxoDiagonal = oxoDiagonal.concat(array[l][l]);
                        } else {
                            oxo = oxo.concat(array[l][j]);
                            oxoDiagonal = oxoDiagonal.concat(array[l][2 - l]);
                        }
                    }

                    if (oxo.equals(param1)) {                       //полученные комбинации проверяются на соответствие
                        shift = 0;
                    } else if (oxo.equals(param2)) {
                        shift = 1;
                    } else if (oxo.equals(param3)) {
                        shift = 2;
                    }

                    if (oxoDiagonal.equals(param1)) {
                        shiftD = 0;
                    } else if (oxoDiagonal.equals(param2)) {
                        shiftD = 1;
                    } else if (oxoDiagonal.equals(param3)) {
                        shiftD = 2;
                    }

                    if (shift < 3) {                                //если есть совпадение комбинаций
                        if (k == 0) {                               //то рассчитывается ход компьютера
                            mPlayerMove = j * 3 + shift;
                        } else {
                            mPlayerMove = shift * 3 + j;
                        }
                        return mPlayerMove;
                    } else if (shiftD < 3) {
                        if (k == 0) {
                            mPlayerMove = shiftD * 3 + shiftD;
                        } else {
                            mPlayerMove = shiftD * 3 + 2 - shiftD;
                        }
                        return mPlayerMove;
                    }
                }
            }
        }
        int s = -1;
        while (s < 0) {
            int sd = 0;
            sd = random.nextInt(8) + 1;
            int x = 0;
            int y = 0;
            x = sd / 3;
            y = sd % 3;
            if (array[x][y].equals("-")) {                              //если комбинаций нет, то
                s = sd;                                                 //перебор случайных значений
            }
        }
        return s;
    }


}