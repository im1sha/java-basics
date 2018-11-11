package by.bsuir.ovchelupov.task09;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for BasketAnalyzer class
 */
class BasketballAnalyzerTest {

    /**
     * Tests getBallsWeight()
     */
    @Test
    void getBallsWeight() {

        Basket basket = new Basket();

        Ball ball1 = new Ball(1, "red");
        Ball ball2 = new Ball(2, "green");

        Assertions.assertThrows(IllegalArgumentException.class, () -> BasketballAnalyzer.getBallsWeight(null));
        Assertions.assertEquals(0, BasketballAnalyzer.getBallsWeight(basket));

        basket.addBall(ball1);
        basket.addBall(ball2);
        Assertions.assertEquals(ball1.getWeight() + ball2.getWeight(), BasketballAnalyzer.getBallsWeight(basket));
    }

    /**
     * Tests getBallsByColor()
     */
    @Test
    void getBallsByColor() {

        Basket basket = new Basket();

        Assertions.assertThrows(IllegalArgumentException.class, () -> BasketballAnalyzer.getBallsByColor(null, "color"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> BasketballAnalyzer.getBallsByColor(basket, null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> BasketballAnalyzer.getBallsByColor(basket, ""));

        basket.addBall(new Ball(1, "red"));
        basket.addBall(new Ball(1, "red"));
        basket.addBall(new Ball(2, "red"));
        basket.addBall(new Ball(2, "blue"));
        basket.addBall(new Ball(3, "blue"));

        Assertions.assertEquals(3, BasketballAnalyzer.getBallsByColor(basket, "red").size());
        Assertions.assertEquals(2, BasketballAnalyzer.getBallsByColor(basket, "blue").size());
        Assertions.assertEquals(0, BasketballAnalyzer.getBallsByColor(basket, "green").size());
    }
}