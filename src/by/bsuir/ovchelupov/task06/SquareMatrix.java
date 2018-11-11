package by.bsuir.ovchelupov.task06;

public class SquareMatrix {

    /**
     * Generates square matrix by passed one dimensional array
     *
     * @param array Array used to generate matrix
     * @return Generated matrix
     */
    public static double[][] generate(double[] array) {
        double[][] result;

        if (array == null) {
            throw new IllegalArgumentException("Passed array shouldn't be null");
        }
        if (array.length == 0) {
            return new double[0][0];
        }

        int length = array.length;

        result = new double[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                result[i][j] = array[(i + j) % length];
            }
        }
        return result;
    }

    /**
     * prevents instance creation
     */
    private SquareMatrix() {
    }
}
