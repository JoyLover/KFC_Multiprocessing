package kfc.Threads;

import kfc.Order;
import kfc.food.Beverage.*;
import kfc.food.Burger.*;
import kfc.food.Dessert.*;
import kfc.food.Side.*;
import kfc.log.utils.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Thread Base
 * The base of all the kfc threads, containing some variable for all threads to share.
 */
public class ThreadBase{

    /**
     * Orders from guests.
     */
    private static BlockingQueue<Order> orders = new LinkedBlockingDeque<>(200);

    /**
     * Food storage from delivery.
     */
    // Burger
    private static BlockingQueue<ChickenBurger> chickenBurgers = new LinkedBlockingDeque<>();
    private static BlockingQueue<Hamburger> hamburgers = new LinkedBlockingDeque<>();
    private static BlockingQueue<VeggieBurger> veggieBurgers = new LinkedBlockingDeque<>();

    // Side
    private static BlockingQueue<Cheese> cheeses = new LinkedBlockingDeque<>();
    private static BlockingQueue<ColeSlaw> coleSlaws = new LinkedBlockingDeque<>();
    private static BlockingQueue<GreenBeans> greenBeans = new LinkedBlockingDeque<>();

    // Beverage
    private static BlockingQueue<Coke> cokes = new LinkedBlockingDeque<>();
    private static BlockingQueue<Milk> milks = new LinkedBlockingDeque<>();
    private static BlockingQueue<Sprite> sprites = new LinkedBlockingDeque<>();

    // Dessert
    private static BlockingQueue<Biscuits> biscuits = new LinkedBlockingDeque<>();
    private static BlockingQueue<Cake> cakes = new LinkedBlockingDeque<>();
    private static BlockingQueue<Cookies> cookies = new LinkedBlockingDeque<>();

    // Burger
    private static HashMap<String, BlockingQueue<?>> burgers = new HashMap<String, BlockingQueue<?>>();

    // Side
    private static HashMap<String, BlockingQueue<?>> sides = new HashMap<String, BlockingQueue<?>>();

    // Beverage
    private static HashMap<String, BlockingQueue<?>> beverages = new HashMap<String, BlockingQueue<?>>();

    // Dessert
    private static HashMap<String, BlockingQueue<?>> desserts = new HashMap<String, BlockingQueue<?>>();

    // Food cache that store all types of food together, making it easy to access each
    // kind of food.
    private static HashMap<String, HashMap<String, BlockingQueue<?>>> foodCache = new HashMap<>();

    private static String[] foodTypes = {"Burger", "Side", "Beverage", "Dessert"};

    // 4 BlockingQueues for 4 FontDeskThreads to store their processed orders, and
    // waiting for taking by the CateringThreads.
    private static BlockingQueue<Order> fontDeskOrder1 = new ArrayBlockingQueue<>(1);
    private static BlockingQueue<Order> fontDeskOrder2 = new ArrayBlockingQueue<>(1);
    private static BlockingQueue<Order> fontDeskOrder3 = new ArrayBlockingQueue<>(1);
    private static BlockingQueue<Order> fontDeskOrder4 = new ArrayBlockingQueue<>(1);

    // HashMap to map thread id to the order BlockingQueue associated with the id.
    private static HashMap<Integer, BlockingQueue<Order>> fontDeskMap = new HashMap<>();

    // Flag to stop all the threads. Default to be true.
    private volatile static boolean running = true;


    static BlockingQueue<Order> getOrders() {
        return orders;
    }

    static BlockingQueue<ChickenBurger> getChickenBurgers() {
        return chickenBurgers;
    }
    static BlockingQueue<Hamburger> getHamburgers() {
        return hamburgers;
    }
    static BlockingQueue<VeggieBurger> getVeggieBurgers() {
        return veggieBurgers;
    }

    static BlockingQueue<Cheese> getCheeses() {
        return cheeses;
    }
    static BlockingQueue<ColeSlaw> getColeSlaws() {
        return coleSlaws;
    }
    static BlockingQueue<GreenBeans> getGreenBeans() {
        return greenBeans;
    }

    static BlockingQueue<Coke> getCokes() {
        return cokes;
    }
    static BlockingQueue<Milk> getMilks() {
        return milks;
    }
    static BlockingQueue<Sprite> getSprites() {
        return sprites;
    }

    static BlockingQueue<Biscuits> getBiscuits() {
        return biscuits;
    }
    static BlockingQueue<Cake> getCakes() {
        return cakes;
    }
    static BlockingQueue<Cookies> getCookies() {
        return cookies;
    }

    static HashMap<String, BlockingQueue<?>> getBurgers() {
        return burgers;
    }
    static HashMap<String, BlockingQueue<?>> getSides() {
        return sides;
    }
    static HashMap<String, BlockingQueue<?>> getBeverages() {
        return beverages;
    }
    static HashMap<String, BlockingQueue<?>> getDesserts() {
        return desserts;
    }

    static HashMap<String, HashMap<String, BlockingQueue<?>>> getFoodCache() {
        return foodCache;
    }

    static String[] getFoodTypes() {
        return foodTypes;
    }

    static HashMap<Integer, BlockingQueue<Order>> getFontDeskMap() {
        return fontDeskMap;
    }

    static boolean isRunning() {
        return running;
    }

    public static void setRunning(boolean running) {
        ThreadBase.running = running;
    }

    public ThreadBase () throws Exception {

        try {
            burgers.put("ChickenBurger", chickenBurgers);
            burgers.put("Hamburger", hamburgers);
            burgers.put("VeggieBurger", veggieBurgers);

            sides.put("Cheese", cheeses);
            sides.put("ColeSlaw", coleSlaws);
            sides.put("GreenBeans", greenBeans);

            beverages.put("Coke", cokes);
            beverages.put("Milk", milks);
            beverages.put("Sprite", sprites);

            desserts.put("Biscuits", biscuits);
            desserts.put("Cake", cakes);
            desserts.put("Cookies", cookies);

            foodCache.put("Burger", burgers);
            foodCache.put("Side", sides);
            foodCache.put("Beverage", beverages);
            foodCache.put("Dessert", desserts);

            fontDeskMap.put(1, fontDeskOrder1);
            fontDeskMap.put(2, fontDeskOrder2);
            fontDeskMap.put(3, fontDeskOrder3);
            fontDeskMap.put(4, fontDeskOrder4);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
