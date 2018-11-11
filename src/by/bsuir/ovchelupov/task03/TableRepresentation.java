package by.bsuir.ovchelupov.task03;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * TableRepresentation class implements visual table representation
 */
public class TableRepresentation {

    private TableRepresentation() {
    }

    /**
     * Creates table using two dimensional array
     *
     * @param tableValues Two dimensional array
     * @return String table representation
     * @throws IllegalArgumentException If wrong parameters were passed
     */
    public static LinkedList<String> getTableRepresentation(double[][] tableValues) throws IllegalArgumentException {

        final int RESERVED_BY_FRACTION = 3; // positions which're reserved for fractional part (.00)

        if (tableValues == null) {
            throw new IllegalArgumentException("Table should contain 1 element at least");
        }
        for (double[] lineValues : tableValues) {
            if (lineValues == null || tableValues[0].length != lineValues.length) {
                throw new IllegalArgumentException("It should be the same amount of elements in each row");
            }
        }

        int[] columnWidth = getColumnsWidth(tableValues, RESERVED_BY_FRACTION);

        LinkedList<String> representation = new LinkedList<>();
        String horizontalLine = getHorizontalLine(columnWidth);

        representation.add(horizontalLine);

        /* fill table with values */
        LinkedList<String[]> cells = getCellsContent(tableValues, columnWidth, RESERVED_BY_FRACTION);
        for (var cell : cells) {
            StringBuilder line = new StringBuilder(" | ");
            for (var c : cell) {
                line.append(c + " | ");
            }
            representation.add(line.toString());
        }

        representation.add(horizontalLine);

        return representation;
    }

    /**
     * Calculates width required by each of the columns of the passed array
     *
     * @param tableContent two dimensional array of values to place to table
     * @param fractionalPartLength fraction length
     * @return length of each of the columns
     * @throws IllegalArgumentException If null passed
     */
    private static int[] getColumnsWidth(double[][] tableContent, int fractionalPartLength) throws IllegalArgumentException {

        if (tableContent == null) {
            throw new IllegalArgumentException("null passed as parameter");
        }

        int[] columnWidth = new int[tableContent[0].length];
        Arrays.fill(columnWidth, 1); // columns min width

        int[] currentWidth = new int[columnWidth.length];
        boolean[] isValueNegative = new boolean[columnWidth.length];

        for (double[] lineValues : tableContent) {

            Arrays.fill(isValueNegative, false);

            for (int i = 0; i < columnWidth.length; i++) {
                if (lineValues[i] < 0) {
                    isValueNegative[i] = true;
                }

                // total chars required for string representation of number
                int valueLength = (int) Math.log10(Math.ceil(Math.abs(lineValues[i])));

                currentWidth[i] = fractionalPartLength + 1 + valueLength;

                // calculate longest value length
                if (currentWidth[i] >= columnWidth[i]) {
                    currentWidth[i] += (isValueNegative[i]) ? 1 : 0; // add 1 position for minus sign
                    columnWidth[i] = currentWidth[i];
                }
            }
        }
        return columnWidth;
    }

    /**
     * Returns horizontal line string representation
     *
     * @param columnWidth width of each of the column
     * @return horizontal line represented as string
     * @throws IllegalArgumentException if null was passed as parameter
     */
    private static String getHorizontalLine(int[] columnWidth) throws IllegalArgumentException {

        if (columnWidth == null) {
            throw new IllegalArgumentException("columnWidth should be not null");
        }

        StringBuilder horizontalLine = new StringBuilder();
        for (int i = 0; i < columnWidth.length; i++) {
            horizontalLine.append(" + ");
            for (int j = 0; j < columnWidth[i]; j++) {
                horizontalLine.append('-');
            }
        }
        horizontalLine.append(" + ");
        return horizontalLine.toString();
    }

    /**
     * Transforms double representation of numbers to string representation
     *
     * @param values      values to transform
     * @param columnWidth width that should be filled by value
     * @return string representation of numbers
     * @throws IllegalArgumentException If array passed to method is not rectangular
     */
    private static LinkedList<String[]> getCellsContent(double[][] values, int[] columnWidth, int reservedByFraction) throws IllegalArgumentException {

        if (values == null || columnWidth == null) {
            throw new IllegalArgumentException("arguments shouldn't have null values");
        }

        if (values[0].length != columnWidth.length) {
            throw new IllegalArgumentException("arguments should have the same length");
        }

        int totalColumns = columnWidth.length;

        var result = new LinkedList<String[]>();

        String representationPattern = "0.";
        int fractionLength = Math.max(".0".length() - ".".length(), reservedByFraction - ".".length()); // it should be 1 digit after point at least

        for (int i = 0; i < fractionLength; i++) {
            representationPattern += "0";
        }

        for (double[] argumentAndFunction : values) {

            String[] content = new String[totalColumns];     // values from value argument
            String[] cell = new String[totalColumns];        // formatted cell content
            int[] shouldBeAppended = new int[totalColumns];  // left indent inside of a cell

            for (int i = 0; i < totalColumns; i++) {
                content[i] = new DecimalFormat(representationPattern).format(argumentAndFunction[i]);
                shouldBeAppended[i] = columnWidth[i] - content[i].length();
                cell[i] = "";
                for (int j = 0; j < shouldBeAppended[i]; j++) {
                    cell[i] += " ";
                }
                cell[i] += content[i];
            }

            result.add(cell);
        }

        return result;
    }
}
