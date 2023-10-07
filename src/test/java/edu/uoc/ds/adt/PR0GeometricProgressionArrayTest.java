package edu.uoc.ds.adt;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PR0GeometricProgressionArrayTest {

    private PR0GeometricProgressionArray pr0Array;

    @Before
    public void setUp() {
        this.pr0Array = new PR0GeometricProgressionArray(2, 2, 20);
        assertNotNull(this.pr0Array.getArray());
    }

    @After
    public void release() {
        this.pr0Array = null;
    }

    @Test
    public void arrayTest() {
        int[] v = this.pr0Array.getArray();
        assertEquals(2, v[0]);
        assertEquals(4, v[1]);
        assertEquals(8, v[2]);
        assertEquals(16, v[3]);
        assertEquals(32, v[4]);
        assertEquals(64, v[5]);
        assertEquals(128, v[6]);
        assertEquals(256, v[7]);
        assertEquals(512, v[8]);
        assertEquals(1024, v[9]);
    }

    @Test
    public void searchArray() {
        int index = this.pr0Array.getIndexOf(65);
        assertEquals(-1, index);
        index = this.pr0Array.getIndexOf(256);
        assertEquals(7, index);
        index = this.pr0Array.getIndexOf(512);
        assertEquals(8, index);
    }

    @Test
    public void binarySearchArray() {
        int index = this.pr0Array.binarySearch(65);
        assertEquals(-1, index);
        index = this.pr0Array.binarySearch(256);
        assertEquals(7, index);
        index = this.pr0Array.binarySearch(41);
        assertEquals(-1, index);
        index = this.pr0Array.binarySearch(512);
        assertEquals(8, index);
    }
}
