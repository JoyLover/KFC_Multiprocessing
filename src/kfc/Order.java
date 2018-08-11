package kfc;

import kfc.food.Beverage.Coke;
import kfc.food.Beverage.Milk;
import kfc.food.Beverage.Sprite;
import kfc.food.Burger.ChickenBurger;
import kfc.food.Burger.Hamburger;
import kfc.food.Burger.VeggieBurger;
import kfc.food.Dessert.Biscuits;
import kfc.food.Dessert.Cake;
import kfc.food.Dessert.Cookies;
import kfc.food.Food;
import kfc.food.Side.Cheese;
import kfc.food.Side.ColeSlaw;
import kfc.food.Side.GreenBeans;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Order {

    static final int burgerTypes = 3;
    static final int sideTypes = 3;
    static final int beverageTypes = 3;
    static final int dessertTypes = 3;

    public List<Food> foodList = new LinkedList<>();

    public Order () {

        Random r = new Random();

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
                break;
        }
    }
}
