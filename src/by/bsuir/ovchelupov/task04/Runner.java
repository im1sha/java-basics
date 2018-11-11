package by.bsuir.ovchelupov.task04;

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
        int[] arr = {2, 3, 4, 5, 7, 9, 11, 12, 13, 15, 17, 19, 21};
        var result = PrimeNumbers.PrimePositions(arr);
        System.out.print("primes: ");
        for (var i : result) {
            System.out.println(arr[i]);
        }
    }
}