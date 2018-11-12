package by.bsuir.ovchelupov.task01;

import by.bsuir.ovchelupov.task01.task.Formula;
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
        Assertions.assertEquals(1.0 / (2 + 5 - 10.0 / 626) + 5, Formula.calculateExpression(5, -5));

        /* result of formula should be NaN, so method will throw an exception */
        Assertions.assertThrows(ArithmeticException.class, () -> Formula.calculateExpression(Double.MAX_VALUE, Double.MAX_VALUE));
        Assertions.assertThrows(ArithmeticException.class, () -> Formula.calculateExpression(Double.NaN, 5));

    }
}