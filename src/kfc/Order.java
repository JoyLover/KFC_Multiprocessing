package kfc;

import kfc.food.Beverage.*;
import kfc.food.Burger.*;
import kfc.food.Dessert.*;
import kfc.food.Side.*;
import kfc.food.Food;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Order {

    static final int burgerTypes = 3;
    static final int sideTypes = 3;
    static final int beverageTypes = 3;
    static final int dessertTypes = 3;

    public LinkedList<Food> foodList = new LinkedList<Food>();

    public Order () {

        Random r = new Random();

        // The order of these switches cannot be changed.
        switch (r.nextInt(burgerTypes + 1)) {

            case 1:
                foodList.add(new ChickenBurger());
                break;

            case 2:
                foodList.add(new Hamburger());
                break;

            case 3:
                foodList.add(new VeggieBurger());
                break;

            default:
                foodList.add(null);
                break;
        }

        switch (r.nextInt(sideTypes + 1)) {

            case 1:
                foodList.add(new Cheese());
                break;

            case 2:
                foodList.add(new ColeSlaw());
                break;

            case 3:
                foodList.add(new GreenBeans());
                break;

            default:
                foodList.add(null);
                break;
        }

        switch (r.nextInt(beverageTypes + 1)) {

            case 1:
                foodList.add(new Coke());
                break;

            case 2:
                foodList.add(new Milk());
                break;

            case 3:
                foodList.add(new Sprite());
                break;

            default:
                foodList.add(null);
                break;
        }

        switch (r.nextInt(dessertTypes + 1)) {

            case 1:
                foodList.add(new Biscuits());
                break;

            case 2:
                foodList.add(new Cake());
                break;

            case 3:
                foodList.add(new Cookies());
                break;

            default:
                foodList.add(null);
                break;
        }
    }
}
