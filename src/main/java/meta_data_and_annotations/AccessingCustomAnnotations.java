package meta_data_and_annotations;

import meta_data_and_annotations.customannotations.WorkHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccessingCustomAnnotations {

    ExecutorService pool = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {

        AccessingCustomAnnotations a = new AccessingCustomAnnotations();
        BankAccount ba = new BankAccount("Sreek",10000);
        try {
            a.startWork("metadataandannotations.AccountWorkerImplTaskWorker",ba);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    void startWork(String workerTypeName, Object workerTarget) throws Exception {
        Class<?> workerType = Class.forName(workerTypeName);
        TaskWorker worker = (TaskWorker) workerType.newInstance();
        worker.setTarget(workerTarget);

        WorkHandler wh = workerType.getAnnotation(WorkHandler.class);

        if (wh == null)
            throw new Exception();
        if(wh.useThreadPool())
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    worker.doWork();
                }
            });
        else
            worker.doWork();

    }

}
