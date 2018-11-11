package by.bsuir.ovchelupov.task09;

import by.bsuir.ovchelupov.utils.Scanner;

import java.util.LinkedList;


public class Runner {

    /**
     * Fills basket with user's balls
     *
     * @param basket Basket to fill
     */
    private static void fillBasket(Basket basket) {

        var Scanner = new Scanner();

        int ballsCount;
        double ballWeight;
        String ballColor;

        System.out.print("Enter balls amount: ");
        ballsCount = Scanner.getNonNegativeInt();

        for (int i = 0; i < ballsCount; i++) {
            System.out.println("Ball " + (i + 1) + " of " + ballsCount);
            System.out.print("Enter ball's weight: ");
            ballWeight = Scanner.getPositiveDouble();
            System.out.print("Enter ball's color: ");
            ballColor = Scanner.getNonEmptyString();
            basket.addBall(new Ball(ballWeight, ballColor));
        }
    }

    /**
     * Start the program
     *
     * @param args Command line arguments, not in use
     */
    public static void main(String[] args) {
        Basket basket = new Basket();
        String color;

        fillBasket(basket);
        System.out.println("Total balls weight: " + BasketballAnalyzer.getBallsWeight(basket));

        System.out.print("Enter color to search for: ");
        var Scanner = new Scanner();
        color = Scanner.getNonEmptyString();

        LinkedList<Ball> balls = BasketballAnalyzer.getBallsByColor(basket, color);
        System.out.println("It's " + balls.size() + " ball(s) of " + color + " color");
        System.out.println("Balls of " + color + " color in basket:");

        for (Ball ball : balls) {
            System.out.println("\t" + ball.toString());
        }
    }

    /**
     * Constructor to avoid object creation
     */
    private Runner() {
    }
}
