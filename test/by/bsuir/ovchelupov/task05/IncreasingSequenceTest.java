package by.bsuir.ovchelupov.task05;

import by.bsuir.ovchelupov.task05.task.IncreasingSequence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IncreasingSequenceTest {

    /**
     * Tests IncreasingSequence.FindNumberOfItemsToRemove method
     */
    @Test
    void findPrimes() {
        Assertions.assertEquals(1,
                IncreasingSequence.FindNumberOfItemsToRemove(new int[]{15, 1, 2, 3, 4, 5, 7, 9, 11}));
        Assertions.assertEquals(0,
                IncreasingSequence.FindNumberOfItemsToRemove(new int[]{15}));
        Assertions.assertEquals(3,
                IncreasingSequence.FindNumberOfItemsToRemove(new int[]{15, 1, 2, 1, 3, 4, 5, 2, 7, 9, 11}));
        Assertions.assertEquals(1,
                IncreasingSequence.FindNumberOfItemsToRemove(new int[]{4, 1, 2, 3}));
        Assertions.assertEquals(3,
                IncreasingSequence.FindNumberOfItemsToRemove(new int[]{2, 3, 1, 4, 5, 7, 0, 3, 9, 11,}));
        Assertions.assertEquals(6,
                IncreasingSequence.FindNumberOfItemsToRemove(new int[]{2, 3, 1, 4, 5, 7, 0, 3, 9, 11, 1, 0, -10}));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> IncreasingSequence.FindNumberOfItemsToRemove(null));
    }
}