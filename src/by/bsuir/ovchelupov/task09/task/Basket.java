package by.bsuir.ovchelupov.task09.task;

import java.util.LinkedList;
import java.util.Objects;

/**
 * Class describing Basket
 */
public final class Basket {

    /**
     * Contained Balls
     */
    private LinkedList<Ball> ballList;

    /**
     * Adds ball to basket
     *
     * @param ball Ball to add
     */
    public void addBall(Ball ball) {

        if (ball == null) {
            throw new IllegalArgumentException("Argument shouldn't be null");
        }

        ballList.add(ball);
    }

    /**
     * Gets copy of all the balls of this basket
     *
     * @return All balls of basket
     */
    public LinkedList<Ball> getBallList() {
        return new LinkedList<>(ballList);
    }

    /**
     * Compares this object to argument
     *
     * @param obj Object to compare
     * @return True if objects are the same, false otherwise
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if ((obj == null) || (this.getClass() != obj.getClass())) {
            return false;
        }

        return Objects.equals(this.ballList, ((Basket) obj).ballList);
    }

    /**
     * Generates hashcode of this object
     *
     * @return Hash code of this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(ballList);
    }

    /**
     * Generates string representation of this object
     *
     * @return String representation of this object
     */
    @Override
    public String toString() {
        return getClass().getName() + "@ballList: " + ballList.toString();
    }

    /**
     * Constructor for Basket
     */
    public Basket() {
        ballList = new LinkedList<>();
    }
}

