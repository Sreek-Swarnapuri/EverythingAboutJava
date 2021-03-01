package RuntimeTypeInformation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InstanceCreationWithReflection{

    public static void main(String[] args) {
        BankAccount acct1 = new BankAccount();
        startWork("RuntimeTypeInformation.AccountWorker",acct1);
    }

    static void startWork(String workerTypeName, Object workerTarget) {
        try {
            Class<?> workerType = Class.forName(workerTypeName);
            Class<?> targetType = workerTarget.getClass();

            // Give me back a constructor that accepts the target type provided.
            // i.e. AccountWorker constructor with BankAccount parameter
            Constructor<?> c = workerType.getConstructor(targetType);

            //Create a new instance by passing the necessary arguments for the constructor
            Object worker = c.newInstance(workerTarget);

            // Invoke the doWork method of the WorkerType i.e. AccountWorker with parameter bank account
            Method doWork = workerType.getMethod("doWork");
            doWork.invoke(worker);


        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}
