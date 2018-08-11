package kfc;

import kfc.Threads.CateringThread;
import kfc.Threads.DeliveryThread;
import kfc.Threads.FontDeskThread;
import kfc.Threads.OrderThread;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main (String args[]) {

        Thread orderThread = new Thread(new OrderThread());

        ExecutorService deliveryThreads = Executors.newFixedThreadPool(4);
        ExecutorService fontDeskThreads = Executors.newFixedThreadPool(4);
        ExecutorService cateringThreads = Executors.newFixedThreadPool(2);

        orderThread.start();

        String[] foodTypes = {"Burger", "Side", "Beverage", "Dessert"};

        for (String foodType : foodTypes) {
            deliveryThreads.submit(new DeliveryThread(foodType));
        }

        for (int i = 0; i < 4; i++) {
            fontDeskThreads.submit(new FontDeskThread(i));
        }

        for (int i = 0; i < 2; i++) {
            cateringThreads.submit(new CateringThread(i));
        }

        fontDeskThreads.shutdown();
        deliveryThreads.shutdown();
        cateringThreads.shutdown();
    }
}
