package by.bsuir.ovchelupov.task09.task;

import java.util.Objects;

/**
 * Class describing Ball
 */
public class Ball {

    /**
     * Ball weight
     */
    private final double weight;

    /**
     * Ball color
     */
    private final String color;

    /**
     * Gets ball's weight
     *
     * @return Ball's weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Gets ball's color
     *
     * @return Ball's color
     */
    public String getColor() {
        return color;
    }

    /**
     * Compares this object to argument
     *
     * @param obj Object to compare
     * @return True if objects are same and false otherwise
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if ((obj == null) || (this.getClass() != obj.getClass())) {
            return false;
        }

        Ball ball = (Ball) obj;
        return (ball.weight == this.weight) && Objects.equals(ball.color, this.color);
    }

    /**
     * Generates hashcode of object
     *
     * @return Hash code of object
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.weight, this.color);
    }

    /**
     * Generates string representation of this object
     *
     * @return String representation of this object
     */
    @Override
    public String toString() {
        return this.getClass().getName() + "@weight: " + this.weight + ", color: " + this.color;
    }

    /**
     * Creates Ball instance
     *
     * @param weight Weight of creating Ball instance. Should has positive finite value
     */
    public Ball(double weight, String color) {
        if (!Double.isFinite(weight)) {
            throw new IllegalArgumentException("Weight should be finite");
        }
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight should be positive");
        }
        if ((color == null) || color.isEmpty()) {
            throw new IllegalArgumentException("Ball should have color");
        }

        this.weight = weight;
        this.color = color;
    }
}
