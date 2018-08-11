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

    public void getOrder () {

        while (running) {
            if (orders.size() > 0) {

                Order currentOrder;
                try {
                    currentOrder = orders.removeFirst();
                } catch (NoSuchElementException e) {
                    continue;
                }

                int i = 0;
                while (currentOrder.foodList.size() != 0) {

                    Food food = currentOrder.foodList.removeFirst();
                    i++;

                    if (food != null) {
                        switch (i) {
                            case 1:

                        }
                    }
                }
            }
        }
    }

    @Override
    public void run() {

        getOrder();
    }


}
