package meta_data_and_annotations;

/**
 * Extension of bank account which may have multiple deposits and
 * withdrawals each day
 */
public class HighVolumeAccount extends BankAccount implements Runnable {

    public HighVolumeAccount(String id) {
        super(id, 0);
    }

    public HighVolumeAccount(String id, int bal) {
        super(id, bal);
    }

    private int[] readDailyDeposits() {
        return new int[]{10, 20, 40};
    }

    private int[] readDailyWithdrawals() {
        return new int[]{5, 10, 15};
    }

    //Built in annotation which states this method is overridden.
    @Override
    public void run() {

        for (int depAmt :
                readDailyDeposits()) {
            deposit(depAmt);
        }

        for (int withAmt :
                readDailyWithdrawals()) {
            withdrawal(withAmt);
        }

    }
}
