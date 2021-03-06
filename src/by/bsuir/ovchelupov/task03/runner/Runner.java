package by.bsuir.ovchelupov.task03.runner;

import by.bsuir.ovchelupov.utils.Scanner;
import static by.bsuir.ovchelupov.task03.task.TableOfTangents.getTangentList;
import static by.bsuir.ovchelupov.task03.task.TableRepresentation.getTableRepresentation;

/**
 * The Runner class provides entry point to 3d tasks
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
        System.out.println("Enter x & y & h values:");

        double[][] doubles;
        double x = scanner.getDouble();
        double y = scanner.getDouble();
        double h = scanner.getDouble();

        try {
            doubles = getTangentList(x, y, h);
            var table = getTableRepresentation(doubles);
            for (String s : table) {
                System.out.println(s);
            }
        } catch (IllegalArgumentException e) {
            System.out.print("Invalid argument has passed: " + e.getMessage());
        }
    }
}