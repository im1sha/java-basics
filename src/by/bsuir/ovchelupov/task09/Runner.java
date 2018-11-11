package by.bsuir.ovchelupov.task09;

import by.bsuir.ovchelupov.Scanner;


public class Runner {
    /**
     * Fills basket with user's balls
     *
     * @param basket Basket to fill
     */
    private static void fillBasket(Basket basket) {
        int ballsCount;
        double ballWeight;
        String ballColor;
        var Scanner = new Scanner();
        System.out.print("Enter balls amount: ");
        ballsCount = Scanner.getNonNegativeInt();
        for (int ballNo = 0; ballNo < ballsCount; ballNo++) {
            System.out.println("Ball " + (ballNo + 1) + " of " + ballsCount);
            System.out.print("Enter ball's weight: ");
            ballWeight = Scanner.getPositiveDouble();
            System.out.print("Enter ball's color: ");
            ballColor = Scanner.getNonEmptyString();
            basket.addBall(new Ball(ballWeight, ballColor));
        }
    }

    /**
     * Entry point for program
     *
     * @param args Command line arguments, not in use
     */
    public static void main(String[] args) {
        Basket basket = new Basket();
        String color;

        fillBasket(basket);
        System.out.println("Balls in basket total weight: " + BasketballAnalyzer.getBallsWeight(basket));

        System.out.print("Enter color to search for: ");
        var Scanner = new Scanner();
        color = Scanner.getNonEmptyString();
        System.out.println("Balls of " + color + " color in basket:");
        for (Ball ball : BasketballAnalyzer.getBallsByColor(basket, color)) {
            System.out.println("\t" + ball.toString());
        }
    }

    /**
     * Constructor to avoid object creation
     */
    private Runner() {
    }
}
