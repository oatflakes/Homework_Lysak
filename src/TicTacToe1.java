
//Написать игру крестики-нолики. В игре должны быть 2 режима : с компьютером, и с человеком.
//Также, должен быть счетчик поражений и побед, отдельно для игры с компьютером, отдельно для игры с человеком.
//вторая версия, используются объекты player1 и player2. Исправлен MyInput

import java.util.Random;
import java.util.Scanner;

public class TicTacToe1 {

    public static void main(String[] args) {
        int maxRounds = 2;                                                  //количество партий в одной игре

        PlayField playField = new PlayField();
        Scanner scanner = new Scanner(System.in);
        MyInput myInput = new MyInput();
        Random random = new Random();
        DisplayMessage displayMessage = new DisplayMessage();
        displayMessage.pStars();
        System.out.println("Крестики-Нолики");
        System.out.println("Игра до  " + maxRounds + " побед.");
        displayMessage.pStars();

        String[][] array = {
                {"(1)", "(2)", "(3)"},
                {"(4)", "(5)", "(6)"},
                {"(7)", "(8)", "(9)"}
        };

        playField.printField(array);
        playField.clearIt(array);

        Player player1 = new Player();
        Player player2 = new Player();

        int option = 0;
        int mode = 0;                                                       //mode: 1- один игрок, 2 - два игрока
        String userName = "";
        String playAgain = "yes";

        while (playAgain.equals("yes") || playAgain.equals("да") || playAgain.equals("1")) {
            do {
                option = myInput.getInt("1 - Игра с компьютером, 2 - Игра вдвоем, 3 - Помощь, 4 - Выход, 5 - Apple vs Google", scanner, 1, 5);
                switch (option) {
                    case 1:
                        System.out.println("ИГРА ПРОТИВ КОМПЬЮТЕРА");
                        mode = 1;
                        //if (userName.equals("")) {                      //Запомнить userName либо каждую новую игру
                        //System.out.println("Как вас зовут?");                      //заново спрашивать имя игрока
                        userName = "Человек";//userName = scanner.next();
                        //}
                        break;
                    case 2:
                        System.out.println("ИГРА ВДВОЕМ");
                        mode = 2;
                        break;
                    case 3:
                        System.out.println("Справка");
                        System.out.println("Чтобы сделать ход, введите номер свободного поля, от 1 до 9");
                        break;
                    case 4:
                        System.out.println("Quit");
                        playAgain = "";                                           //выход из программы???
                        break;
                    case 5:
                        mode = 5;
                        break;
                    default:
                        System.out.println("Недопустимый выбор! Выберите 1 - 4.");
                        break;
                }
            } while (option != 1 && option != 2 && option != 4 && option != 5);

            if (option != 4) {                                                         //выход из программы???
                //начало игры
                int firstMove = random.nextInt(2) + 1;              //определяем, кто ходит первым В ИГРЕ

                System.out.println(firstMove + " " + mode);

                player1.resetPlayer();
                player2.resetPlayer();

                if (mode == 1) {
                    namePlayers(userName, "Компьютер", firstMove, mode, player1, player2);
                } else if (mode == 2) {
                    namePlayers("Игрок 1", "Игрок 2", firstMove, mode, player1, player2);
                } else {
                    namePlayers("Apple", "Google", firstMove, mode, player1, player2);
                }

                String symbol;
                String playerName = player1.name;
                int playerMove = 0;
                int setsPlayed = 0;
                int bestResult = 0;
                String winner = "";
                boolean setFinished = false;
                boolean playerMoveCorrect = false;
                boolean playerIsHuman;
                while (bestResult < maxRounds) {                                        //начало партии
                    displayMessage.pStars();
                    System.out.println("Партия №:" + (setsPlayed + 1));
                    System.out.println("Первым ходит " + playerName);
                    playField.printField(array);
                    int moves = 0;

                    while (!setFinished) {
                        if (moves % 2 == 0) {
                            symbol = "X";
                        } else {
                            symbol = "O";
                        }
                        if (setsPlayed == 0 && moves == 0) {
                            if (player1.movesFirst) {
                                playerName = player1.name;
                                playerIsHuman = player1.isHuman;
                            } else {
                                playerName = player2.name;
                                playerIsHuman = player2.isHuman;
                            }
                        } else {
                            if (player1.movesNow) {
                                playerName = player1.name;
                                playerIsHuman = player1.isHuman;
                            } else {
                                playerName = player2.name;
                                playerIsHuman = player2.isHuman;
                            }
                        }

                        if (player1.movesNow) {
                            player1.movesNow = false;
                            player2.movesNow = true;
                        } else {
                            player2.movesNow = false;
                            player1.movesNow = true;
                        }

                        while (!playerMoveCorrect) {                                   //начало хода
                            if (!playerIsHuman) {
                                playerMove = playField.computerMove(array, symbol);   //ход компьютера
                            } else {
                                playerMove = myInput.getInt(userName + ", ваш ход", scanner, 1, 9) - 1;      //ход игрока
                            }

                            int k = playerMove / 3;                                           //перевод номера поля
                            int l = playerMove % 3;                                           //в индексы массива
                            if (!array[k][l].equals("-")) {
                                if (playerIsHuman) System.out.println("Поле занято");
                            } else {
                                array[k][l] = symbol;
                                if (!playerIsHuman) {
                                    System.out.println(playerName + ": " + (playerMove + 1));
                                }
                                moves++;
                                playerMoveCorrect = true;
                            }
                        }                                                               //конец хода

                        playField.printField(array);
                        setFinished = playField.threeInARow(array);                         //проверка завершения партии

                        playerMoveCorrect = false;

                        if (setFinished) {
                            setsPlayed++;
                            displayMessage.pStars();
                            System.out.println("Победил " + playerName);
                            if (playerName.equals(player1.name)) {
                                player1.victories++;
                                player2.defeats++;
                            } else {
                                player2.victories++;
                                player1.defeats++;
                            }
                        } else if (moves == 9) {
                            System.out.println("********* НИЧЬЯ *********");
                            setsPlayed++;
                            setFinished = true;
                        }
                        if (player1.movesFirst) {
                            player1.movesFirst = false;
                            player2.movesFirst = true;
                            playerName = player2.name;
                        } else {
                            player1.movesFirst = true;
                            player2.movesFirst = false;
                            playerName = player1.name;
                        }
                    }                                                                       //конец партии

                    setFinished = false;
                    playField.clearIt(array);                                               //статистика
                    displayMessage.pStars();
                    System.out.println(player1.name + ": Побед - " + player1.victories + ", поражений - " + player1.defeats);
                    System.out.println(player2.name + ": Побед - " + player2.victories + ", поражений - " + player2.defeats);
                    System.out.println("Сыграно партий: " + setsPlayed);
                    displayMessage.pStars();

                    if (player1.victories > player2.victories) {
                        bestResult = player1.victories;
                        winner = player1.name;
                    } else {
                        bestResult = player2.victories;
                        winner = player2.name;
                    }
                }
                displayMessage.pStars();
                System.out.println("Отлично! " + winner + " выиграл игру!!!");
                displayMessage.pStars();
                playAgain = myInput.getString("Хотите сыграть еще? (Да/Нет)", scanner);
                playAgain = playAgain.toLowerCase();
            }
        }                                                                           //конец игры
    }

