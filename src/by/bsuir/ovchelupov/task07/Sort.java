package by.bsuir.ovchelupov.task07;


/**
 * Class with sort implementations
 */
public class Sort {

    /**
     * Sorts double array using Shell sort algorithm
     *
     * @param array Array to sort
     */
    public static void shellSort(double[] array) {

        if (array == null) {
            throw new IllegalArgumentException("Array shouldn't be null");
        }

        int currentIndex = 0;

        while (currentIndex < array.length - 1) {
            if (array[currentIndex] <= array[currentIndex + 1]) {
                currentIndex++;
            } else {
                // swap values
                double buffer = array[currentIndex];
                array[currentIndex] = array[currentIndex + 1];
                array[currentIndex + 1] = buffer;

                if (currentIndex > 0) {
                    currentIndex--;
                }
            }
        }
    }

    /**
     * Private constructor to prevent object creation
     */
    private Sort() {
    }
}
