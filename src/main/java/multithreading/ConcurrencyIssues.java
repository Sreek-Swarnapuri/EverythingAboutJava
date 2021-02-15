package multithreading;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created a class to demonstrate the concurrency issues
 * that may occur when updating multiple threads at once over a single resource
 */
public class ConcurrencyIssues {

    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(5);

        BankAccount bankAccount = new BankAccount(100);

        for (int i = 0; i < 5; i++) {
            Worker worker = new Worker(bankAccount,i);
            es.submit(worker);
        }

        try {
            es.shutdown();
            if(!es.awaitTermination(5, TimeUnit.SECONDS))
                es.shutdownNow();
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + ":" + e.getMessage());
            es.shutdownNow();
        }

    }

}

@AllArgsConstructor
class Worker implements Runnable {
    private BankAccount bankAccount;
    private int id;
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            int startBal = bankAccount.getBalance();
            bankAccount.deposit(100);
            int endBal = bankAccount.getBalance();
            System.out.println("End balance: "+ endBal + " Start balance: " + startBal + " Worker :" + id);
        }
    }
}

@Getter
@AllArgsConstructor
class BankAccount {
    private int balance;

    public void deposit(int amount) {
        balance+=amount;
    }
}