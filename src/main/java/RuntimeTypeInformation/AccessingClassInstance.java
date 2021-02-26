package RuntimeTypeInformation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

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
            System.out.println(field.getName() + " : " + field.getType());

        }

        //We can check what declared fields the bank account class has, only if they are public
        System.out.println("----------------------------------------");
        System.out.println("Declared Fields of the Bank Account are:");
        System.out.println("----------------------------------------");
        for (Field field:
                bankAccountClass.getDeclaredFields()) {
            System.out.println(field.getName() + " : " + field.getType());
        }

        //Retrieving a specific field
        System.out.println("We can also get the specific field name from the class instance:");
        try {
            System.out.println(bankAccountClass.getDeclaredField("lastName").getName()
                    + " : " + bankAccountClass.getDeclaredField("lastName").getType());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        //We can check what methods the bank account class has, only if they are public too
        System.out.println("--------------------------------");
        System.out.println("Methods of the Bank Account are:");
        System.out.println("--------------------------------");
        for (Method method:
             bankAccountClass.getMethods()) {
            //Excluding Object class methods
            if(method.getDeclaringClass() != Object.class)
                System.out.println(method.getName() + " : " + method.getReturnType());
        }

        //We can check what methods the bank account class has including private
        // and protected via DeclaredMethods
        System.out.println("-----------------------------------------");
        System.out.println("Declared Methods of the Bank Account are:");
        System.out.println("-----------------------------------------");
        for (Method method:
                bankAccountClass.getDeclaredMethods()) {
            System.out.println(method.getName() + " : " + method.getReturnType());
        }

        //We can also retrieve type access modifiers
        System.out.println("----------------------------------");
        System.out.println("Modifiers of the Bank Account are:");
        System.out.println("----------------------------------");
        int modifiers = bankAccountClass.getModifiers();
        if(Modifier.isFinal(modifiers))
            System.out.println("method check - final");
        if(Modifier.isPrivate(modifiers))
            System.out.println("method check - private");
        if(Modifier.isPublic(modifiers))
            System.out.println("method check - public");
        if(Modifier.isStatic(modifiers))
            System.out.println("method check - static ");
    }
}
