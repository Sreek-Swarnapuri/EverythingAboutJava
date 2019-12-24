package looping;

public class DoWhileLoop {
    public static void main(String[] args){
        int iVal = 5;
        do {
            System.out.println(iVal + " * 2 = " + (iVal*2) );
            iVal *= 2;
        }while (iVal<100);

    }
}
