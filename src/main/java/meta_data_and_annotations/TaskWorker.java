package meta_data_and_annotations;

public interface TaskWorker {

    void setTarget(Object target) throws IllegalAccessException;

    void doWork();

}
