package metadataandannotations;

import lombok.Getter;
import lombok.Setter;

public class AccountWorker implements Runnable {

    BankAccount ba;
    HighVolumeAccount hva;

    @Getter
    @Setter
    char txType;

    @Getter
    @Setter
    int amt;

    public AccountWorker(BankAccount ba) { this.ba = ba; }

    public AccountWorker(HighVolumeAccount hva) { this.hva = hva; }

    //Determines if the Thread work is done by HVA or this class as
    // they have separate run implementations
    public void doWork() {
        Thread t = new Thread(hva!=null?hva:this);
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
