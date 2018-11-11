package by.bsuir.ovchelupov.task07;

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
        double[] array;
        StringBuilder stringBuilder = new StringBuilder();
        var scanner = new Scanner();
        System.out.print("Enter array length: ");
        array = new double[scanner.getNonNegativeInt()];
        for (int index = 0; index < array.length; index++) {
            System.out.print("Enter number " + (index + 1) + " of " + array.length + ": ");
            array[index] = scanner.getDouble();
        }

        Sort.shellSort(array);

        for (double value : array) {
            stringBuilder.append(value);
            stringBuilder.append(", ");
        }
        System.out.print("Sorted array: " + stringBuilder.toString());
    }
}

