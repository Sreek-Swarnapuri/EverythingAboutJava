package metadataandannotations;

public interface TaskWorker {

    void setTarget(Object target) throws IllegalAccessException;

    void doWork();

}
