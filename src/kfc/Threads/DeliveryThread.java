package kfc.Threads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class DeliveryThread extends ThreadBase implements Runnable{

    private String threadName;

    private static HashMap<String, Method> methodMap = new HashMap<String, Method>() {
        {
            try {
                methodMap.put("Burger", new DeliveryThread("Burger").getClass().getMethod("burgerDeliver"));
                methodMap.put("Side", new DeliveryThread("side").getClass().getMethod("sideDeliver"));
                methodMap.put("Beverage", new DeliveryThread("Beverage").getClass().getMethod("beverageDeliver"));
                methodMap.put("Dessert", new DeliveryThread("Dessert").getClass().getMethod("dessertDeliver"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public DeliveryThread (String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {

        try {
            if (methodMap.containsKey(this.threadName)) {

                Method methodName = methodMap.get(this.threadName);
                methodName.invoke(DeliveryThread.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void burgerDeliver () {

    }

    private void sideDeliver () {

    }

    private void beverageDeliver () {

    }

    private void dessertDeliver () {

    }
}
