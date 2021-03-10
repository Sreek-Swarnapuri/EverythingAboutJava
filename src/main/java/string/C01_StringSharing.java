package string;

public class C01_StringSharing {

    public static void main(String[] args) {
        String snew = new String("abc");
        System.out.println("snew ref: " + snew.hashCode());
        String snew1 = new String("abc");
        System.out.println("snew1 ref: " + snew1.hashCode());

        String s1 = "abc";
        System.out.println("s1 ref: " + s1.hashCode());
        String s2 = "bcd";
        System.out.println("s2 ref: " + s2.hashCode());
        String s3 = "abc";
        System.out.println("s3 ref: " + s3.hashCode());

        System.out.println("---------------------Checking Equality-------------------");
        System.out.println("snew == snew1? : " + (snew == snew1));
        System.out.println("snew == s1? : " + (snew == s1));
        System.out.println("s1 == s2? : " + (s1 == s2));
        System.out.println("s1 == s3? : " + (s1 == s3));

    }

}
