package by.bsuir.ovchelupov.lab1.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FormulaTest {
    /**
     * Method to test Formula.calculateExpression() method
     */
    @Test
    void calculate() {
        Assertions.assertEquals(0.5, Formula.calculateExpression(0, 0));
        Assertions.assertEquals(-0.5, Formula.calculateExpression(-1, 1));
        Assertions.assertEquals(1.0 / (4 - 4.0 / 17) + 2, Formula.calculateExpression(2, -2));

        /* result of formula should be NaN, so method will throw an exception */
        Assertions.assertThrows(ArithmeticException.class, () -> Formula.calculateExpression(Double.MAX_VALUE, Double.MAX_VALUE));
    }
}