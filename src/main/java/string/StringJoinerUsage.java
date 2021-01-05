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

        //Customizing Empty Handling
        System.out.println("We can specify what to display or use when no values are provided to a String joiner - in this case the word 'EMPTY':");
        sj = new StringJoiner(", ");
        sj.setEmptyValue("EMPTY");
        String output = sj.toString();
        System.out.println(output);
        System.out.println(" - With first and last values provided as well:");
        sj = new StringJoiner(", ","{","}");
        sj.setEmptyValue("EMPTY");
        output = sj.toString();
        System.out.println(output);
        System.out.println(" - With an actual empty string provided as one input(no first and last values):");
        sj = new StringJoiner(", ");
        sj.setEmptyValue("EMPTY");
        sj.add("");
        output = sj.toString();
        System.out.println(output);
        System.out.println(" - With an actual empty string provided as one input(with first and last values):");
        sj = new StringJoiner(", ","{","}");
        sj.setEmptyValue("EMPTY");
        sj.add("");
        output = sj.toString();
        System.out.println(output);


    }

}
