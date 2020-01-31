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

    }

}
