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
            System.out.println(calculateNum(reader));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculateNum(Scanner reader) {
        int highestAmount = 3;
        int[] highest = new int[highestAmount];
        int current = 0;

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            if (line.equals("")) {

                // get the lowest value stored currently
                int lowestVal = Integer.MAX_VALUE;
                int lowestIndex = -1;
                for (int i = 0; i < highestAmount; i++) {
                    if (highest[i] < lowestVal) {
                        lowestIndex = i;
                        lowestVal = highest[i];
                    }
                }

                // replace the lowest if new is higher
                if (current > highest[lowestIndex]) {
                    highest[lowestIndex] = current;
                }

                current = 0;
            } else {
                int num = Integer.parseInt(line);
                current += num;
            }
        }

        int sum = 0;
        for (int i = 0; i < highestAmount; i++) {
            int num = highest[i];
            System.out.println("Calories for elf " + i + " is " + num);
            sum += num;
        }

        return sum;
    }
}
