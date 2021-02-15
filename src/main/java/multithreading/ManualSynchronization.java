package multithreading;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * We can manually synchronize instead of synchronizing methods in a class
 */
public class ManualSynchronization {

    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(5);

        BankAccountMS bankAccount = new BankAccountMS(100);

        for (int i = 0; i < 5; i++) {
            WorkerMS worker = new WorkerMS(bankAccount, i);
            es.submit(worker);
        }

        try {
            es.shutdown();
            if (!es.awaitTermination(5, TimeUnit.SECONDS))
                es.shutdownNow();
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + ":" + e.getMessage());
            es.shutdownNow();
        }

    }

}

@AllArgsConstructor
class WorkerMS implements Runnable {
    private BankAccountMS bankAccount;
    private int id;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //We can manually synchronize instead of synchronized methods
            synchronized (bankAccount) {
                int startBal = bankAccount.getBalance();
                bankAccount.deposit(100);
                int endBal = bankAccount.getBalance();
                System.out.println("End balance: " + endBal + " Start balance: " + startBal + " Worker :" + id);
            }
        }
    }
}

@Getter
@AllArgsConstructor
class BankAccountMS {
    private int balance;

    public void deposit(int amount) {
        balance += amount;
    }
}