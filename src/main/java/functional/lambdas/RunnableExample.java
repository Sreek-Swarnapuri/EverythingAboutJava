package functional.lambdas;

public class RunnableExample {

    public static void main(String[] args) {
        //Using Anonymous class
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printed inside Runnable");
            }
        });

        Thread lambdaThread = new Thread(() -> System.out.println("Printed inside Lambda Runnable"));
    }
}
