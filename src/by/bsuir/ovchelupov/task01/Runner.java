package by.bsuir.ovchelupov.task01;

import by.bsuir.ovchelupov.utils.Scanner;

import static by.bsuir.ovchelupov.task01.Formula.calculateExpression;

/**
 * The Runner class provides entry point to 1st tasks
 */
public class Runner {

    /**
     * Private constructor to prevent object creation
     */
    private Runner() {
    }

    /**
     * Runs application
     *
     * @param args arguments array, not in use
     */
    public static void main(String[] args) {

        var scanner = new Scanner();
        System.out.println("Enter x & y values:");

        double x = scanner.getDouble();
        double y = scanner.getDouble();

        var result = calculateExpression(x, y);
        System.out.println("Result: " + result);
    }
}
