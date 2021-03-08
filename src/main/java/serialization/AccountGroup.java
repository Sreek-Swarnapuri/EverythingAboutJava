package serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AccountGroup implements Serializable {

    private static final long serialVersionUID = 6972312535679428432L;

    private Map<String, BankAccountWithSerialization> accountMap = new HashMap();
    //Marking the field Transient so that it is not included when reading
    // or writing objects from streams
    private transient int totalAmount;

    public int getTotalAmount() {
        return totalAmount;
    }

    public void addAccount(BankAccountWithSerialization account) {
        totalAmount += account.getBalance();
        accountMap.put(account.getId(), account);
    }

    private void readObject(ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        for (BankAccountWithSerialization account
                : accountMap.values())
            totalAmount += account.getBalance();
    }

}
