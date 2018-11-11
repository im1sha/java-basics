package by.bsuir.ovchelupov.task08;

import by.bsuir.ovchelupov.utils.Scanner;

public class Runner {

    /**
     * Constructor to avoid instance creation
     */
    private Runner() {
    }

    /**
     * Starts application. Outputs sorted array
     *
     * @param args Command line arguments, not in use
     */
    public static void main(String[] args) {
        var scanner = new Scanner();
        System.out.print("Enter array length: ");
        int size = scanner.getNonNegativeInt();
        double[] arrayA = new double[size];
        double[] arrayB = new double[size];

        for (int index = 0; index < arrayA.length; index++) {
            System.out.print("Enter A #" + (index + 1) + " of " + arrayA.length + ": ");
            arrayA[index] = scanner.getDouble();
        }
        for (int index = 0; index < arrayB.length; index++) {
            System.out.print("Enter B #" + (index + 1) + " of " + arrayB.length + ": ");
            arrayB[index] = scanner.getDouble();
        }

        int[] results = Sequence.ReturnInsertPosition(arrayA, arrayB);

        for (int value : results) {
            System.out.print(value + "  ");
        }

    }
}
