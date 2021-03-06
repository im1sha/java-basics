package by.bsuir.ovchelupov.task06.runner;

import by.bsuir.ovchelupov.task06.task.SquareMatrix;
import by.bsuir.ovchelupov.utils.Scanner;

public class Runner {

    /**
     * Prevents instance creation
     */
    private Runner() {
    }

    /**
     * Entry point of program
     *
     * @param args Command line arguments, not in use
     */
    public static void main(String[] args) {
        double[] inputArray;
        StringBuilder stringBuilder = new StringBuilder();

        var scanner = new Scanner();
        System.out.println("Enter size:");

        int size = scanner.getNonNegativeInt();

        inputArray = new double[size];
        for (int index = 0; index < inputArray.length; index++) {
            System.out.print("Enter number " + (index + 1) + " of " + inputArray.length + ": ");
            inputArray[index] = scanner.getDouble();
        }

        for (double[] subArray : SquareMatrix.generate(inputArray)) {
            for (double value : subArray) {
                stringBuilder.append(value);
                stringBuilder.append(' ');
            }
            stringBuilder.append('\n');
        }
        System.out.println("Result matrix:");
        System.out.println(stringBuilder.toString());
    }
}
