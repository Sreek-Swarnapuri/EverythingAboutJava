package functional.lambdas;

public class TypeInferenceExample {

    public static void main(String[] args) {
        // We do not need to specify the Type in the lambda expression as: (String s) -> s.length()
        // Java automatically can pick the Type from the Interface as we have already defined a abstract method in it.
        StringlengthLambda myLambda = s -> s.length();
        System.out.println("Length of 'Hello Lambda!' is " + myLambda.getLength("Hello Lambda!"));
        printLambda(s -> s.length());
    }

    public static void printLambda(StringlengthLambda l) {
        System.out.println("Length of 'Hello Lambda!' from method accepting a Functional Interface with Lambda input is " + l.getLength("Hello Lambda!"));
    }

    interface StringlengthLambda {
        int getLength(String s);
    }

}
