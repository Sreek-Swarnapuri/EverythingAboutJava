package serialization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class BankAccount implements Serializable {
    private final String id;
    private int balance = 0;

    public void deposit(int amt) {
        balance+=amt;
    }

    public void withdrawal(int amt) {
        balance-=amt;
    }


}
