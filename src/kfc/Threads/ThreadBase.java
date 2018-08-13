package kfc.Threads;

import kfc.Order;
import kfc.food.Beverage.*;
import kfc.food.Burger.*;
import kfc.food.Dessert.*;
import kfc.food.Side.*;
import kfc.food.Food;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Future;

class ThreadBase{

    /**
     * Orders from guests.
     */
    private volatile static LinkedList<Order> orders = new LinkedList<Order>();

    /**
     * Food storage from delivering.
     */
    // Burger
    private volatile static LinkedList<ChickenBurger> chickenBurgers = new LinkedList<ChickenBurger>();
    private volatile static LinkedList<Hamburger> hamburgers = new LinkedList<Hamburger>();
    private volatile static LinkedList<VeggieBurger> veggieBurgers = new LinkedList<VeggieBurger>();

    // Side
    private volatile static LinkedList<Cheese> cheeses = new LinkedList<Cheese>();
    private volatile static LinkedList<ColeSlaw> coleSlaws = new LinkedList<ColeSlaw>();
    private volatile static LinkedList<GreenBeans> greenBeans = new LinkedList<GreenBeans>();

    // Beverage
    private volatile static LinkedList<Coke> cokes = new LinkedList<Coke>();
    private volatile static LinkedList<Milk> milks = new LinkedList<Milk>();
    private volatile static LinkedList<Sprite> sprites = new LinkedList<Sprite>();

    // Dessert
    private volatile static LinkedList<Biscuits> biscuits = new LinkedList<Biscuits>();
    private volatile static LinkedList<Cake> cakes = new LinkedList<Cake>();
    private volatile static LinkedList<Cookies> cookies = new LinkedList<Cookies>();

    // Burger
    private static HashMap<String, LinkedList<?>> burgers = new HashMap<String, LinkedList<?>>();

    // Side
    private static HashMap<String, LinkedList<?>> sides = new HashMap<String, LinkedList<?>>();

    // Beverage
    private static HashMap<String, LinkedList<?>> beverages = new HashMap<String, LinkedList<?>>();

    // Dessert
    private static HashMap<String, LinkedList<?>> desserts = new HashMap<String, LinkedList<?>>();
//
//    private static HashMap<String, HashMap<String, LinkedList>> foodCache =
//            new HashMap<String, HashMap<String, LinkedList>>();

    private Future<Order> currentOrder

    // Application running flag.
    private volatile static boolean running = true;

//    public static HashMap<String, HashMap<String, LinkedList>> getFoodCache() {
//        return foodCache;
//    }


    static LinkedList<Order> getOrders() {
        return orders;
    }

    static LinkedList<ChickenBurger> getChickenBurgers() {
        return chickenBurgers;
    }

    static LinkedList<Hamburger> getHamburgers() {
        return hamburgers;
    }

    static LinkedList<VeggieBurger> getVeggieBurgers() {
        return veggieBurgers;
    }

    static LinkedList<Cheese> getCheeses() {
        return cheeses;
    }

    static LinkedList<ColeSlaw> getColeSlaws() {
        return coleSlaws;
    }

    static LinkedList<GreenBeans> getGreenBeans() {
        return greenBeans;
    }

    static LinkedList<Coke> getCokes() {
        return cokes;
    }

    static LinkedList<Milk> getMilks() {
        return milks;
    }

    static LinkedList<Sprite> getSprites() {
        return sprites;
    }

    static LinkedList<Biscuits> getBiscuits() {
        return biscuits;
    }

    static LinkedList<Cake> getCakes() {
        return cakes;
    }

    static LinkedList<Cookies> getCookies() {
        return cookies;
    }

    public static HashMap<String, LinkedList<?>> getBurgers() {
        return burgers;
    }

    public static HashMap<String, LinkedList<?>> getSides() {
        return sides;
    }

    public static HashMap<String, LinkedList<?>> getBeverages() {
        return beverages;
    }

    public static HashMap<String, LinkedList<?>> getDesserts() {
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
