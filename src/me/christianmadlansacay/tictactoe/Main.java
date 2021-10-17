package me.christianmadlansacay.tictactoe;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        runGame();
    }

    public static void runGame() {
        char[] boardValues = {'0', '1', '2', '3', '4', '5', '6', '7', '8'};
        System.out.println(boardValues);
        int turnCount = 0;
        for (char item : boardValues) {
            char prevTurn = 'o';
            char turn = 'x';
            int userInput;
            updateBoard(boardValues, turn, prevTurn, turnCount);
            while (true) {
                userInput = getInput();
                if (userInput < 9 && userInput > -1 && boardValues[userInput] != turn && boardValues[userInput] != prevTurn) {
                    break;
                }
            }
            boardValues[userInput] = turn;
            turnCount++;
            prevTurn = turn;
            turn = 'o';
            updateBoard(boardValues, turn, prevTurn, turnCount);
            while (true) {
                userInput = getInput();
                if (userInput < 9 && userInput > -1 && boardValues[userInput] != turn && boardValues[userInput] != prevTurn) {
                    break;
                }
            }
            boardValues[userInput] = turn;
            turnCount++;
        }
    }

    public static int getInput() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static void updateBoard(char[] boardValues, char turn, char prevTurn, int turnCount) {
        String board = boardValues[0] + "|" + boardValues[1] + "|" + boardValues[2] + "\n-----\n" + boardValues[3] + "|" + boardValues[4] + "|" + boardValues[5] + "\n-----\n" + boardValues[6] + "|" + boardValues[7] + "|" + boardValues[8];
        System.out.println(board);
        if (Arrays.equals(boardValues, new char[] {prevTurn, prevTurn, prevTurn, boardValues[3], boardValues[4], boardValues[5], boardValues[6], boardValues[7], boardValues[8]})) {
            playerWon(prevTurn);
        } else if (Arrays.equals(boardValues, new char[] {prevTurn, boardValues[1], boardValues[2], prevTurn, boardValues[4], boardValues[5], prevTurn, boardValues[7], boardValues[8]})) {
            playerWon(prevTurn);
        } else if (Arrays.equals(boardValues, new char[] {boardValues[0], boardValues[1], boardValues[2], boardValues[3], boardValues[4], boardValues[5], prevTurn, prevTurn, prevTurn})) {
            playerWon(prevTurn);
        } else if (Arrays.equals(boardValues, new char[] {boardValues[0], boardValues[1], prevTurn, boardValues[3], boardValues[4], prevTurn, boardValues[6], boardValues[7], prevTurn})) {
            playerWon(prevTurn);
        } else if (Arrays.equals(boardValues, new char[] {boardValues[0], prevTurn, boardValues[2], boardValues[3], prevTurn, boardValues[5], boardValues[6], prevTurn, boardValues[8] })) {
            playerWon(prevTurn);
        } else if (Arrays.equals(boardValues, new char[] {boardValues[0], boardValues[1], boardValues[2], prevTurn, prevTurn, prevTurn, boardValues[6], boardValues[7], boardValues[8]})) {
            playerWon(prevTurn);
        } else if (Arrays.equals(boardValues, new char[] {boardValues[0], boardValues[1], prevTurn, boardValues[3], prevTurn, boardValues[5], prevTurn, boardValues[7], boardValues[8]})) {
            playerWon(prevTurn);
        } else if (Arrays.equals(boardValues, new char[] {prevTurn, boardValues[1], boardValues[2], boardValues[3], prevTurn, boardValues[5], boardValues[6], boardValues[7], prevTurn})) {
            playerWon(prevTurn);
        } else if (turnCount == 9) {
            tie();
        } else {
            System.out.println("Turn: " + turn);
        }
    }

    public static void playerWon(char prevTurn) {
        while (true) {
            System.out.println(prevTurn + " has won!\n \nType '0' to play again!\nType '1' to exit!");
            int userInput = getInput();
            if (userInput == 0) {
                runGame();
                break;
            } else if (userInput == 1) {
                System.exit(0);
                break;
            }
        }
    }
    public static void tie() {
        while (true) {
            System.out.println("Tie! \n \nType '0' to play again!\nType '1' to exit!");
            int userInput = getInput();
            if (userInput == 0) {
                runGame();
                break;
            } else if (userInput == 1) {
                System.exit(0);
                break;
            }
        }
    }
}
