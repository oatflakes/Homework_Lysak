//Написать игру крестики-нолики. В игре должны быть 2 режима : с компьютером, и с человеком.
//Также, должен быть счетчик поражений и побед, отдельно для игры с компьютером, отдельно для игры с человеком.

import java.util.Random;
import java.util.Scanner;

public class Lecture05 {

    public static void main(String[] args) {

        MyArray myArray = new MyArray();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        MyMessage myMessage = new MyMessage();
        myMessage.pStars();
        System.out.println("Крестики-Нолики");
        myMessage.pStars();
        int maxRounds = 3;                                                  //количество партий в одной игре
        System.out.println("Игра до  " + maxRounds + " побед.");

        String[][] array = {
                {"(1)", "(2)", "(3)"},
                {"(4)", "(5)", "(6)"},
                {"(7)", "(8)", "(9)"}
        };

        myArray.printIt(array);
        myArray.clearIt(array);

        int option = 0;
        int mode = 0;                                                       //mode: 1- один игрок, 2 - два игрока
        String userName = "";
        String player1Name = "";
        String player2Name = "";
        String playerName = "";
        String player1CounterName = "";
        String player2CounterName = "";
        String playAgain = "yes";

        while (playAgain.equals("yes") || playAgain.equals("да") || playAgain.equals("1")) {
            do {
                System.out.println("1 - Игра с компьютером, 2 - Игра вдвоем, 3 - Помощь, 4 - Выход");
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("ИГРА ПРОТИВ КОМПЬЮТЕРА");
                        mode = 1;
                        //if (userName.equals("")) {                      //Запомнить userName либо каждую новую игру
                        System.out.println("Как вас зовут?");                      //заново спрашивать имя игрока
                        userName = scanner.next();
                        //}
                        break;
                    case 2:
                        System.out.println("ИГРА ВДВОЕМ");
                        mode = 2;
                        break;
                    case 3:
                        myMessage.pHelp();
                        break;
                    case 4:
                        System.out.println("Quit");
                        playAgain = "";                                           //выход из программы???
                        break;
                    default:
                        System.out.println("Недопустимый выбор! Выберите 1 - 4.");
                        break;
                }
            } while (option != 1 && option != 2 && option != 4);

            if (option != 4) {                                                         //выход из программы???

                int firstMove = random.nextInt(2) + 1;                          //определяем, кто ходит первым

                if (mode == 1) {
                    if (firstMove == 1) {
                        player1Name = userName;
                        player2Name = "Компьютер";
                    } else {
                        player1Name = "Компьютер";
                        player2Name = userName;
                    }
                } else {
                    if (firstMove == 1) {
                        player1Name = "Игрок 1";
                        player2Name = "Игрок 2";
                    } else {
                        player1Name = "Игрок 2";
                        player2Name = "Игрок 1";
                    }
                }

                player1CounterName = player1Name;
                player2CounterName = player2Name;

                String player1Symbol = "X";
                String player2Symbol = "O";
                String playerSymbol = "";
                String playerWinner = "";
                int player1Wins = 0;
                int player2Wins = 0;
                int player1Defeats = 0;
                int player2Defeats = 0;
                int playerMove = 0;
                int setsPlayed = 0;
                int bestResult = 0;
                boolean setFinished = false;
                boolean playerMoveCorrect = false;

                while (bestResult < maxRounds) {                      //начало игры
                    myMessage.pStars();
                    System.out.println("Партия №:" + (setsPlayed + 1));
                    myArray.printIt(array);
                    int moves = 0;
                    while (!setFinished) {                          //начало партии
                        if ((moves + 1) % 2 == 0) {
                            playerName = player2Name;
                            playerSymbol = player2Symbol;
                        } else {
                            playerName = player1Name;
                            playerSymbol = player1Symbol;
                        }
                        while (!playerMoveCorrect) {
                            if (playerName.equals("Компьютер")) {
                                playerMove = myArray.checkIt(array, playerSymbol);   //ход компьютера
                            } else {
                                boolean inputCorrect = false;
                                do {
                                    System.out.println(playerName + ", ваш ход");
                                    playerMove = scanner.nextInt() - 1;                  //ход игрока
                                    inputCorrect = false;
                                    if (playerMove + 1 > 9 || playerMove + 1 < 1) {
                                        System.out.println("Некорректный ввод");
                                        inputCorrect = true;
                                    }
                                } while (inputCorrect);
                            }

                            int k = 0;
                            int l = 0;
                            k = playerMove / 3;                                           //перевод номера поля
                            l = playerMove % 3;                                           //в индексы массива

                            if (!array[k][l].equals("-")) {
                                if (!playerName.equals("Компьютер")) System.out.println("Поле занято");
                            } else {
                                array[k][l] = playerSymbol;
                                if (playerName.equals("Компьютер")) {
                                    System.out.println("Компьютер: " + (playerMove + 1));
                                }
                                moves++;
                                playerMoveCorrect = true;
                            }
                        }
                        myArray.printIt(array);

                        setFinished = myArray.victory(array);                                 //проверка завершения партии

                        if (setFinished) {
                            playerWinner = playerName;
                        }

                        playerMoveCorrect = false;

                        if (setFinished) {
                            setsPlayed++;
                            myMessage.pStars();
                            System.out.println("Победил " + playerWinner);
                            if (playerWinner.equals(player1CounterName)) {
                                player1Wins++;
                                player2Defeats++;
                            } else if (playerWinner.equals(player2CounterName)) {
                                player2Wins++;
                                player1Defeats++;
                            }
                        } else if (moves == 9) {
                            System.out.println("********* НИЧЬЯ *********");
                            setsPlayed++;
                            setFinished = true;
                        }

                    }
//конец партии
                    setFinished = false;
                    playerWinner = "";
                    String tempStr = player1Name;
                    player1Name = player2Name;
                    player2Name = tempStr;

                    myArray.clearIt(array);                                             //статистика
                    myMessage.pStars();
                    System.out.println(player1CounterName + ": Побед - " + player1Wins + ", поражений - " + player1Defeats);
                    System.out.println(player2CounterName + ": Побед - " + player2Wins + ", поражений - " + player2Defeats);
                    System.out.println("Сыграно партий: " + setsPlayed);
                    myMessage.pStars();

                    if (player1Wins > player2Wins) {
                        bestResult = player1Wins;
                    } else {
                        bestResult = player2Wins;
                    }
                }

                myMessage.pStars();
                if (bestResult == player1Wins) {                                    //определяем, чей результат
                    System.out.println("Отлично! " + player1CounterName + " выиграл игру!!!");
                } else {
                    System.out.println("Отлично! " + player2CounterName + " выиграл игру!!!");
                }
                myMessage.pStars();
                System.out.println("Хотите сыграть еще? (Да/Нет)");
                playAgain = scanner.next();
                playAgain = playAgain.toLowerCase();
            }
        }//конец игры
    }
}

class MyArray {
    void printIt(String[][] array) {
        for (String[] str : array) {                        //печать массива
            for (String element : str) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    void clearIt(String[][] array) {                        //заполнение массива прочерками
        for (int j = 0; j < array.length; j++) {
            for (int k = 0; k < array[j].length; k++) {
                array[j][k] = "-";
            }
        }
    }

    boolean victory(String[][] array) {                          //проверяем текущий массив на победу любого игрока
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

    int checkIt(String[][] array, String mplayerSymbol) {       //метод для вычисления ходов компьютера
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
            sd = random.nextInt(8)+1;
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

class MyMessage {
    void pHelp() {
        System.out.println("Справка :)");
        System.out.println("Чтобы сделать ход, введите номер свободного поля, от 1 до 9");
    }

    void pStars() {
        System.out.println("**************************");
    }
}