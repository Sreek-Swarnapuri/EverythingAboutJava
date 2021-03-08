package serialization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class BankAccountWithSerialization implements Serializable {

    //Adding the serialVersionID from IntelliJ: https://netlicensing.io/blog/2012/12/25/intellij-idea-how-to-generate-serialversionuid/
    private static final long serialVersionUID = -5999665870417204742L;

    private String id;
    private int balance = 0;
    private char lastTxType;
    private int lastTxAmount;

    public BankAccountWithSerialization(String id, int balance) {
        this.id = id;
        this.balance = balance;

    }

    public void deposit(int amt) {
        balance+=amt;
    }

    public void withdrawal(int amt) {
        balance-=amt;
    }

    //Customizing Serialization
    private void writeObject(ObjectOutputStream out)
            throws IOException {
        out.defaultWriteObject();
    }

    //Customizing De-Serialization
    private void readObject(ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = in.readFields();
        id = (String) fields.get("id", null);
        balance = fields.get("balance", 0);
        lastTxType = fields.get("lastTxType", 'u');
        lastTxAmount = fields.get("lastTxAmount", -1);
    }

}
