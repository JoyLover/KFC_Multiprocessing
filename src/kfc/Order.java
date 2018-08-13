package kfc;

import kfc.food.Beverage.*;
import kfc.food.Burger.*;
import kfc.food.Dessert.*;
import kfc.food.Side.*;
import kfc.food.Food;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Order {

    private static final int burgerTypes = 3;
    private static final int sideTypes = 3;
    private static final int beverageTypes = 3;
    private static final int dessertTypes = 3;

    public HashMap<String, Food> foodList = new HashMap<String, Food>();

    public Order () throws Exception {

        Random r = new Random();

        switch (r.nextInt(burgerTypes + 1)) {

            case 1:
                foodList.put("Burger", new ChickenBurger());
                break;

            case 2:
                foodList.put("Burger", new Hamburger());
                break;

            case 3:
                foodList.put("Burger", new VeggieBurger());
                break;

            default:
                foodList.put("Burger", null);
                break;
        }

        switch (r.nextInt(sideTypes + 1)) {

            case 1:
                foodList.put("Side", new Cheese());
                break;

            case 2:
                foodList.put("Side", new ColeSlaw());
                break;

            case 3:
                foodList.put("Side", new GreenBeans());
                break;

            default:
                foodList.put("Side", null);
                break;
        }

        switch (r.nextInt(beverageTypes + 1)) {

            case 1:
                foodList.put("Beverage", new Coke());
                break;

            case 2:
                foodList.put("Beverage", new Milk());
                break;

            case 3:
                foodList.put("Beverage", new Sprite());
                break;

            default:
                foodList.put("Beverage", null);
                break;
        }

        switch (r.nextInt(dessertTypes + 1)) {

            case 1:
                foodList.put("Dessert", new Biscuits());
                break;

            case 2:
                foodList.put("Dessert", new Cake());
                break;

            case 3:
                foodList.put("Dessert", new Cookies());
                break;

            default:
                foodList.put("Dessert", null);
                break;
        }
    }
}
