package kfc.Threads;

import kfc.Order;
import kfc.log.utils.*;

import java.util.concurrent.BlockingQueue;
import java.util.logging.*;

/**
 * Catering thread.
 * Dealing with the order from font desk. Pack the food of the order and send to
 * the same font desk from which receive the order.
 */
public class CateringThread extends ThreadBase implements Runnable {

    // Thread id to differ from each other. (Two catering threads in total.)
    private int id;

    //
    private BlockingQueue<Order> orderQueue;
    private Logger logger;

    public CateringThread (int id, BlockingQueue<Order> queue) throws Exception {
        super();
        this.id = id;
        this.orderQueue = queue;
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {

            try {
                Order order = orderQueue.take();

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

                    if (content != null) {

                        String[] dump = content.getClass().getName().split("\\.");
                        String foodType = dump[dump.length - 1];

                        getFoodCache().get(type).get(foodType).take();

                        logger.info("\n>>> *From Cater " + id + " : One " +
                                foodType + " is consumed.*\n");
                    }
                }

                logger.info("\n>> ### *From Cater " + id +
                        " : The food is prepared and will be sent to font desk " +
                        order.getId() + ".*\n");

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
