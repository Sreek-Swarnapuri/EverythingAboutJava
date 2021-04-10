package runtime_info_and_reflections;

import java.lang.reflect.Method;

public class InvokingFromClassInstance {

    public static void main(String[] args) {

        BankAccount acct1 = new BankAccount(1, "Sreek", "Swarnapuri", 123);
        callGetIdViaReflection(acct1);
        callDepositViaReflection(acct1, 23455);
    }

    //We can use reflection and invoke necessary methods
    public static void callGetIdViaReflection(Object obj) {
        try {
            Class<?> cls = obj.getClass();
            Method m = cls.getMethod("getId");
            Object result = m.invoke(obj);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void callDepositViaReflection(Object obj, int amt) {
        try {
            Class<?> cls = obj.getClass();
            Method m = cls.getMethod("deposit",int.class);
            m.invoke(obj,amt);
            Object result = cls.getMethod("getBalance").invoke(obj);
            System.out.println("Balance: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
