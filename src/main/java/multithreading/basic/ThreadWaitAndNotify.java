package multithreading.basic;

/**
 * Wait for a thread to execute and notify to execute the rest of the process.
 */
public class ThreadWaitAndNotify {

    public static void main(String[] args) {

        Calculator thread = new Calculator();

        thread.start();

        // the main process waits until the thread notifies that it has completed execution
        //      and only then proceeds further
        synchronized (thread) {
            try {
                thread.wait();
            } catch (Exception e ) {
                System.out.println("Exception occurred: " + e);
            }
        }

        System.out.println(thread.sum);

    }

}

class Calculator extends Thread {

    long sum;

    @Override
    public void run() {
        synchronized(this)  {
            for (int i = 0; i < 10000; i++) {
                sum += i;
            }
            notify();
        }
    }
}