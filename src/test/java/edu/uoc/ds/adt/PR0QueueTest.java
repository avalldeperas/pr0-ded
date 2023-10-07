package edu.uoc.ds.adt;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PR0QueueTest {

    private PR0Queue pr0q;

    private void fillQueue(LocalDate localDate, int shift) {
        LocalDate date = localDate;
        for (int i = 0; i < pr0q.CAPACITY; i++) {
            pr0q.add(date);
            date = date.plusDays(shift);
        }
    }

    @Before
    public void setUp() {
        this.pr0q = new PR0Queue();

        assertNotNull(this.pr0q.getQueue());
    }

    @After
    public void release() {
        this.pr0q = null;
    }

    @Test
    public void queueTest_fixedDateWithShift() {
        int shift = 2;
        LocalDate initDate = LocalDate.parse("2023-09-28");
        fillQueue(initDate, shift);

        assertEquals(this.pr0q.CAPACITY, this.pr0q.getQueue().size());
        assertEquals(this.pr0q.clearFullQueue(), "28/09 30/09 02/10 04/10 06/10 08/10 10/10 12/10 14/10 16/10 ");
        assertEquals(0, this.pr0q.getQueue().size());
    }
}
