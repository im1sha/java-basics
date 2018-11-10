package by.bsuir.ovchelupov.lab1.task8;

public class Sequence {

    private Sequence() { }

    /**
     * Returns positions of array A where to insert items from array B to get increasing sequence
     * @param sequenceA Array
     * @param sequenceB Array
     * @return Positions of array A where to insert items of array B
     */
    public static int[] ReturnInsertPosition(double[] sequenceA, double[] sequenceB) {
        if (sequenceA.length != sequenceB.length) {
            throw new IllegalArgumentException("sequences should have the same length");
        }
        int length = sequenceA.length;
        int[] result = new int[length];
        int currentA = 0;
        int currentB = 0;
        while ((currentB < length) && (currentA < length)) {
            if (sequenceA[currentA] > sequenceB[currentB]) {
                result[currentB] = currentA;
                currentB++;
            } else {
                currentA++;
            }
        }

        for (int i = currentB; i < length; i++) {
            result[i] = length;
        }

        return result;
    }
}
