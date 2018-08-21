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

    // Order price
    private float price = 0.0f;
    // Food names of ordered food.
    private String foodNames = "";

    private float calorie = 0.0f;

    // ID which will be assigned to be identical to FontDeskThread id.
    private int id = 0;
    // Unique order ID of itself. To differentiate orders.
    private int orderId = 0;

    public HashMap<String, Food> foodList = new HashMap<String, Food>();

    public int getOrderId() {
        return orderId;
    }

    public Order (int orderId) throws Exception {

        this.orderId = orderId;

        Random r = new Random();
        int r1, r2, r3, r4;

        do {
            r1 = r.nextInt(burgerTypes + 1);
            r2 = r.nextInt(sideTypes + 1);
            r3 = r.nextInt(beverageTypes + 1);
            r4 = r.nextInt(dessertTypes + 1);
        } while (r1 == 0 && r2 == 0 && r3 == 0 && r4 == 0);

        switch (r1) {

            case 1:
                ChickenBurger dump1 = new ChickenBurger();
                foodList.put("Burger", dump1);
                price += dump1.getPrice();
                foodNames += dump1.getName() + " ";
                calorie += dump1.getCalorie();
                break;

            case 2:
                Hamburger dump2 = new Hamburger();
                foodList.put("Burger", dump2);
                price += dump2.getPrice();
                foodNames += dump2.getName() + " ";
                calorie += dump2.getCalorie();
                break;

            case 3:
                VeggieBurger dump3 = new VeggieBurger();
                foodList.put("Burger", dump3);
                price += dump3.getPrice();
                foodNames += dump3.getName() + " ";
                calorie += dump3.getCalorie();
                break;

            default:
                foodList.put("Burger", null);
                break;
        }

        switch (r2) {

            case 1:
                Cheese dump1 = new Cheese();
                foodList.put("Side", dump1);
                price += dump1.getPrice();
                foodNames += dump1.getName() + " ";
                calorie += dump1.getCalorie();
                break;

            case 2:
                ColeSlaw dump2 = new ColeSlaw();
                foodList.put("Side", dump2);
                price += dump2.getPrice();
                foodNames += dump2.getName() + " ";
                calorie += dump2.getCalorie();
                break;

            case 3:
                GreenBeans dump3 = new GreenBeans();
                foodList.put("Side", dump3);
                price += dump3.getPrice();
                foodNames += dump3.getName() + " ";
                calorie += dump3.getCalorie();
                break;

            default:
                foodList.put("Side", null);
                break;
        }

        switch (r3) {

            case 1:
                Coke dump1 = new Coke();
                foodList.put("Beverage", dump1);
                price += dump1.getPrice();
                foodNames += dump1.getName() + " ";
                calorie += dump1.getCalorie();
                break;

            case 2:
                Milk dump2 = new Milk();
                foodList.put("Beverage", dump2);
                price += dump2.getPrice();
                foodNames += dump2.getName() + " ";
                calorie += dump2.getCalorie();
                break;

            case 3:
                Sprite dump3 = new Sprite();
                foodList.put("Beverage", dump3);
                price += dump3.getPrice();
                foodNames += dump3.getName() + " ";
                calorie += dump3.getCalorie();
                break;

            default:
                foodList.put("Beverage", null);
                break;
        }

        switch (r4) {

            case 1:
                Biscuits dump1 = new Biscuits();
                foodList.put("Dessert", dump1);
                price += dump1.getPrice();
                foodNames += dump1.getName();
                calorie += dump1.getCalorie();
                break;

            case 2:
                Cake dump2 = new Cake();
                foodList.put("Dessert", dump2);
                price += dump2.getPrice();
                foodNames += dump2.getName();
                calorie += dump2.getCalorie();
                break;

            case 3:
                Cookies dump3 = new Cookies();
                foodList.put("Dessert", dump3);
                price += dump3.getPrice();
                foodNames += dump3.getName();
                calorie += dump3.getCalorie();
                break;

            default:
                foodList.put("Dessert", null);
                break;
        }
    }

    public float getPrice() {
        return price;
    }

    public String getFoodNames() {
        return foodNames;
    }

    public float getCalorie() {
        return calorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
