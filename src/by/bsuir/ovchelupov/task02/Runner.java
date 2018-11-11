package by.bsuir.ovchelupov.task02;

import by.bsuir.ovchelupov.utils.Scanner;

import static by.bsuir.ovchelupov.task02.PointOnPlane.inRegion;

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
        var scanner = new Scanner();

        System.out.println("Enter x & y values:");
        double x = scanner.getDouble();
        double y = scanner.getDouble();

        System.out.println("Result: " + (inRegion(x, y) ? "In region" : "Out of region bounds"));
    }

}