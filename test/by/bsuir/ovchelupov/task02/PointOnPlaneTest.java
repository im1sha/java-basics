package by.bsuir.ovchelupov.task02;

import by.bsuir.ovchelupov.task02.task.PointOnPlane;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Class containing tests for PointOnPlane class
 */
class PointOnPlaneTest {

    /**
     * Tests inRegion() method
     */
    @Test
    void isPointInFigure() {
        Assertions.assertTrue(PointOnPlane.inRegion(-4.0, 5.0));
        Assertions.assertFalse(PointOnPlane.inRegion(-6, -4));
        Assertions.assertTrue(PointOnPlane.inRegion(4.0, 0.00));
    }
}