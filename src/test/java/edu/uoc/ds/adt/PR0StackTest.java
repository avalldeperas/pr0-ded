package edu.uoc.ds.adt;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PR0StackTest {

    private PR0Stack pr0q;

    private void fillStack(LocalDate localDate, int displacement) {
        for (int i = 0; i < pr0q.CAPACITY; i++) {
            int daysDisplaced = i * displacement;
            pr0q.push(localDate.plusDays(daysDisplaced));
        }
    }

    @Before
    public void setUp() {
        this.pr0q = new PR0Stack();

        assertNotNull(this.pr0q.getStack());
    }

    @After
    public void release() {
        this.pr0q = null;
    }

    @Test
    public void stackTest() {
        int displacement = 2;
        LocalDate initDate = LocalDate.parse("2023-09-28");

        fillStack(initDate, displacement);

        assertEquals(this.pr0q.CAPACITY, this.pr0q.getStack().size());
        assertEquals(this.pr0q.clearAllStack(), "16/10 14/10 12/10 10/10 08/10 06/10 04/10 02/10 30/09 28/09 ");
        assertEquals(0, this.pr0q.getStack().size());
    }
}
