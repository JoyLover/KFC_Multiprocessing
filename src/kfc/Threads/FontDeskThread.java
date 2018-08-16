package kfc.Threads;

import kfc.Order;
import kfc.food.Food;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;

public class FontDeskThread extends ThreadBase implements Runnable{

    private int id;

    private BlockingQueue<Order> orderQueue;

    public FontDeskThread (int id, BlockingQueue<Order> queue) {
        this.id = id;
        this.orderQueue = queue;
    }

    private void getOrder () {

        while (isRunning() && !Thread.currentThread().isInterrupted()) {

            if (getOrders().size() > 0) {

                Order currentOrder;

                try {
                    currentOrder = getOrders().take();
                    orderQueue.put(currentOrder);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void run() {

        getOrder();
    }

    public int getId() {
        return id;
    }
}
