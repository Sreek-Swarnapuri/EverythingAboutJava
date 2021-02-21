package RuntimeTypeInformation;

import java.lang.reflect.Field;

public class AccessingClassInstance {

    public static void main(String[] args) {
        //We can access the class instance of any object
        BankAccount account = new BankAccount();
        Class bankAccountClass = account.getClass();

        //We can print the name of the class
        System.out.println(bankAccountClass.getSimpleName());

        //We can check what fields the bank account class has
        for (Field field:
             bankAccountClass.getFields()) {
            System.out.println(field.getName());

        }
    }
}
