import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {
            File file = new File("input.txt");
            Scanner reader = new Scanner(file);
            System.out.println("NUMBER IS: ");
            System.out.println(calculateNumPart2(reader));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculateNum(Scanner reader) {
        int score = 0;
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] vals = line.split(" ");
            String opponentMove = vals[0];
            String myMove = vals[1];

            boolean win = (opponentMove.equals("A") && myMove.equals("Y")) ||
                    (opponentMove.equals("B") && myMove.equals("Z")) ||
                    (opponentMove.equals("C") && myMove.equals("X"));
            boolean draw = (opponentMove.equals("A") && myMove.equals("X")) ||
                    (opponentMove.equals("B") && myMove.equals("Y")) ||
                    (opponentMove.equals("C") && myMove.equals("Z"));
            int outcomeScore;
            if (win) outcomeScore = 6;
            else if (draw) outcomeScore = 3;
            else outcomeScore = 0;

            int shapeScore;
            if (myMove.equals("X")) shapeScore = 1;
            else if (myMove.equals("Y")) shapeScore = 2;
            else shapeScore = 3;

            score += outcomeScore + shapeScore;

        }
        return score;
    }

    private static int calculateNumPart2(Scanner reader) {
        int score = 0;
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] vals = line.split(" ");
            String opponentMove = vals[0];
            String outCome = vals[1];


            int outcomeScore;
            if (outCome.equals("X")) outcomeScore = 0; // lose
            else if (outCome.equals("Y")) outcomeScore = 3; // draw
            else outcomeScore = 6; //win

            int shapeScore;
            if (outCome.equals("Y")) { //draw
                if (opponentMove.equals("A")) shapeScore = 1; // rock
                else if (opponentMove.equals("B")) shapeScore = 2; // paper
                else shapeScore = 3; // scissors
            } else if (outCome.equals("X")) { // lose
                if (opponentMove.equals("A")) shapeScore = 3; // scissors
                else if (opponentMove.equals("B")) shapeScore = 1; // rock
                else shapeScore = 2; // paper
            } else { // win
                if (opponentMove.equals("A")) shapeScore = 2; // paper
                else if (opponentMove.equals("B")) shapeScore = 3; // scissors
                else shapeScore = 1; // rock
            }

//            System.out.println("Adding " + (outcomeScore + shapeScore) + " to score");
            score += outcomeScore + shapeScore;

        }
        return score;
    }

}
