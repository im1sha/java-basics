package by.bsuir.ovchelupov.lab1.task2;

/**
 * The Formula class contains implementation of 2nd task
 */
public class PointOnPlane {

    private PointOnPlane() {
    }

    /**
     * Detects whether point belongs to filled scope
     *
     * @param x X value of double type
     * @param y Y value of double type
     * @return Boolean value
     */
    public static boolean inRegion(double x, double y) {
        boolean result = false;
        if ((y >= -3 && Math.abs(x) <= 6 && y <= 0) ||
                (y <= 5 && y >= 0 && Math.abs(x) <= 4)) {
            result = true;
        }
        return result;
    }
}
