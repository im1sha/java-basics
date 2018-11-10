package by.bsuir.ovchelupov.lab1.task6;

import java.util.ArrayList;
import java.util.ListIterator;

public class SquareMatrix {
    /**
     * Converts double array to ArrayList
     * @param array Array to convert
     * @return Converted ArrayList
     */
    private static ArrayList<Double> arrayToList(double[] array) {
        ArrayList<Double> list = new ArrayList<>();

        if (array == null) {
            throw new IllegalArgumentException("Array shouldn't be null");
        }

        for (double number : array) {
            list.add(number);
        }

        return list;
    }

    /**
     * Generates square matrix by array
     * @param array Array used to generate matrix
     * @return Generated matrix
     */
    public static double[][] generate(double[] array) {
        ArrayList<Double> list;
        ListIterator<Double> iterator;
        double[][] result;

        if (array == null) {
            throw new IllegalArgumentException("Array of elements shouldn't be null");
        }
        if (array.length == 0) {
            return new double[0][0];
        }

        list = arrayToList(array);
        iterator = list.listIterator();
        result = new double[array.length][array.length];

        for (double[] subArray : result) {
            for (int index = 0; index < subArray.length; index++) {
                if (!iterator.hasNext()) {
                    iterator = list.listIterator();
                }
                subArray[index] = iterator.next();
            }
            if (!iterator.hasNext()) {
                iterator = list.listIterator();
            }
            iterator.next();
        }
        return result;
    }

    /**
     * Private constructor to prevent object creation
     */
    private SquareMatrix() { }
}
