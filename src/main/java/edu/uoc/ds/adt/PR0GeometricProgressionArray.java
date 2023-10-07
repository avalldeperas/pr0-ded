package edu.uoc.ds.adt;

public class PR0GeometricProgressionArray {

    private final int r;
    private final int a;
    private final int n;
    private int[] array;

    public PR0GeometricProgressionArray(int r, int a, int n) {
        this.r = r;
        this.a = a;
        this.n = n;
        array = buildArray();
    }

    private int[] buildArray() {
        this.array = new int[n];
        for (int i = 0; i < n; i++) {
            int exponent = (i + 1) - 1;
            array[i] = (int) (a * Math.pow(r, exponent));
        }
        return array;
    }


    public int[] getArray() {
        return this.array;
    }

    /**
     * Does a sequential search and returns the vector index
     * of a certain element in case it exists, -1 otherwise.
     * Linear time complexity: O(n).
     *
     * @param value to find in vector
     * @return index of value found, -1 otherwise.
     */
    public int getIndexOf(int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Does a binary search and returns the vector index
     * of a certain element in case it exists, -1 otherwise.
     * Log time complexity: O(log n)
     *
     * @param value value to find in vector
     * @return index of value found, -1 otherwise.
     */
    public int binarySearch(int value) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int midIndex = (start + end) / 2;

            if (array[midIndex] == value) {
                return midIndex;
            }

            if (array[midIndex] < value) {
                start = midIndex + 1;
            }

            if (array[midIndex] > value) {
                end = midIndex - 1;
            }
        }
        return -1;
    }
}
