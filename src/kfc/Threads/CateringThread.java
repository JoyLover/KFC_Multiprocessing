package kfc.Threads;

import kfc.Order;
import kfc.log.utils.*;

import java.util.concurrent.BlockingQueue;
import java.util.logging.*;

/**
 * Catering thread.
 * Dealing with the order from font desk. Pack the food listed on the order and send it to
 * the same font desk from which received the order.
 */
public class CateringThread extends ThreadBase implements Runnable {

    // Thread id to differ from each other. (Two catering threads in total.)
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
     * @param id To differentiate CateringThreads.
     * @param queue BlockingQueue from Main thread. To make sure FontDeskThread and CateringThread
     *              share the same order queue.
     * @throws Exception
     */
    public CateringThread (int id, BlockingQueue<Order> queue) throws Exception {
        super();
        this.id = id;

        this.orderQueue = queue;
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {

            try {
                // Get the order from Order Generator Thread (OrderThread).
                Order order = orderQueue.take();

                // Choose which Logger to log based on the order id.
                // Order id was changed to be identical to the FontDeskThread id
                // which process it.
                switch (order.getId()) {
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

                logger.info("\n>> ### *From Cater " + id + " : The food of order " +
                        order.getOrderId() + " is on prepare.*\n");

                for (String type : getFoodTypes()) {

                    Object content = order.foodList.get(type);

                    // If the content null, we know that the customer didn't order this kind of food,
                    // which means the randomly generated integer is 0.
                    // (1, 2, 3 stands for different kind of food separately.)
                    if (content != null) {

                        // Get the food type name.
                        String[] dump = content.getClass().getName().split("\\.");
                        String foodType = dump[dump.length - 1];

                        // Take the ordered food from food storage.
                        getFoodCache().get(type).get(foodType).take();

                        logger.info("\n>>> *From Cater " + id + " : One " +
                                foodType + " is consumed.*\n");
                    }
                }

                logger.info("\n>> ### *From Cater " + id +
                        " : The food is prepared and will be sent to font desk " +
                        order.getId() + ".*\n");

                // Send this packed food to font desk to serve.
                getFontDeskMap().get(order.getId()).put(order);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int getId() {
        return id;
    }
}
