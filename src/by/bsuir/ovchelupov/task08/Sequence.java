package by.bsuir.ovchelupov.task08;

public class Sequence {

    private Sequence() {
    }

    /**
     * Returns positions of array A where to insert items from array B to get increasing sequence
     *
     * @param sequenceA Array
     * @param sequenceB another array
     * @return Positions of array A where to insert items of array B
     */
    public static int[] ReturnInsertPosition(double[] sequenceA, double[] sequenceB) {

        if (sequenceA == null || sequenceB == null) {
            throw new IllegalArgumentException("null passed as argument");
        }

        if (sequenceA.length != sequenceB.length) {
            throw new IllegalArgumentException("sequences should have the same length");
        }

        int length = sequenceA.length;
        if (length > 1) {
            for (int i = 1; i < length; i++) {
                if (sequenceA[i-1] > sequenceA[i]
                        || sequenceB[i-1] > sequenceB[i]) {
                    throw new IllegalArgumentException("decreasing sequence passed");
                }
            }
        }

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

        // fill remained elements of result array
        // with last element position if there are items in sequence B
        // which are greater then last item of sequence A
        for (int i = currentB; i < length; i++) {
            result[i] = length;
        }

        return result;
    }
}
