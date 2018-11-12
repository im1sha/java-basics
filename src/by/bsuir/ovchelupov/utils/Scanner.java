package by.bsuir.ovchelupov.utils;

/**
 * The Scanner class provides input handling
 */
public class Scanner {

    public Scanner() {
    }

    /**
     * Handles string input until user enters correct double value
     *
     * @return double value
     */
    public double getDouble() {
        var scanner = new java.util.Scanner(System.in);
        while (!scanner.hasNextDouble()) {
            scanner.next();
        }
        return scanner.nextDouble();
    }

    /**
     * Gets positive double value from console
     *
     * @return First positive double value
     */
    public double getPositiveDouble() {
        double result;
        do {
            result = getDouble();
        } while (result <= 0);
        return result;
    }

    /**
     * Gets non-negative int from console
     *
     * @return First non-negative int value
     */
    public int getNonNegativeInt() {
        int result;
        do {
            result = getInt();
        } while (result < 0);
        return result;
    }

    /**
     * Gets int value from console
     *
     * @return First int value
     */
    public int getInt() {
        var scanner = new java.util.Scanner(System.in);
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * Gets int value from console
     *
     * @return First int value
     */
    public int getPositiveInt() {
        int value;
        do {
            value = getInt();
        } while (value <= 0);
        return value;
    }

    /**
     * Gets first non-empty string from console
     *
     * @return First string
     */
    public String getNonEmptyString() {
        String result;
        do {
            result = getString();
        } while (result.isEmpty());
        return result;
    }

    /**
     * Gets first string from console
     *
     * @return First string
     */
    public String getString() {
        var scanner = new java.util.Scanner(System.in);
        return scanner.nextLine();
    }

}

