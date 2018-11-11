package by.bsuir.ovchelupov.task04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class PrimeNumbersTest {

    /**
     * Tests PrimeNumbers.PrimePositions() method
     */
    @Test
    void findPrimes() {
        Assertions.assertArrayEquals(new int[]{2, 3, 5, 6, 8, 9}, PrimeNumbers.PrimePositions(new int[]{-99, 1, 2, 3, 4, 5, 7, 9, 11, 17, 22, 27}));

        Assertions.assertEquals(0, PrimeNumbers.PrimePositions(new int[20]).length);

        Assertions.assertThrows(IllegalArgumentException.class, () -> PrimeNumbers.PrimePositions(null));
    }
}