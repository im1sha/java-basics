package by.bsuir.ovchelupov.task09;

import java.util.LinkedList;

/**
 * Class to analyze Basket instance
 */
public final class BasketballAnalyzer {

    /**
     * Gets weight of all balls in basket
     *
     * @param basket Basket to get balls from
     * @return Total weight of all balls
     */
    public static double getBallsWeight(Basket basket) {

        if (basket == null) {
            throw new IllegalArgumentException("Basket shouldn't be null");
        }

        double weight = 0;

        for (Ball ball : basket.getBallList()) {
            weight += ball.getWeight();
        }

        return weight;
    }

    /**
     * Gets list of balls by color
     *
     * @param basket Basket to get balls from
     * @param color  string representation of the balls color
     * @return List of all the balls of a passed color
     */
    public static LinkedList<Ball> getBallsByColor(Basket basket, String color) {
        LinkedList<Ball> suitedBalls = new LinkedList<>();

        if (basket == null) {
            throw new IllegalArgumentException("Basket shouldn't be null");
        }

        if ((color == null) || color.isEmpty()) {
            throw new IllegalArgumentException("Color is undefined");
        }

        for (Ball ball : basket.getBallList()) {
            if (ball.getColor().toLowerCase().equals(color.toLowerCase())) {
                suitedBalls.add(ball);
            }
        }
        return suitedBalls;
    }

    /**
     * Private constructor to prevent instance creation
     */
    private BasketballAnalyzer() {
    }
}
