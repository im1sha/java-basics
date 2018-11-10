package by.bsuir.ovchelupov.lab1.task1;

import static by.bsuir.ovchelupov.lab1.task1.Formula.calculateExpression;

/**
 * The Runner class provides entry point to 1st tasks
 */
public class Runner {
    /**
     * Private constructor to prevent object creation
     */
    private Runner() {}

    public static void main(String[] args){

        var scanner = new by.bsuir.ovchelupov.lab1.Scanner();
        System.out.println("Enter x & y values:");

        double x = scanner.getDouble();
        double y = scanner.getDouble();

        var result = calculateExpression(x, y);
        System.out.println("Result: " + result + "\n");
    }
}

