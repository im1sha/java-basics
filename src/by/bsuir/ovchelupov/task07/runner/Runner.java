package by.bsuir.ovchelupov.task07.runner;

import by.bsuir.ovchelupov.task07.task.Sort;
import by.bsuir.ovchelupov.utils.Scanner;

/**
 * Class to demonstrate 7th task implementation
 */
public class Runner {

    private Runner() {
    }

    /**
     * Outputs sorted array
     *
     * @param args Command line arguments, not in use
     */
    public static void main(String[] args) {

        var scanner = new Scanner();

        System.out.print("Enter array length: ");
        double[] array = new double[scanner.getNonNegativeInt()];

        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter number " + (i + 1) + " of " + array.length + ": ");
            array[i] = scanner.getDouble();
        }

        Sort.shellSort(array);

        StringBuilder stringBuilder = new StringBuilder();

        for (double value : array) {
            stringBuilder.append(value);
            stringBuilder.append(", ");
        }

        System.out.print("Sorted array: " + stringBuilder.toString());
    }
}

