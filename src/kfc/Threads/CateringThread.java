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

                for (String type : getFoodTypes()) {

                    Object content = order.foodList.get(type);

                    if (content != null) {

                        String[] dump = content.getClass().getName().split("\\.");
                        String foodType = dump[dump.length - 1];

                        getFoodCache().get(type).get(foodType).take();
                    }
                }

                getFontDeskMap().get(order.getId()).put(order);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
