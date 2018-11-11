package by.bsuir.ovchelupov.task03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class TableOfTangentsTest {

    /**
     * Tests for TableOfTangents.getTangentList() method
     */
    @Test
    void checkTangentList() {
        double left = 5;
        double right = 6;
        double step = 0.5;
        Assertions.assertArrayEquals(new double[][]{
                        new double[]{left, Math.tan(left)},
                        new double[]{left + 0.5, Math.tan(left + 0.5)},
                        new double[]{right, Math.tan(right)}
                },
                TableOfTangents.getTangentList(left, right, step));

        right = 6.1;
        Assertions.assertArrayEquals(new double[][]{
                        new double[]{left, Math.tan(left)},
                        new double[]{left + 0.5, Math.tan(left + 0.5)},
                        new double[]{left + 1.0, Math.tan(left + 1.0)},
                        new double[]{right, Math.tan(right)},
                },
                TableOfTangents.getTangentList(left, right, step));

        // check wrong interval
        final double leftValue = 5;
        final double rightValue = 4.99;
        final double stepValue = 0.5;
        Assertions.assertThrows(IllegalArgumentException.class, () -> TableOfTangents.getTangentList(leftValue, rightValue, stepValue));

        // check negative step
        final double leftValue2 = 5;
        final double rightValue2 = 7.00;
        final double stepValue2 = -0.5;
        Assertions.assertThrows(IllegalArgumentException.class, () -> TableOfTangents.getTangentList(leftValue2, rightValue2, stepValue2));

        // check infinite value
        final double leftValue3 = 5;
        final double rightValue3 = Double.POSITIVE_INFINITY;
        final double stepValue3 = 0.5;
        Assertions.assertThrows(IllegalArgumentException.class, () -> TableOfTangents.getTangentList(leftValue3, rightValue3, stepValue3));
    }
}