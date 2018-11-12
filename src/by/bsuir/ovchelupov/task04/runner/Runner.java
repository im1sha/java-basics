package by.bsuir.ovchelupov.task04.runner;

import by.bsuir.ovchelupov.task04.task.PrimeNumbers;
import by.bsuir.ovchelupov.utils.Scanner;

/**
 * The Runner class provides entry point to 4th tasks
 */
public class Runner {

    /**
     * Private constructor to prevent object creation
     */
    private Runner() {
    }


    /**
     * Runs 4th task
     *
     * @param args string parameters passed to task, not in use
     */
    public static void main(String[] args) {

        var scanner = new Scanner();
        System.out.println("Total items: ");
        int totalItems = scanner.getPositiveInt();

        int[] arr = new int[totalItems];

        for (int i = 0; i < totalItems; i++) {
            System.out.println("item #" + (i + 1) + " : ");
            arr[i] = scanner.getInt();
        }


        var result = PrimeNumbers.PrimePositions(arr);
        System.out.println("primes: ");
        for (var i : result) {
            System.out.println(arr[i] + "\t[at position " + i + "] ");
        }
    }
}