package metadataandannotations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//Created a basic class to use for Demonstrating Runtime Type information
public class BankAccount {

    private String id;
    private int balance = 0;

    public synchronized int getBalance() { return balance; }

    public synchronized void deposit(int amount) {
        balance+=amount;
    }

    public synchronized void withdrawal(int amount) {
        balance-=amount;
    }

    //Built in annotations that can be used
    // by the compiler to let us know if we are not using the valid method signature
    //  - This will throw an error if we spell toString() name wrong which is overridden from Object class
    @Override
    public String toString() {
        return getId() + " : " + getBalance();
    }

}
