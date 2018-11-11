package by.bsuir.ovchelupov.lab1.task2;

import static by.bsuir.ovchelupov.lab1.task2.PointOnPlane.inRegion;

/**
 * The Runner class provides entry point to 2nd tasks
 */
public class Runner {

    /**
     * Private constructor to prevent instance creation
     */
    private Runner() {
    }

    /**
     * Runs application
     *
     * @param args arguments array, not in use
     */
    public static void main(String[] args) {
        var scanner = new by.bsuir.ovchelupov.lab1.Scanner();

        System.out.println("Enter x & y values:");
        double x = scanner.getDouble();
        double y = scanner.getDouble();

        System.out.println("Result: " + (inRegion(x, y) ? "In region" : "Out of region bounds"));
    }

}