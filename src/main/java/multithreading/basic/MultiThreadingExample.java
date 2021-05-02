package multithreading.basic;

public class MultiThreadingExample {

    public static void main(String[] args) {
        Thread1ExtendsThread thread1 = new Thread1ExtendsThread();

        Thread2ImplementsRunnable thread2 = new Thread2ImplementsRunnable();

        //Running both threads:
        //---------------------

        // we can start the threads that extend Thread directly using start() method from the instance
        //                               -------------
        thread1.start();

        // To start the thread2 which implements Runnable interface
        //                            -------------------
        Thread runThread2 = new Thread(thread2);
        runThread2.start();
    }

}