    private static void namePlayers(String name1, String name2, int step, int ai, Player player1, Player player2) {
        if (step == 1) {
            player1.name = name1;
            player2.name = name2;
        } else if (step == 2) {
            player1.name = name2;
            player2.name = name1;
        }
        player1.movesNow = true;
        player1.movesFirst = true;
        if (ai == 2) {
            player1.isHuman = true;
            player2.isHuman = true;
        }
        if (ai == 1) {
            if (step == 1) {
                player1.isHuman = true;
            } else {
                player2.isHuman = true;
            }
        }
    }
}

class Player {
    String name;
    boolean isHuman;
    boolean movesNow;
    boolean movesFirst;
    int victories = 0;
    int defeats = 0;

    void resetPlayer() {
        isHuman = false;
        movesNow = false;
        movesFirst = false;
        defeats = 0;
        victories = 0;
    }
}

class PlayField {
    void printField(String[][] array) {
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

    boolean threeInARow(String[][] array) {                          //проверяем текущий массив на победу любого игрока
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

    int computerMove(String[][] array, String mplayerSymbol) {       //метод для вычисления ходов компьютера
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
            sd = random.nextInt(9);
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

class DisplayMessage {
    void pStars() {
        System.out.println("**************************");
    }
}

class MyInput {
    String getString(String inputMessage, Scanner scanner) {
        String str = "";
        System.out.println(inputMessage);
        return scanner.next();
    }

    int getInt(String inputMessage, Scanner scanner, int min, int max) {
        boolean inputIsInt;
        boolean inputIsCorrect = false;
        int intOut = 0;
        while (!inputIsCorrect) {
            do {
                System.out.println(inputMessage);
                try {
                    intOut = Integer.parseInt(scanner.next());
                    inputIsInt = true;
                } catch (Exception e) {
                    System.out.println("Введите число");
                    inputIsInt = false;
                }
            } while (!inputIsInt);
            if (inputIsInt) {
                if (min == 0 && max == 0) {
                    inputIsCorrect = true;
                } else {
                    if (intOut > max + 1 || intOut < min) {
                        System.out.println("Введите число от " + min + " до " + max);
                        inputIsCorrect = false;
                    } else {
                        inputIsCorrect = true;
                    }
                }
            }
        }
        return (intOut);
    }

    double getDouble(String inputMessage, Scanner scanner) {
        boolean inputIsDbl = false;
        double dblOut = 0;
        do {
            System.out.println(inputMessage);
            try {
                dblOut = Double.parseDouble(scanner.next());
                inputIsDbl = true;
            } catch (Exception e) {
                System.out.println("Введите число");
                inputIsDbl = false;
            }
        } while (!inputIsDbl);

        return (dblOut);
    }
}