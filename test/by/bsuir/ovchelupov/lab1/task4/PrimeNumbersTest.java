package by.bsuir.ovchelupov.lab1.task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class PrimeNumbersTest {
    @Test
    void findPrimes() {
        Assertions.assertArrayEquals(new int[] { 2, 3, 5, 6, 7 }, PrimeNumbers.PrimePositions(new int[] { 15, 1, 2, 3, 4, 5, 7, 9, 11 }));
        Assertions.assertThrows(IllegalArgumentException.class, () -> PrimeNumbers.PrimePositions(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> PrimeNumbers.PrimePositions(new int[] { -1, 1, 2, 3, 4, 5, 7, 9, 11 }));
    }
}