package by.bsuir.ovchelupov.task04.task;

import java.util.ArrayList;

/**
 * The PrimeNumbers class contains implementation of 4th task
 */
public class PrimeNumbers {

    private PrimeNumbers() {
    }

    /**
     * Determines whether value is prime using simplest algorithm
     *
     * @param num positive value
     * @return boolean value
     */
    private static boolean IsPrime(int num) {
        if (num <= 1) {
            return false;
        }

        if (num > 2 && num % 2 == 0) {
            return false;
        }

        int top = (int) Math.sqrt(num);

        // it should test only odd numbers that are not exceed sqrt of argument
        for (int i = 3; i <= top; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns array of positions of primes
     *
     * @param numbers array of prime numbers
     * @return array of positions of prime numbers
     */
    public static int[] PrimePositions(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("null passed");
        }

        var result = new ArrayList<Integer>();

        for (int i = 0; i < numbers.length; i++) {
            if (IsPrime(numbers[i])) {
                result.add(i);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
