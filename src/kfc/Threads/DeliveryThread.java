package kfc.Threads;

import kfc.food.Beverage.*;
import kfc.food.Burger.*;
import kfc.food.Dessert.*;
import kfc.food.Side.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class DeliveryThread extends ThreadBase implements Runnable{

    private String threadName;

    private static HashMap<String, DeliveryThread> methodMap = new HashMap<String, DeliveryThread>();

    private static HashMap<String, DeliveryThread> getMethodMap() {
        return methodMap;
    }

    public DeliveryThread (String threadName) throws Exception {
        super();
        this.threadName = threadName;
    }

    @Override
    public void run() {

        storeMethods();

        try {
            if (methodMap.containsKey(this.threadName)) {

                Object obj = methodMap.get(this.threadName);

                Method methodName = obj.getClass().getDeclaredMethod(this.threadName.toLowerCase() + "Deliver");
                methodName.invoke(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void storeMethods () {
        try {
            getMethodMap().put("Burger", new DeliveryThread("Burger"));
            getMethodMap().put("Side", new DeliveryThread("side"));
            getMethodMap().put("Beverage", new DeliveryThread("Beverage"));
            getMethodMap().put("Dessert", new DeliveryThread("Dessert"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void burgerDeliver () {

        while (isRunning()) {

            try {
                getChickenBurgers().put(new ChickenBurger());
                getHamburgers().put(new Hamburger());
                getVeggieBurgers().put(new VeggieBurger());

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

    public void sideDeliver () {
        while (isRunning()) {

            try {
                getCheeses().put(new Cheese());
                getColeSlaws().put(new ColeSlaw());
                getGreenBeans().put(new GreenBeans());

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

    public void beverageDeliver () {
        while (isRunning()) {

            try {
                getCokes().put(new Coke());
                getMilks().put(new Milk());
                getSprites().put(new Sprite());

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

    public void dessertDeliver () {
        while (isRunning()) {

            try {
                getBiscuits().put(new Biscuits());
                getCakes().put(new Cake());
                getCookies().put(new Cookies());

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
}
