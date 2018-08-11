package kfc.Threads;

public class DeliveryThread extends ThreadBase implements Runnable{

    private int id;

    public DeliveryThread (int id) {
        this.id = id;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
