package functional.lambdas;

import collections.LambdaExpressions;

public class Greeter {

    public void greet(Greeting greeting) {
        //System.out.println("Hello World!");
        greeting.perform();
    }

    public static void main(String[] args) {

        //This is what we used to do to perform a method by creating an interface, class and declare it
        // so that it can be executed. Prior to Java 8
        Greeter g = new Greeter();
        HelloWorldGreeting greeting = new HelloWorldGreeting();
        System.out.println("---------Without lambda---------");
        g.greet(greeting);

        //This is what we do to execute a method without adhering ot the OOP model
        //   we use functional programming
        MyLambda myLambdaFunction = () -> System.out.println("Hello World!");
        System.out.println("---------With lambda---------");
        myLambdaFunction.helloWorld();
        //We can also use the already created interface:
        System.out.println("---------With lambda using already existing interface---------");
        Greeting myLambdaFunction1 = () -> System.out.println("From Lambda expression: Hello World!");
        myLambdaFunction1.perform();
        System.out.println("---------lambda to sum two integers---------");
        MyAdd add = (int a, int b) -> a + b;
        System.out.println("Sum from lambda expression: " + add.add(10,20));

        // Define inline implementation of an interface OR called Anonymous inner class
        System.out.println("---------With Anonymous inner class---------");
        Greeting innerClassGreeting = new Greeting() {
            @Override
            public void perform() {
                System.out.println("From Inner Class - Hello World!");
            }
        };
        innerClassGreeting.perform();

    }

}

// --------Creating Lambda expressions--------
// Step 1 - Create an interface.
//          Implicit rule: when using a Interface for lambda expression, the interface should only have one method
// Step 2 - Create one method in the interface which has exact same signature of the lambda that we are trying to declare
// Step 3 - Use it as a type to the lambda expression as above in the main execution
@FunctionalInterface
interface MyLambda {
    void helloWorld();
}

@FunctionalInterface
interface MyAdd {
    int add(int x, int y);
}

