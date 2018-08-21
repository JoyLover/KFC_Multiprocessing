package kfc.Threads;

import kfc.food.Beverage.*;
import kfc.food.Burger.*;
import kfc.food.Dessert.*;
import kfc.food.Side.*;
import kfc.log.utils.LogOfDeliver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 * Delivery Thread
 * Automatically deliver fresh food to the food storage.
 */
public class DeliveryThread extends ThreadBase implements Runnable{

    // ThreadName to differ threads from each other.
    // 4 threads in total. "Burger", "Side", "Beverage" and "Dessert" thread.
    private String threadName;

    private Logger logger;

    private static HashMap<String, DeliveryThread> methodMap = new HashMap<String, DeliveryThread>();

    private static HashMap<String, DeliveryThread> getMethodMap() {
        return methodMap;
    }

    public DeliveryThread (String threadName) throws Exception {
        super();
        this.threadName = threadName;

        logger = new LogOfDeliver().getLogger();
    }

    @Override
    public void run() {

        storeMethods();

        try {
            if (methodMap.containsKey(this.threadName)) {

                Object obj = methodMap.get(this.threadName);

                // Different thread uses different method to deliver its food.
                // Java reflection mechanism.
                Method methodName = obj.getClass().getDeclaredMethod(this.threadName.toLowerCase() + "Deliver");
                methodName.invoke(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Store four different delivery thread objects to methodMap.
     */
    private void storeMethods () {
        try {
            getMethodMap().put("Burger", new DeliveryThread("Burger"));
            getMethodMap().put("Side", new DeliveryThread("Side"));
            getMethodMap().put("Beverage", new DeliveryThread("Beverage"));
            getMethodMap().put("Dessert", new DeliveryThread("Dessert"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to be called by "Burger" thread to deliver different type of Burgers.
     */
    public void burgerDeliver () {

        while (isRunning() && !Thread.currentThread().isInterrupted()) {

            try {
                getChickenBurgers().put(new ChickenBurger());
                getHamburgers().put(new Hamburger());
                getVeggieBurgers().put(new VeggieBurger());

                logger.info(getLogInfoString());

            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method to be called by "Side" thread to deliver different type of Side.
     */
    public void sideDeliver () {
        while (isRunning() && !Thread.currentThread().isInterrupted()) {

            try {
                getCheeses().put(new Cheese());
                getColeSlaws().put(new ColeSlaw());
                getGreenBeans().put(new GreenBeans());

                logger.info(getLogInfoString());

            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method to be called by "Beverage" thread to deliver different type of Beverage.
     */
    public void beverageDeliver () {
        while (isRunning()) {

            try {
                getCokes().put(new Coke());
                getMilks().put(new Milk());
                getSprites().put(new Sprite());

                logger.info(getLogInfoString());

            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method to be called by "Dessert" thread to deliver different type of Desserts.
     */
    public void dessertDeliver () {
        while (isRunning()) {

            try {
                getBiscuits().put(new Biscuits());
                getCakes().put(new Cake());
                getCookies().put(new Cookies());

                logger.info(getLogInfoString());

            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getThreadName() {
        return threadName;
    }

    /**
     * Get log content.
     * @return String which will be used to log.
     */
    private String getLogInfoString () {
        return
                "\n### Deliver Thread " + threadName + " :" +
                "\n> One Cheese, ColeSlaw and GreenBean are added to food cache separately.\n" +
                "\n<table>" +
                "\n<tr><th>Food<th>ChickenBurger<th>Hamburger<th>VeggieBurger<th>" +
                        "ColeSlaw<th>GreenBean<th>Coke<th>Milk<th>Sprite<th>" +
                        "Biscuit<th>Cake<th>Cookies<th>Dessert<tr>\n" +
                "\n<tr><td>Remain<td>" + getChickenBurgers().size() + "<td>" +
                      getHamburgers().size() + "<td>" +
                      getVeggieBurgers().size() + "<td>" +
                      getCheeses().size() + "<td>" +
                      getColeSlaws().size() + "<td>" +
                      getGreenBeans().size() + "<td>" +
                      getCokes().size() + "<td>" +
                      getMilks().size() + "<td>" +
                      getSprites().size() + "<td>" +
                      getBiscuits().size() + "<td>" +
                      getCakes().size() + "<td>" +
                      getCookies().size() +
                "</table>" +
                "\n***\n***\n\n";
    }
}
