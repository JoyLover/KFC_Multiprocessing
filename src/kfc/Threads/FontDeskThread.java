package kfc.Threads;

import kfc.Order;
import kfc.food.Food;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class FontDeskThread extends ThreadBase implements Runnable{

    private int id;

    public FontDeskThread (int id) {
        this.id = id;
    }

    private void getOrder () {

        while (isRunning()) {

            if (getOrders().size() > 0) {

                Order currentOrder;

                try {
                    currentOrder = getOrders().removeFirst();
                } catch (NoSuchElementException e) {
                    continue;
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
