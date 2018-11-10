package by.bsuir.ovchelupov.lab1.task4;

import static by.bsuir.ovchelupov.lab1.task4.PrimeNumbers.PrimePositions;

/**
 * The Runner class provides entry point to 4th tasks
 */
public class Runner {

    /**
     * Private constructor to prevent object creation
     */
    private Runner() {}

    public static void main(String[] args){
        int[] arr = { 2, 3, 4, 5, 7, 9, 11, };
        var result = PrimePositions(arr);
        System.out.print("positions of primes: ");
        for (var i: result) {
            System.out.print(i + " ");
        }
    }
}