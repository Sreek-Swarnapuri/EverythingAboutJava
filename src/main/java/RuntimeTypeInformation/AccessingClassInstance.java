package RuntimeTypeInformation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AccessingClassInstance {

    public static void main(String[] args) {

        //We can access the class instance of any object using the objectName.getClass() method
        BankAccount account = new BankAccount();
        Class<?> bankAccountClass = account.getClass();

        //We can print the name of the class
        System.out.println("Class Name via getClass(): " + bankAccountClass.getSimpleName());

        //We can get the class instance by using Class.forName() method as well
        // passing the "fully qualified Class" name as String into the method
        try {
            Class<?> bankAccountClass2 = Class.forName("RuntimeTypeInformation.BankAccount");
            //We can print the name of the class
            System.out.println("Class name via forName(): " + bankAccountClass2.getSimpleName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //We can also get the class instance by the type literal typename.class
        Class<?> bankAccountClass3 = BankAccount.class;
        //We can print the name of the class
        System.out.println("Class Name via Type.class: " + bankAccountClass3.getSimpleName());

        //We can check what fields the bank account class has, only if they are public
        System.out.println("-------------------------------");
        System.out.println("Fields of the Bank Account are:");
        System.out.println("-------------------------------");
        for (Field field:
             bankAccountClass.getFields()) {
            System.out.println(field.getName());

        }

        //We can check what methods the bank account class has, only if they are public too
        System.out.println("--------------------------------");
        System.out.println("Methods of the Bank Account are:");
        System.out.println("--------------------------------");
        for (Method method:
             bankAccountClass.getMethods()) {
            System.out.println(method.getName());
        }
    }
}
