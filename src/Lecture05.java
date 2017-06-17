//Написать игру крестики-нолики. В игре должны быть 2 режима : с компьютером, и с человеком.
//Также, должен быть счетчик поражений и побед, отдельно для игры с компьютером, отдельно для игры с человеком.

import com.sun.org.apache.xpath.internal.SourceTree;

//import javax.sound.midi.Soundbank;
//import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lecture05 {

    public static void main(String[] args) {

        System.out.println("КРЕСТИКИ-НОЛИКИ");
        int maxRounds = 5;                                                  //количество партий в одной игре
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[][] demoArray = {
                {"(1)", "(2)", "(3)"},
                {"(4)", "(5)", "(6)"},
                {"(7)", "(8)", "(9)"}
        };

        for (int i = 0; i < demoArray.length; i++) {                        //печать двухмерного массива
            for (int j = 0; j < demoArray[i].length; j++) {
                System.out.print(demoArray[i][j] + " ");
            }
            System.out.println();
        }

        String[][] array = {
                {"-", "-", "-"},
                {"-", "-", "-"},
                {"-", "-", "-"}
        };


        int option = 0;
        int mode = 0;                                                       //mode: 1- один игрок, 2 - два игрока
        String userName = "";
        String player1Name = "";
        String player2Name = "";
        String player1CounterName = "";
        String player2CounterName = "";
        String playAgain = "Yes";
        while (playAgain.equals("Yes") || playAgain.equals("Да")) {
            do {
                printStartMessage();
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        printComputerMode();
                        mode = 1;
                        //if (userName.equals("")) {                      //Запомнить userName либо каждую новую
                        System.out.println("Как вас зовут?");           //заново спрашивать имя игрока
                        userName = scanner.next();
                        //}
                        break;
                    case 2:
                        printMultiPlayerMode();
                        mode = 2;
                        break;
                    case 3:
                        printHelp();
                        break;
                    default:
                        printErrorMessage();
                        break;
                }
            } while (option != 1 && option != 2);

            int firstMove = random.nextInt(2) + 1;                          //определяем, кто ходит первым


            if (mode == 1) {
                if (firstMove == 1) {
                    player1Name = userName; //"Игрок";
                    player2Name = "Компьютер";
                    //System.out.println("Игрок, ваш ход");
                } else {
                    player1Name = "Компьютер";
                    player2Name = userName; //"Игрок";
                    //System.out.println("Компьютер ходит первым");
                }
            } else {
                if (firstMove == 1) {
                    player1Name = "Игрок 1";
                    player2Name = "Игрок 2";
                    //System.out.println("Игрок 1 ходит первым");
                } else {
                    player1Name = "Игрок 2";
                    player2Name = "Игрок 1";
                    //System.out.println("Игрок 2 ходит первым");
                }
            }

            player1CounterName = player1Name;
            player2CounterName = player2Name;

            String player1Symbol = "X";
            String player2Symbol = "O";
            String playerWinner = "";
            int player1Wins = 0;
            int player1Defeats = 0;
            int player2Wins = 0;
            int player2Defeats = 0;
            int gamesPlayed = 0;
            int bestResult = 0;
            boolean setFinished = false;
            boolean player1MoveCorrect = false;
            boolean player2MoveCorrect = false;
            int player1Move = 0;
            int player2Move = 0;

            while (bestResult < maxRounds) {                      //начало игры
                System.out.println("**************************");
                System.out.println("Партия №:" + (gamesPlayed + 1));

                //печать двухмерного массива
                for (int i = 0; i < array.length; i++) {
                    for (int j = 0; j < array[i].length; j++) {
                        System.out.print(array[i][j] + " ");
                    }
                    System.out.println();
                }

                int sets = 0;
                while (!setFinished) {                          //начало партии

                    while (!player1MoveCorrect) {
                        if (player1Name.equals("Компьютер")) {
                            player1Move = random.nextInt(9);
                        } else {
                            boolean inputCorrect=false;
                            do  {
                                System.out.println(player1Name + ", ваш ход");
                                player1Move = scanner.nextInt() - 1;
                                inputCorrect=false;
                                if(player1Move+1>9||player1Move+1<1){
                                    System.out.println("Некорректный ввод");
                                    inputCorrect=true;
                                }
                            } while (inputCorrect);
                        }

                        int k = 0;
                        int l = 0;

                        k = player1Move / 3;
                        l = player1Move % 3;


                        if (array[k][l].equals("X") || array[k][l].equals("O")) {
                            //System.out.println("Занято");
                        } else {
                            array[k][l] = player1Symbol;
                            if (player1Name.equals("Компьютер")) {
                                System.out.println("Компьютер: " + (player1Move + 1));
                            }
                            sets++;
                            player1MoveCorrect = true;
                        }
                    }
                    //печать двухмерного массива
                    for (int m = 0; m < array.length; m++) {
                        for (int n = 0; n < array[m].length; n++) {
                            System.out.print(array[m][n] + " ");
                        }
                        System.out.println();
                    }
                    for (int j = 0; j < array.length; j++) {
                        for (int k = 0; k < array[j].length; k++) {
                            if (array[j][0].equals("X") && array[j][1].equals("X") && array[j][2].equals("X")) {
                                setFinished = true;
                                break;
                            }
                            if (array[0][k].equals("X") && array[1][k].equals("X") && array[2][k].equals("X")) {
                                setFinished = true;
                                break;
                            }
                        }
                    }
                    if (array[0][0].equals("X") && array[1][1].equals("X") && array[2][2].equals("X")) {
                        setFinished = true;
                    }
                    if (array[2][0].equals("X") && array[1][1].equals("X") && array[0][2].equals("X")) {
                        setFinished = true;
                    }
                    //****************************
                    if (setFinished) {
                        playerWinner = player1Name;
                    }

                    if (!setFinished && sets < 9) {
                        while (!player2MoveCorrect) {
                            if (player2Name.equals("Компьютер")) {
                                player2Move = random.nextInt(9);
                            } else {
                                System.out.println(player2Name + ", ваш ход");
                                boolean inputCorrect=false;
                                do  {
                                    player2Move = scanner.nextInt() - 1;
                                    inputCorrect=false;
                                    if(player2Move+1>9||player2Move+1<1){
                                        System.out.println("Некорректный ввод");
                                        inputCorrect=true;
                                    }
                                } while (inputCorrect);
                            }

                            int k = 0;
                            int l = 0;

                            k = player2Move / 3;
                            l = player2Move % 3;


                            if (array[k][l].equals("X") || array[k][l].equals("O")) {
                                //System.out.println("Занято");
                            } else {
                                array[k][l] = player2Symbol;
                                if (player2Name.equals("Компьютер")) {
                                    System.out.println("Компьютер: " + (player2Move + 1));
                                }
                                sets++;
                                player2MoveCorrect = true;
                            }
                        }
                        //печать двухмерного массива
                        for (int m = 0; m < array.length; m++) {
                            for (int n = 0; n < array[m].length; n++) {
                                System.out.print(array[m][n] + " ");
                            }
                            System.out.println();
                        }
                    }
                    player1MoveCorrect = false;
                    player2MoveCorrect = false;


                    for (int j = 0; j < array.length; j++) {
                        for (int k = 0; k < array[j].length; k++) {

                            if (array[j][0].equals("O") && array[j][1].equals("O") && array[j][2].equals("O")) {
                                setFinished = true;
                                break;
                            }
                            if (array[0][k].equals("O") && array[1][k].equals("O") && array[2][k].equals("O")) {
                                setFinished = true;
                                break;
                            }

                        }
                    }
                    if (array[0][0].equals("O") && array[1][1].equals("O") && array[2][2].equals("O")) {
                        setFinished = true;
                    }
                    if (array[2][0].equals("O") && array[1][1].equals("O") && array[0][2].equals("O")) {
                        setFinished = true;
                    }

                    if (setFinished) {
                        printStars();                                    //определение результата партии
                        if (playerWinner.equals("")) {
                            playerWinner = player2Name;
                        }
                        System.out.println("Победил " + playerWinner);
                        if (playerWinner.equals(player1CounterName)) {
                            player1Wins++;
                            player2Defeats++;
                            gamesPlayed++;
                        } else if (playerWinner.equals(player2CounterName)) {
                            player2Wins++;
                            player1Defeats++;
                            gamesPlayed++;
                        }
                    } else if (sets == 9) {
                        System.out.println("Ничья");
                        gamesPlayed++;
                        setFinished = true;
                    }

                }
                setFinished = false;
                sets = 0;
                playerWinner = "";

                String tempStr = player1Name;

                player1Name = player2Name;
                player2Name = tempStr;


                for (int j = 0; j < array.length; j++) {
                    for (int k = 0; k < array[j].length; k++) {
                        array[j][k] = "-";
                    }

                }
                //конец партии
                printStars();
                System.out.println("Статистика");
                System.out.println(player1CounterName + ": Побед - " + player1Wins + ", поражений - " + player1Defeats);
                System.out.println(player2CounterName + ": Побед - " + player2Wins + ", поражений - " + player2Defeats);
                System.out.println("Сыграно партий: " + gamesPlayed);
                printStars();


                if (player1Wins > player2Wins) {
                    bestResult = player1Wins;
                } else {
                    bestResult = player2Wins;
                }

            }

            printStars();
            System.out.println("Поздравляем!");

            if (bestResult == player1Wins) {
                System.out.println(player1CounterName + " выиграл игру!!!");
            } else {
                System.out.println(player2CounterName + " выиграл игру!!!");
            }
            printStars();

            bestResult = 0;
            player1Wins = 0;
            player2Wins = 0;
            player1Defeats = 0;
            player2Defeats = 0;
            gamesPlayed = 0;

            System.out.println("Хотите сыграть еще?");
            playAgain = scanner.next();
        }//конец игры
    }

    private static void printHelp() {
        System.out.println("Чтобы сделать ход, введите номер свободного поля, от 1 до 9.");
        System.out.println("Побеждает тот, кто первым сумеет выиграть 5 партий.");  //должен быть параметр
    }

    private static void printStartMessage() {
        System.out.println("1 - Игра с компьютером, 2 - Игра вдвоем, 3 - Помощь");
    }

    private static void printErrorMessage() {
        System.out.println("Недопустимый выбор! Выберите 1, 2 или 3.");
    }

    private static void printComputerMode() {
        System.out.println("ИГРА ПРОТИВ КОМПЬЮТЕРА");
    }

    private static void printMultiPlayerMode() {
        System.out.println("ИГРА ВДВОЕМ");
    }

    private static void printStars() {
        System.out.println("**************************");
    }
}
