package runtime_info_and_reflections;

public interface TaskWorker {

    void setTarget(Object target) throws IllegalAccessException;

    void doWork();

}
