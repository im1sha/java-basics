package by.bsuir.ovchelupov.lab1.task6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SquareMatrixTest {

    /**
     * Tests for generate() method
     */
    @Test
    void generate() {
        double[][] expectedResult;

        Assertions.assertThrows(IllegalArgumentException.class, () -> SquareMatrix.generate(null));

        expectedResult = new double[0][0];
        Assertions.assertArrayEquals(expectedResult, SquareMatrix.generate(new double[0]));

        expectedResult = new double[][] { { 1 } };
        Assertions.assertArrayEquals(expectedResult, SquareMatrix.generate(new double[] { 1 }));

        expectedResult = new double[][] { { 1, 2, 3 }, { 2, 3, 1 }, { 3, 1, 2 } };
        Assertions.assertArrayEquals(expectedResult, SquareMatrix.generate(new double[] { 1, 2, 3 }));
    }
}