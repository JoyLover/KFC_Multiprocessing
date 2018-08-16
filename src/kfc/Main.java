package kfc;

import kfc.Threads.CateringThread;
import kfc.Threads.DeliveryThread;
import kfc.Threads.FontDeskThread;
import kfc.Threads.OrderThread;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {

    public static void main (String args[]) {

        ExecutorService orderThread = Executors.newCachedThreadPool();
        ExecutorService deliveryThreads = Executors.newFixedThreadPool(4);
        ExecutorService fontDeskThreads = Executors.newFixedThreadPool(4);
        ExecutorService cateringThreads = Executors.newFixedThreadPool(2);

        BlockingQueue<Order> orderQueue = new LinkedBlockingDeque<>();

        orderThread.submit(new OrderThread());

        String[] foodTypes = {"Burger", "Side", "Beverage", "Dessert"};

        for (String foodType : foodTypes) {
            deliveryThreads.submit(new DeliveryThread(foodType));
        }

        for (int i = 0; i < 4; i++) {
            fontDeskThreads.submit(new FontDeskThread(i, orderQueue));
        }

        for (int i = 0; i < 2; i++) {
            cateringThreads.submit(new CateringThread(i, orderQueue));
        }

        fontDeskThreads.shutdown();
        deliveryThreads.shutdown();
        cateringThreads.shutdown();
    }
}
