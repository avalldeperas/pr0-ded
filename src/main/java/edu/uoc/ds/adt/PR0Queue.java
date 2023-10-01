package edu.uoc.ds.adt;


import edu.uoc.ds.adt.sequential.Queue;
import edu.uoc.ds.adt.sequential.QueueArrayImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PR0Queue {

    public final int CAPACITY = 10;

    private Queue<LocalDate> queue;

    public PR0Queue() {
        newQueue();
    }
    public void newQueue() {
        queue = new QueueArrayImpl<>(CAPACITY);
    }


    public String clearFullQueue() {
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            String date = queue.poll().format(DateTimeFormatter.ofPattern("dd/MM"));
            sb.append(date).append(" ");
        }
        return sb.toString();
    }

    public Queue<LocalDate> getQueue() {
        return this.queue;
    }

    public void add(LocalDate c) {
        this.queue.add(c);
    }
}
