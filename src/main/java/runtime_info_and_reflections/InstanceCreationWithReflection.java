package runtime_info_and_reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InstanceCreationWithReflection{

    public static void main(String[] args) {
        BankAccount acct1 = new BankAccount();
        //Creating new instance via constructor
        startWork("RuntimeTypeInformation.AccountWorker",acct1);
        //Creating new instance via constructor but converting it to an interface the instance inherits from
        startworkInterface("RuntimeTypeInformation.AccountWorkerImplTaskWorker",acct1);
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

    // We create an instance and assign it to the object of the interface the target object inherits from
    // and then use it to call the necessary methods directly instead of using reflection.
    static void startworkInterface(String workerTypeName, Object workerTarget) {
        try {
            Class<?> workerType = Class.forName(workerTypeName);
            TaskWorker worker = (TaskWorker) workerType.newInstance();
            worker.setTarget(workerTarget);
            worker.doWork();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
