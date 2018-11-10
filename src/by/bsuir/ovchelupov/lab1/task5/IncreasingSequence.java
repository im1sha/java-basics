package by.bsuir.ovchelupov.lab1.task5;

public class IncreasingSequence {

    private IncreasingSequence()
    {

    }

    /**
     * Determines how many items should be removed to get increasing sequence from given one
     * @param numbers Any number sequence
     * @return number of items to remove
     */
    public static int FindNumberOfItemsToRemove(int[] numbers)
    {
        if (numbers == null) {
            throw new IllegalArgumentException("null passed");
        }
        if (numbers.length == 1)
        {
            return 0;
        }
        int[] lengthOfSubsequence = new int[numbers.length];

        for (int i = 0; i < lengthOfSubsequence.length; i++)
        {
            lengthOfSubsequence[i] = 1;
        }

        for (int i = 1; i < numbers.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if ((numbers[i] > numbers[j])   &&
                        (lengthOfSubsequence[i] <= lengthOfSubsequence[j]))
                {
                    lengthOfSubsequence[i] = lengthOfSubsequence[j] + 1;
                }
            }
        }
        int maximum = 0;
        for(int length : lengthOfSubsequence)
        {
            maximum = Math.max(maximum, length);
        }
        return numbers.length - maximum;
    }

}


