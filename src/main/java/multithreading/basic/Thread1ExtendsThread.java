package multithreading.basic;

public class Thread1ExtendsThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Running Thread1 at " + i);
        }
    }
}
