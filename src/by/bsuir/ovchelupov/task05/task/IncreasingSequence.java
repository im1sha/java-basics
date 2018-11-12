package by.bsuir.ovchelupov.task05.task;

import java.util.Arrays;

/**
 * Class that provides methods to process increasing sequences
 */
public class IncreasingSequence {

    private IncreasingSequence() {
    }

    /**
     * Determines how many items should be removed to get increasing sequence from given one
     *
     * @param numbers Any numbers sequence
     * @return number of items to remove
     * @throws IllegalArgumentException If null passed
     */
    public static int FindNumberOfItemsToRemove(int[] numbers) throws IllegalArgumentException {
        if (numbers == null) {
            throw new IllegalArgumentException("null passed");
        }
        if (numbers.length == 1) {
            return 0;
        }

        int[] lengthOfSubsequence = new int[numbers.length]; // increasing items before current + current
        Arrays.fill(lengthOfSubsequence, 1);

        for (int i = 1; i < numbers.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((numbers[i] > numbers[j]) && (lengthOfSubsequence[i] <= lengthOfSubsequence[j])) {
                    lengthOfSubsequence[i] = lengthOfSubsequence[j] + 1;
                }
            }
        }
        int maximum = 0;
        for (int length : lengthOfSubsequence) {
            maximum = Math.max(maximum, length);
        }
        return numbers.length - maximum;
    }

}


