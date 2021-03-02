package metadataandannotations;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import metadataandannotations.customannotations.WorkHandler;

@NoArgsConstructor
@WorkHandler(useThreadPool = false)
public class AccountWorkerImplTaskWorker implements Runnable, TaskWorker {

    BankAccount ba;
    HighVolumeAccount hva;

    @Getter
    @Setter
    char txType;

    @Getter
    @Setter
    int amt;

    public AccountWorkerImplTaskWorker(BankAccount ba) { this.ba = ba; }

    public AccountWorkerImplTaskWorker(HighVolumeAccount hva) { this.hva = hva; }

    @Override
    public void setTarget(Object target) throws IllegalAccessException {

        if(BankAccount.class.isInstance(target))
            ba = (BankAccount) target;
        else
            throw new IllegalAccessException();

    }

    //Determines if the Thread work is done by HVA or this class as
    // they have separate run implementations
    public void doWork() {
        System.out.println("Entering AccountWorkerImplTaskWorker - doWork()");
        Thread t = new Thread(
                HighVolumeAccount.class.isInstance(ba) ? (HighVolumeAccount) ba: this
        );
        System.out.println("Exiting AccountWorkerImplTaskWorker - doWork()");
    }

    @Override
    public void run() {
        char txType = getTxType();
        int amount = getAmt();
        if(txType == 'w')
            ba.withdrawal(amount);
        else
            ba.deposit(amount);
    }

}
