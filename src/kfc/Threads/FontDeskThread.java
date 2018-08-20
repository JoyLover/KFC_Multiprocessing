package kfc.Threads;

import kfc.Order;
import kfc.food.Food;
import kfc.log.utils.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.logging.*;

public class FontDeskThread extends ThreadBase implements Runnable{

    private int id;

    private BlockingQueue<Order> orderQueue;
    private Logger logger;

    public FontDeskThread (int id, BlockingQueue<Order> queue) throws Exception{
        this.id = id;
        this.orderQueue = queue;

        switch (id) {
            case 1:
                logger = new LogOfFontDesk1().getLogger();
                break;
            case 2:
                logger = new LogOfFontDesk2().getLogger();
                break;
            case 3:
                logger = new LogOfFontDesk3().getLogger();
                break;
            case 4:
                logger = new LogOfFontDesk4().getLogger();
                break;

            default:
                System.out.println("Something goes wrong.");
        }
    }

    private void getOrder () throws Exception {

        while (isRunning() && !Thread.currentThread().isInterrupted()) {

            if (getOrders().size() > 0) {

                Order currentOrder;

                currentOrder = getOrders().take();

                String logInfo1 = "\n> ## Font Desk " + id + " :\n>> ### Get oder (ORDER ID : "
                        + currentOrder.getOrderId() + ") from customer. \n"
                        + ">>> ### Waiting for payment. \n"
                        + ">>> ### **Total : " + currentOrder.getPrice() + "**"
                        + "\n>>> **Food list : " + currentOrder.getFoodNames().trim() + "**\n"
                        + "\n>>> **Calorie : " + currentOrder.getCalorie() + "**\n";
                logger.info(logInfo1);

                currentOrder.setId(this.id);

                Thread.sleep(1000);

                String logInfo2 = "\n>>> ### Order is paid. \n";
                logger.info(logInfo2);

                String logInfo3 = "\n>> ### Order will be sent to kitchen for prepare.\n";
                logger.info(logInfo3);

                orderQueue.put(currentOrder);

                getFontDeskMap().get(this.id).take();

                String logInfo4 = "\n>> ### Food is ready to serve. \n \n***\n***\n";
                logger.info(logInfo4);
            }
        }
    }

    @Override
    public void run() {

        try {
            getOrder();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }
}
