package kfc.Threads;

import kfc.Order;

import java.util.Random;

public class OrderThread extends ThreadBase implements Runnable{

    @Override
    public void run() {
        this.orderProvider();
    }

    private void orderProvider () {

        while (isRunning()) {

            try {
                getOrders().put(new Order());
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
