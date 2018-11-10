package by.bsuir.ovchelupov.lab1.task7;

/**
 * Class to demonstrate task 7 implementation
 */
public class Runner {

    /**
     * Constructor to avoid object creation
     */
    private Runner() {
    }

    /**
     * Entry point for program. Inputs array and outputs sorted array
     *
     * @param args Command line arguments, not in use
     */
    public static void main(String[] args) {
        double[] array;
        StringBuilder stringBuilder = new StringBuilder();
        var scanner = new by.bsuir.ovchelupov.lab1.Scanner();
        System.out.print("Enter array length: ");
        array = new double[scanner.getNonNegativeInt()];
        for (int index = 0; index < array.length; index++) {
            System.out.print("Enter number " + (index + 1) + " of " + array.length + ": ");
            array[index] = scanner.getDouble();
        }

        ShellSort.sort(array);

        for (double value : array) {
            stringBuilder.append(value);
            stringBuilder.append(", ");
        }
        System.out.print("Sorted array: " + stringBuilder.toString());
    }
}

