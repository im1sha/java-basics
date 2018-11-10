package by.bsuir.ovchelupov.lab1.task4;

import java.util.ArrayList;

/**
 * The Formula class contains implementation of 4th task
 */
public class PrimeNumbers {

    private PrimeNumbers() {
    }

    /**
     * determines whether value is prime using simplest algorithm
     *
     * @param num positive value
     * @return boolean value
     */
    private static boolean IsPrime(int num) {
        if (num > 2 && num % 2 == 0) {
            return false;
        }
        int top = (int) Math.sqrt(num) + 1;
        for (int i = 3; i < top; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * returns array of positions of primes
     *
     * @param numbers array of prime numbers
     * @return array of positions of prime numbers
     */
    public static int[] PrimePositions(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("null passed");
        }
        for (int i : numbers) {
            if (i <= 0) {
                throw new IllegalArgumentException("Prime number should be natural value");
            }
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
