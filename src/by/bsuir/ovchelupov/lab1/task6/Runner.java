package by.bsuir.ovchelupov.lab1.task6;

public class Runner {
    /**
     * Private constructor to prevent object creation
     */
    private Runner() {}

    /**
     * Entry point of demonstration program
     * @param args Command line arguments, not in use
     */
    public static void main(String[] args) {
        double[] inputArray;
        StringBuilder stringBuilder = new StringBuilder();

        var scanner = new by.bsuir.ovchelupov.lab1.Scanner();
        System.out.println("Enter size:");

        int size = scanner.getNonNegativeInt();

        System.out.print("Enter source array length: ");
        inputArray = new double[size];
        for (int index = 0; index < inputArray.length; index++) {
            System.out.print("Enter number " + (index + 1) + " of " + inputArray.length + ": ");
            inputArray[index] = scanner.getDouble();
        }

        for (double[] subArray : SquareMatrix.generate(inputArray)) {
            for (double value : subArray) {
                stringBuilder.append(value);
                stringBuilder.append(' ');
            }
            stringBuilder.append('\n');
        }
        System.out.println("Result matrix:");
        System.out.println(stringBuilder.toString());
    }
}
