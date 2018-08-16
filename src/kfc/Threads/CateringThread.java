package kfc.Threads;

import kfc.Order;

import java.util.concurrent.BlockingQueue;

public class CateringThread extends ThreadBase implements Runnable {

    private int id;

    private BlockingQueue<Order> orderQueue;

    public CateringThread (int id, BlockingQueue<Order> queue) {
        this.id = id;
        this.orderQueue = queue;
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {

            try {
                Order order = orderQueue.take();



            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
