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

/**
 * Font Desk Thread.
 * Get order from customer (OrderThread), send the order to CateringThread for prepare and then
 * get packed food CateringThread.
 */
public class FontDeskThread extends ThreadBase implements Runnable{

    // Thread id to differ threads from each other. 4 threads in total.
    private int id;

    /**
     * Order queue.
     * The connection between FontDeskThread and CateringThread.
     * Orders are put into the queue by all FontDeskThreads and
     * then the orders will be taken by CateringThread one by one in time order.
     */
    private BlockingQueue<Order> orderQueue;

    private Logger logger;

    /**
     *
     * @param id To differentiate FontDeskThreads.
     * @param queue BlockingQueue from Main thread. To make sure FontDeskThread and CateringThread
     *              share the same order queue.
     * @throws Exception
     */
    public FontDeskThread (int id, BlockingQueue<Order> queue) throws Exception{
        this.id = id;
        this.orderQueue = queue;

        // Choose which Logger to log based on the thread id.
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

                // Get order from order generator (OrderThread).
                currentOrder = getOrders().take();

                String logInfo1 = "\n> ## Font Desk " + id + " :\n>> ### Get oder (ORDER ID : "
                        + currentOrder.getOrderId() + ") from customer. \n"
                        + ">>> ### Waiting for payment. \n"
                        + ">>> ### **Total : " + currentOrder.getPrice() + "**"
                        + "\n>>> **Food list : " + currentOrder.getFoodNames().trim() + "**\n"
                        + "\n>>> **Calorie : " + currentOrder.getCalorie() + "**\n";
                logger.info(logInfo1);

                // Set the order to be identical to the thread id. It will be used by
                // CateringThread to determine to which font desk it should give the packed food.
                currentOrder.setId(this.id);

                Thread.sleep(1000);

                String logInfo2 = "\n>>> ### Order is paid. \n";
                logger.info(logInfo2);

                String logInfo3 = "\n>> ### Order will be sent to kitchen for prepare.\n";
                logger.info(logInfo3);

                // Send the order to orderQueue for CateringThread to take.
                orderQueue.put(currentOrder);

                // Take the packed food.
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
