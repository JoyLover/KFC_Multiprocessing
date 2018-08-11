package kfc.Threads;

import kfc.Order;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class FontDeskThread extends ThreadBase implements Runnable{

    private int id;

    public FontDeskThread (int id) {
        this.id = id;
    }

    public void getOrder () {

        while (true) {

            if (orders.size() > 0) {

                Order currentOrder = orders.removeFirst();
            }

        }
    }

    @Override
    public void run() {

        orders.
    }


}
