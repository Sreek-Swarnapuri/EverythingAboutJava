package string;

public class StringFormatting {

    public static void main(String[] args) {
        //We can add format to the string concatenation by using String.format
        int i = 10;
        double data = i/3.0d;
        System.out.println("The value is " +data);
        String string = String.format("The value is %.1f", data );
        System.out.println(string);

        //We can use x conversion literal to convert a decimal number into hexadecimal
        System.out.println(String.format("The value of %d in hex is %x",32,32));
        //We can use a # sign to provide a detailed hexadecimal notation
        System.out.println(String.format("The value of %d in hex is %#x",32,32));
        System.out.println(String.format("The value of %d in hex is %#X",32,32));

        //we can use flags to pad the data or change the right to left justification
        int w = 5, x = 235, y = 481, z = 14;
        System.out.println(String.format("W:%d X:%d",w,x));
        System.out.println(String.format("Y:%d Z:%d",y,z));
        //n flag - padding with white spaces
        System.out.println(String.format("W:%4d X:%4d",w,x));
        System.out.println(String.format("Y:%4d Z:%4d",y,z));
        //0 flag - padding with zeros
        System.out.println(String.format("W:%04d X:%04d",w,x));
        System.out.println(String.format("Y:%04d Z:%04d",y,z));
        //- flag - left justification
        System.out.println(String.format("W:%-4d X:%-4d",w,x));
        System.out.println(String.format("Y:%-4d Z:%-4d",y,z));

        //we can use comma , flag to group numbers
        System.out.println(String.format("%d",1234567));
        System.out.println(String.format("%,d",1234567));
        System.out.println(String.format("%,.2f",1234567.0));

        //We can format numbers to show the signs of the number like positive or negative
        int a = 123, b = -456;
        // space : leaves a space for positive numbers but - sign for negative numbers
        System.out.println(String.format("% d",a));
        System.out.println(String.format("% d",b));
        // + : assigns a + or - sign based on the number
        System.out.println(String.format("%+d",a));
        System.out.println(String.format("%+d",b));
        // ( : adds parenthesis to negative numbers but leaves positive numbers as is
        System.out.println(String.format("%(d",a));
        System.out.println(String.format("%(d",b));
        System.out.println(String.format("% (d",a));

        //we can use argument index format specifier to specify which element belongs to which argument in the order of specified string
        int i1 = 100, i2 = 200, i3 = 300;
        //If we don't provide any arg index, it will take the order as is.
        System.out.println(String.format("%d %d %d", i1,i2,i3));
        //if we provide an index followed by $, it picks out the element based on the index for that item in the string
        System.out.println(String.format("%3$d %1$d %2$d", i1,i2,i3));
        //if we provide an < index, it picks out the element based on the prior item for that item in the string
        System.out.println(String.format("%2$d %<d %3$d", i1,i2,i3));
    }

}
