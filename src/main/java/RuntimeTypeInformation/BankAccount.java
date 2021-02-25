package RuntimeTypeInformation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//Created a basic class to use for Demonstrating Runtime Type information
public final class BankAccount {

    private int id;
    private String firstName;
    private String lastName;
    public int balance;

    public synchronized void deposit(int amount) {
        balance+=amount;
    }

    private synchronized void withdrawal(int amount) {
        balance-=amount;
    }

}
