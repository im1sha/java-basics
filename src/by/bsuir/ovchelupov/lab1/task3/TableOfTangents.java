package by.bsuir.ovchelupov.lab1.task3;

/**
 * The TableOfTangents class contains implementation of 3d task
 */
public class TableOfTangents {

    private TableOfTangents() {
    }

    /**
     * Returns table of arguments and functions values
     *
     * @param a Min interval value
     * @param b Max interval value
     * @param h Step of positive value
     * @return Result array of double[2]
     * where 1st element is argument value(x) and
     * 2nd one is tangent of x
     */
    public static double[][] getTangentList(double a, double b, double h) {
        if (h <= 0) {
            throw new IllegalArgumentException("step h should be positive");
        }
        if (!Double.isFinite(h)) {
            throw new IllegalArgumentException("step h should be finite");
        }
        if (a > b) {
            throw new IllegalArgumentException("value of b should be greater then value of a");
        }
        if (!Double.isFinite(a) || !Double.isFinite(b)) {
            throw new IllegalArgumentException("bounds should be represented by finite values");
        }

        int listLength = ((b - a) % h == 0)
                ? (int) ((b - a) / h + 1)
                : (int) ((b - a) / h + 2);
        var result = new double[listLength][2];

        double currentValue = a;
        int i = 0;
        while (i < listLength - 1) {
            result[i][0] = currentValue; // argument value
            result[i][1] = Math.tan(currentValue); // tangent value
            i++;
            currentValue += h;
        }

        /* add value of right border of an interval and its tangent to list */
        result[listLength - 1][0] = b;
        result[listLength - 1][1] = Math.tan(b);

        return result;
    }


}
