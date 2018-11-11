package by.bsuir.ovchelupov.task05;

public class Runner {

    /**
     * Private constructor to prevent object creation
     */
    private Runner() {
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4, 5, 7, 0, 3, 9, 11,};
        var result = IncreasingSequence.FindNumberOfItemsToRemove(arr);
        System.out.print("Total items to remove: " + result);
    }

}
