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

    volatile static LinkedList<Order> orders = new LinkedList<Order>();

    // Burger
    volatile static LinkedList<ChickenBurger> chickenBurgers = new LinkedList<ChickenBurger>();
    volatile static LinkedList<Hamburger> hamburgers = new LinkedList<Hamburger>();
    volatile static LinkedList<VeggieBurger> veggieBurgers = new LinkedList<VeggieBurger>();

    // Side
    volatile static LinkedList<Cheese> cheeses = new LinkedList<Cheese>();
    volatile static LinkedList<ColeSlaw> coleSlaws = new LinkedList<ColeSlaw>();
    volatile static LinkedList<GreenBeans> greenBeans = new LinkedList<GreenBeans>();

    // Beverage
    volatile static LinkedList<Coke> cokes = new LinkedList<Coke>();
    volatile static LinkedList<Milk> milks = new LinkedList<Milk>();
    volatile static LinkedList<Sprite> sprites = new LinkedList<Sprite>();

    // Dessert
    volatile static LinkedList<Biscuits> biscuits = new LinkedList<Biscuits>();
    volatile static LinkedList<Cake> cakes = new LinkedList<Cake>();
    volatile static LinkedList<Cookies> cookies = new LinkedList<Cookies>();

    // Burger
    static HashMap<String, LinkedList<?>> burgers = new HashMap<String, LinkedList<?>>() {
        {
            burgers.put("ChickenBurger", chickenBurgers);
            burgers.put("Hamburger", hamburgers);
            burgers.put("VeggieBurger", veggieBurgers);
        }
    };

    // Side
    static HashMap<String, LinkedList<?>> sides = new HashMap<String, LinkedList<?>>() {
        {
            sides.put("Cheese", cheeses);
            sides.put("ColeSlaw", coleSlaws);
            sides.put("GreenBeans", greenBeans);
        }
    };

    // Beverage
    static HashMap<String, LinkedList<?>> beverages = new HashMap<String, LinkedList<?>>() {
        {
            beverages.put("Coke", cokes);
            beverages.put("Milk", milks);
            beverages.put("Sprite", sprites);
        }
    };

    // Dessert
    static HashMap<String, LinkedList<?>> desserts = new HashMap<String, LinkedList<?>>() {
        {
            desserts.put("Biscuits", biscuits);
            desserts.put("Cake", cakes);
            desserts.put("Cookies", cookies);
        }
    };

    static HashMap<String, HashMap<String, LinkedList<?>>> foodCache = new HashMap<>() {
        {

        }
    };

    volatile static boolean running = true;
}
