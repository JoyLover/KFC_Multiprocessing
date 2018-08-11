package kfc.Threads;

public class CateringThread extends ThreadBase implements Runnable {

    private int id;

    public CateringThread (int id) {
        this.id = id;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
