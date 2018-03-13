package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }
    public String getString() {
        return scanner.nextLine();
    }
    public boolean yesNo() {
        String answer = scanner.next();
        if (answer.toLowerCase().contains("y")) {
            return true;
        } else if (answer.toLowerCase().contains("n")) {
            return false;
        }
        return yesNo();
    }
    public int getInt(int min, int max) {
        String prospect = scanner.next();
        try {
            int number = Integer.valueOf(prospect);
            if (number < min || number > max) {
                throw new NumberFormatException();
            } else return number;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, try entry again.");
            e.getMessage();
            return getInt(min, max);
        }

    }
    public int getInt() {
        String prospect = scanner.next();
        try {
            return Integer.valueOf(prospect);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, try entry again.");
            e.getMessage();
            return getInt();
        }
    }
    public double getDouble(double min, double max) {
        String prospect = scanner.next();
        try {
            double number = Double.valueOf(prospect);
            if (number < min || number > max) {
                return getDouble(min, max);
            }
            return number;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, try entry again.");
            e.getMessage();
            return getDouble(min, max);
        }
    }
    public double getDouble() {
        String prospect = scanner.next();
        try {
            return Double.valueOf(prospect);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, try entry again.");
            e.getMessage();
            return getDouble();
        }
    }
}
