package variables;

public class TypeConversion {

    public static void main(String[] args){

        float floatVal = 1.0f;
        double doubleVal = 4.0d;
        byte byteVal = 7;
        short shortVal = 7;
        long longVal = 5;

        //Widening
        short result1 = byteVal;

        //Narrowing
        // short result2 = longVal; // will throw an error as incompatible types
        short result2 = (short)longVal;

        //short result3 = byteVal - longVal; // will throw an error as the expression converts to longVal as it is the largest possible value
        short result3 = (short) (byteVal - longVal);

        //widening
        double result4 = longVal - doubleVal;

        //narrowing
        //long result4 = longVal - doubleVal; will result in error as the expression evaluates to double and is not compatible to long
        //long result4 = longVal - floatVal - doubleVal; will result in error as the expression evaluates to double and is not compatible to long
        //long result4 = longVal - floatVal; will result in error as the expression evaluates to float and is not compatible to long

        System.out.println("success");

    }

}
