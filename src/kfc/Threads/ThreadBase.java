package kfc.Threads;

import kfc.Order;
import kfc.food.Beverage.*;
import kfc.food.Burger.*;
import kfc.food.Dessert.*;
import kfc.food.Side.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

class ThreadBase{

    /**
     * Orders from guests.
     */
    private static BlockingQueue<Order> orders = new LinkedBlockingDeque<>();

    /**
     * Food storage from delivering.
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
//
//    private static HashMap<String, HashMap<String, LinkedList>> foodCache =
//            new HashMap<String, HashMap<String, LinkedList>>();

//    private Future<Order> currentOrder

    // Application running flag.
    private volatile static boolean running = true;

//    public static HashMap<String, HashMap<String, LinkedList>> getFoodCache() {
//        return foodCache;
//    }


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

    public static HashMap<String, BlockingQueue<?>> getBurgers() {
        return burgers;
    }

    public static HashMap<String, BlockingQueue<?>> getSides() {
        return sides;
    }

    public static HashMap<String, BlockingQueue<?>> getBeverages() {
        return beverages;
    }

    public static HashMap<String, BlockingQueue<?>> getDesserts() {
        return desserts;
    }

    static boolean isRunning() {
        return running;
    }

    static void setRunning(boolean running) {
        ThreadBase.running = running;
    }

    ThreadBase () {

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

//            foodCache.put("Burger", burgers);
//            foodCache.put("Side", sides);
//            foodCache.put("Beverage", beverages);
//            foodCache.put("Dessert", desserts);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
