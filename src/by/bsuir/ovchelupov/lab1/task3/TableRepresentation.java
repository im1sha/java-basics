package by.bsuir.ovchelupov.lab1.task3;

import java.util.LinkedList;

public class TableRepresentation {

    private TableRepresentation() { }

    /**
     * Creates table using two dimensional array
     * @param values Two dimensional array
     * @return String representing table
     */
    public static LinkedList<String> getTableRepresentation(double[][] values) {
        final int RESERVED = 3; // positions that's reserved by .##
        int leftColumnLength = 1;
        int rightColumnLength = 1;
        int currentLeftValue, currentRightValue;
        boolean isLeftValueNegative;
        boolean isRightValueNegative;
        for (int i = 0; i < values.length; ++i) {
            isLeftValueNegative = false;
            isRightValueNegative = false;

            if (values[i][0] < 0) {
                isLeftValueNegative = true;
            }
            currentLeftValue = (int) (RESERVED + 1 + Math.log10(Math.ceil(Math.abs(values[i][0]))));

            if (currentLeftValue >= leftColumnLength) {
                currentLeftValue += (isLeftValueNegative) ? 1 : 0;
                leftColumnLength = currentLeftValue;
            }

            if (values[i][1] < 0) {
                isRightValueNegative = true;
            }
            currentRightValue = (int) (RESERVED + 1 + Math.log10(Math.ceil(Math.abs(values[i][1]))));

            if (currentRightValue >= rightColumnLength) {
                currentRightValue += (isRightValueNegative) ? 1 : 0;
                rightColumnLength = currentRightValue;
            }
        }

        LinkedList<String> result = new LinkedList<String>();
        StringBuilder line = new StringBuilder();
        line.append(" + ");
        for (int j = 0; j < leftColumnLength ; ++j) {
            line.append('-');
        }
        line.append(" + ");
        for (int j = 0; j < rightColumnLength ; ++j) {
            line.append('-');
        }
        line.append(" + ");
        result.add(line.toString());
        for (int i = 0; i < values.length; ++i) {
            var leftCellSb = new StringBuilder(new java.text.DecimalFormat("#.##").format(values[i][0]));
            var right = new StringBuilder(new java.text.DecimalFormat("#.##").format(values[i][1]));
            var rightCellSb = new StringBuilder();

            int appendToLeft = leftColumnLength - leftCellSb.length();
            int appendToRight = rightColumnLength - right.length();
            for (int j = 0; j < appendToLeft; ++j) {
                leftCellSb.append(' ');
            }

            for (int j = 0; j < appendToRight; ++j) {
                rightCellSb.append(' ');
            }
            rightCellSb.append(right);

            String stringToAppend = " | " + leftCellSb + " | " + rightCellSb + " | " ;
            result.add(stringToAppend);
        }
        result.add(line.toString());
        return result;
    }
}
