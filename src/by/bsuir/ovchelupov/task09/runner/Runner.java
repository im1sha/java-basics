package by.bsuir.ovchelupov.task09.runner;

import by.bsuir.ovchelupov.task09.task.Ball;
import by.bsuir.ovchelupov.task09.task.Basket;
import by.bsuir.ovchelupov.task09.task.BasketballAnalyzer;
import by.bsuir.ovchelupov.utils.Scanner;

import java.util.LinkedList;

public class Runner {

    /**
     * Fills basket with user's balls
     *
     * @param basket Basket to fill
     */
    private static void fillBasket(Basket basket) {

        var scanner = new Scanner();

        System.out.print("Enter balls amount: ");
        int ballsCount = scanner.getNonNegativeInt();

        double ballWeight;
        String ballColor;

        for (int i = 0; i < ballsCount; i++) {
            System.out.println("Ball " + (i + 1) + " of " + ballsCount);
            System.out.print("Enter ball's weight: ");
            ballWeight = scanner.getPositiveDouble();
            System.out.print("Enter ball's color: ");
            ballColor = scanner.getNonEmptyString();
            basket.addBall(new Ball(ballWeight, ballColor));
        }
    }

    /**
     * Starts the program
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
     * Constructor to avoid instance creation
     */
    private Runner() {
    }
}
