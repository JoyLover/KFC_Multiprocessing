package kfc.Threads;

import kfc.Order;

import java.util.Random;

/**
 * Order Thread.
 * Automatically generate new order to simulate the customer.
 */
public class OrderThread extends ThreadBase implements Runnable {

    // Unique order ID.
    private int orderId = 0;

    public OrderThread() throws Exception {
    }

    @Override
    public void run() {
        this.orderProvider();
    }

    /**
     * Automatically generate order.
     */
    private void orderProvider () {

        while (isRunning()) {

            orderId++;

            try {
                getOrders().put(new Order(orderId));
            } catch (Exception e) {
                e.printStackTrace();
            }

            try { // Time slot between two customers
                Thread.sleep(3 + new Random().nextInt(2));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
