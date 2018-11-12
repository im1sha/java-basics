package by.bsuir.ovchelupov.task05.runner;

import by.bsuir.ovchelupov.task05.task.IncreasingSequence;
import by.bsuir.ovchelupov.utils.Scanner;

public class Runner {

    /**
     * Private constructor to prevent object creation
     */
    private Runner() {
    }

    public static void main(String[] args) {

        var scanner = new Scanner();
        System.out.println("Total items: ");
        int totalItems = scanner.getPositiveInt();

        int[] arr = new int[totalItems];

        for (int i = 0; i < totalItems; i++) {
            System.out.println("item #" + (i + 1) + " : ");
            arr[i] = scanner.getInt();
        }

        var result = IncreasingSequence.FindNumberOfItemsToRemove(arr);
        System.out.print("Total items to remove: " + result);
    }

}
