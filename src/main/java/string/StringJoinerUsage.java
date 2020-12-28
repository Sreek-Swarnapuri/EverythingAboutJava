package string;

import java.util.StringJoiner;

public class StringJoinerUsage {

    public static void main(String[] args) {

        //Basic String joiner usage using commas
        StringJoiner sj = new StringJoiner(", ");
        sj.add("Alpha");
        sj.add("Beta");
        sj.add("Gamma");
        System.out.println("Basic String joiner output with comma separation:");
        System.out.println(sj);

        //Chaining method calls
        sj = new StringJoiner(", ");
        sj.add("Alpha").add("Beta").add("Gamma");
        System.out.println("Same result using method chaining:");
        System.out.println(sj);

        //With Start and end values
        sj = new StringJoiner(", ","[","]");
        sj.add("Alpha").add("Beta").add("Gamma");
        System.out.println("With start and end values specified:");
        System.out.println(sj);

        //Handling a single value
        sj = new StringJoiner(", ");
        sj.add("Alpha");
        System.out.println("Outputs only the particular word when only one value is added:");
        System.out.println(sj);

        //Handling a single value with start and end values
        sj = new StringJoiner(", ","[","]");
        sj.add("Alpha");
        System.out.println("Outputs only the particular word with start and end values when only one value is added:");
        System.out.println(sj);

    }

}
