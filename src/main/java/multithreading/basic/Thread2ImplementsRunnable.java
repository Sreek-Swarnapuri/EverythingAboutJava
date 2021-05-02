package multithreading.basic;

public class Thread2ImplementsRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Running Thread2 at " + i);
        }
    }
}
