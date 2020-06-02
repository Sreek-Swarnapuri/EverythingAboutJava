package string;

public class ComparingTwoStrings {

    public static void main(String[] args){

        String s1 = "new";
        String s2 = new String(s1);
        String s3 = "new";

        //Shallow comparison: compares the references of the string
        System.out.println("s1==s2 -> " + (s1==s2)); //false
        System.out.println("s1==s3 -> " + (s1==s3)); //true - since s1 and s2 refer to the same object these are true

        //deep comparison: Compares the actual value in the strings
        System.out.println("s1.equals(s2) -> " + (s1.equals(s2))); //true
        System.out.println("s3.equals(s2) -> " + (s3.equals(s2))); //true

        System.out.println("Hash codes of each string object: ");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
        System.out.println("Reference codes of each strings: ");
        System.out.println(Integer.toHexString(System.identityHashCode(s1)));
        System.out.println(Integer.toHexString(System.identityHashCode(s2)));
        System.out.println(Integer.toHexString(System.identityHashCode(s3)));

        //If we are comparing strings frequently, we can use .intern() method to get the internal rep of String
        //Using this we can use shallow comparison to compare two strings as they would point to the same ref
        String string1 = "I love Java";
        String string2 = "I love";
        string2 += " Java";
        System.out.println("string1: " + string1);
        System.out.println("string2: " + string2);
        String string3 = string1.intern();
        String string4 = string2.intern();
        System.out.println("string3==string4: "+ (string3==string4));

    }

}
