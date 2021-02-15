package multithreading;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Synchronized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CoordinatedConcurrency {

    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(5);

        BankAccountSync bankAccount = new BankAccountSync(100);

        for (int i = 0; i < 5; i++) {
            WorkerSync worker = new WorkerSync(bankAccount,i);
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
class WorkerSync implements Runnable {
    private BankAccountSync bankAccount;
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

@AllArgsConstructor
class BankAccountSync {
    private int balance;

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void deposit(int amount) {
        balance+=amount;
    }
}