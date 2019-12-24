package looping;

public class WhileLoop {

    public static void main(String[] args)
    {
        int kVal = 5;
        int factorial = 1;
        while(kVal>1)
            factorial *=kVal--;

        System.out.println("Factorial of 5 is " + factorial);
    }


}
