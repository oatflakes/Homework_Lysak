package Lecture05;
import MyClasses.MyArray;
import MyClasses.MyInput;
import MyClasses.MyMessages;

import java.util.Random;
import java.util.Scanner;

public class Lecture05 {

    public static void main(String[] args) {

        MyArray myArray = new MyArray();
        MyInput myInput = new MyInput();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        MyMessages myMessages = new MyMessages();
        myMessages.pStars();
        System.out.println("Крестики-Нолики");
        myMessages.pStars();
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
                        //System.out.println("Как вас зовут?");                      //заново спрашивать имя игрока
                        userName = "Человек";
                        //userName = scanner.next();
                        //}
                        break;
                    case 2:
                        System.out.println("ИГРА ВДВОЕМ");
                        mode = 2;
                        break;
                    case 3:
                        myMessages.pHelp();
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
                    myMessages.pStars();
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
                                    playerMove = myInput.getInt(playerName+", ваш ход." , scanner,1,10);      // ход Игрока
                                    if (playerMove + 1 > 9 || playerMove + 1 < 1) {
                                        System.out.println("Введите число от 1 до 9");
                                        inputCorrect = false;
                                    } else {
                                        inputCorrect = true;
                                    }
                                } while (!inputCorrect);
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
                            myMessages.pStars();
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
                    myMessages.pStars();
                    System.out.println(player1CounterName + ": Побед - " + player1Wins + ", поражений - " + player1Defeats);
                    System.out.println(player2CounterName + ": Побед - " + player2Wins + ", поражений - " + player2Defeats);
                    System.out.println("Сыграно партий: " + setsPlayed);
                    myMessages.pStars();

                    if (player1Wins > player2Wins) {
                        bestResult = player1Wins;
                    } else {
                        bestResult = player2Wins;
                    }
                }

                myMessages.pStars();
                if (bestResult == player1Wins) {                                    //определяем, чей результат
                    System.out.println("Отлично! " + player1CounterName + " выиграл игру!!!");
                } else {
                    System.out.println("Отлично! " + player2CounterName + " выиграл игру!!!");
                }
                myMessages.pStars();
                System.out.println("Хотите сыграть еще? (Да/Нет)");
                playAgain = scanner.next();
                playAgain = playAgain.toLowerCase();
            }
        }//конец игры
    }
}




