package by.bsuir.ovchelupov.lab1.task1;

/**
 * The Formula class contains implementation of 1st task
 */
public class Formula {

    /**
     * Private constructor prevents an object creation
     */
    private Formula() {
    }

    /**
     * Calculates predefined expression
     *
     * @param x X Value of double type
     * @param y Y Value of double type
     * @return Calculated double value
     * @throws ArithmeticException If result is not a number or infinite
     */
    public static double calculateExpression(double x, double y) {
        // predefined constants
        double numerator = 1 + Math.pow(Math.sin(x + y), 2);
        double denominator = 2 + Math.abs(x - 2 * x /
                (1 + Math.pow(x, 2) * Math.pow(y, 2)));
        double result = numerator / denominator + x;

        if (!Double.isFinite(result)) {
            throw new ArithmeticException("Result should be finite number");
        }

        return result;
    }
}
