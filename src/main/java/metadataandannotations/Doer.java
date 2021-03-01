package metadataandannotations;

public class Doer {
    // In case this method is old and a new implementation is to be provided
    //  we can mark this as deprecated as below:
    @Deprecated
    void doItThisWay() {
        System.out.println("Doing it in one way Doer");
    }
}

class MyWorker {

    // We can use the SuppressWarnings Annotation for the compiler to not
    //   show any warnings of deprecation as below:
    @SuppressWarnings("deprecation")
    void doSomeWork() {
        Doer d = new Doer();
        d.doItThisWay();
    }

    @SuppressWarnings("deprecation")
    void doDoubleWork() {
        Doer d1 = new Doer();
        Doer d2 = new Doer();

        d1.doItThisWay();
        d2.doItThisWay();

     }
}