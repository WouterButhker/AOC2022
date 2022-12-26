import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {
            File file = new File("input.txt");
            Scanner reader = new Scanner(file);
            System.out.println("NUMBER IS: ");
            System.out.println(calculatePart2(reader));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculatePart2(Scanner reader) {
        int prioritySum = 0;
        while (reader.hasNextLine()) {
            String line1 = reader.nextLine();
            String line2 = reader.nextLine();
            String line3 = reader.nextLine();

            HashSet<Character> h1 = new HashSet<Character>(), h2 = new HashSet<Character>(), h3 = new HashSet<Character>();
            for(int i = 0; i < line1.length(); i++)
            {
                h1.add(line1.charAt(i));
            }
            for(int i = 0; i < line2.length(); i++)
            {
                h2.add(line2.charAt(i));
            }
            for(int i = 0; i < line3.length(); i++)
            {
                h3.add(line3.charAt(i));
            }

            h1.retainAll(h2);
            h1.retainAll(h3);
            Character[] arr = new Character[1];
            char duplicate = h1.toArray(arr)[0].charValue();

            boolean isCapital = duplicate < 91;
            int priority;
            if (isCapital) priority = duplicate - 65 + 27;
            else priority = duplicate - 97 + 1;
            prioritySum += priority;
        }
        return prioritySum;
    }

    private static int calculate(Scanner reader) {
        int prioritySum = 0;
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            int halfway = line.length() / 2;
            String firstCompartment = line.substring(0, halfway);
            String secondCompartment = line.substring(halfway);

            char duplicate = 0;
            Set<Character> charsFirst = new HashSet<>();
            Set<Character> charsSecond = new HashSet<>();
            for (int i = 0; i < halfway; i++) {
                charsFirst.add(firstCompartment.charAt(i));
                charsSecond.add(secondCompartment.charAt(i));

                if (charsFirst.contains(secondCompartment.charAt(i))) {
                    duplicate = secondCompartment.charAt(i);
                    break;
                }
                if (charsSecond.contains(firstCompartment.charAt(i))) {
                    duplicate = firstCompartment.charAt(i);
                    break;
                }
            }

            boolean isCapital = duplicate < 91;
            int priority;
            if (isCapital) priority = duplicate - 65 + 27;
            else priority = duplicate - 97 + 1;
            prioritySum += priority;
//            System.out.println("Duplicate char is " + duplicate + " with prio " + priority);
        }
        return prioritySum;
    }
}
