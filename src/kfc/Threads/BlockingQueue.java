package kfc.Threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {

    private Queue<T> queue = new LinkedList<>();
    private Lock lock = new ReentrantLock();

    // Condition variables.
    private Condition not
}
