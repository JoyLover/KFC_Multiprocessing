package kfc.Threads;

import kfc.Order;
import kfc.food.Beverage.*;
import kfc.food.Burger.*;
import kfc.food.Dessert.*;
import kfc.food.Side.*;
import kfc.food.Food;

import java.util.HashMap;
import java.util.LinkedList;

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

//    // Burger
//    static HashMap<String, LinkedList<Burger>> burgers = new HashMap<String, LinkedList<Burger>>();
//
//    // Side
//    static HashMap<String, LinkedList<Side>> sides = new HashMap<String, LinkedList<Side>>();
//
//    // Beverage
//    static HashMap<String, LinkedList<Beverage>> beverages = new HashMap<String, LinkedList<Beverage>>();
//
//    // Dessert
//    static HashMap<String, LinkedList<Dessert>> desserts = new HashMap<String, LinkedList<Dessert>>();
//
//    private static HashMap<String, HashMap<String, LinkedList>> foodCache =
//            new HashMap<String, HashMap<String, LinkedList>>();

    // Application running flag.
    private volatile static boolean running = true;

//    public static HashMap<String, HashMap<String, LinkedList>> getFoodCache() {
//        return foodCache;
//    }


    public static LinkedList<Order> getOrders() {
        return orders;
    }

    public static LinkedList<ChickenBurger> getChickenBurgers() {
        return chickenBurgers;
    }

    public static LinkedList<Hamburger> getHamburgers() {
        return hamburgers;
    }

    public static LinkedList<VeggieBurger> getVeggieBurgers() {
        return veggieBurgers;
    }

    public static LinkedList<Cheese> getCheeses() {
        return cheeses;
    }

    public static LinkedList<ColeSlaw> getColeSlaws() {
        return coleSlaws;
    }

    public static LinkedList<GreenBeans> getGreenBeans() {
        return greenBeans;
    }

    public static LinkedList<Coke> getCokes() {
        return cokes;
    }

    public static LinkedList<Milk> getMilks() {
        return milks;
    }

    public static LinkedList<Sprite> getSprites() {
        return sprites;
    }

    public static LinkedList<Biscuits> getBiscuits() {
        return biscuits;
    }

    public static LinkedList<Cake> getCakes() {
        return cakes;
    }

    public static LinkedList<Cookies> getCookies() {
        return cookies;
    }

    public static boolean isRunning() {
        return running;
    }

    public static void setRunning(boolean running) {
        ThreadBase.running = running;
    }

    public ThreadBase () {

//        try {
//            burgers.put("ChickenBurger", chickenBurgers);
//            burgers.put("Hamburger", hamburgers);
//            burgers.put("VeggieBurger", veggieBurgers);
//
//            sides.put("Cheese", cheeses);
//            sides.put("ColeSlaw", coleSlaws);
//            sides.put("GreenBeans", greenBeans);
//
//            beverages.put("Coke", cokes);
//            beverages.put("Milk", milks);
//            beverages.put("Sprite", sprites);
//
//            desserts.put("Biscuits", biscuits);
//            desserts.put("Cake", cakes);
//            desserts.put("Cookies", cookies);
//
//            foodCache.put("Burger", burgers);
//            foodCache.put("Side", sides);
//            foodCache.put("Beverage", beverages);
//            foodCache.put("Dessert", desserts);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
