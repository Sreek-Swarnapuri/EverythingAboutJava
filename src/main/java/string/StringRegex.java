package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringRegex {

    public static void main(String[] args) {

        String s1 = "apple, apple and orange please";
        System.out.println(s1);

        //Usage of replace all
        String s2 = s1.replaceAll("ple","ricot");
        System.out.println(s2);
        //Use the \b to indicate a word break so that the 'ple' in 'please' does not change
        String s3 = s1.replaceAll("ple\\b","ricot");
        System.out.println(s3);

        //Usage of split and match method
        String[] parts = s1.split("\\b");

        System.out.println("The parts are:\n----------");
        for(String thePart:parts) {
            // '\w' indicates that we only match the String if it contains one or more occurrences of word characters
            // This will not print the parts where there is no word at all
            if (thePart.matches("\\w+"))
                System.out.println(thePart);
        }

        // Dedicated, regular expression classes
        System.out.println("The matched patterns are:\n----------------");
        Pattern pattern = Pattern.compile("\\w+");

        Matcher matcher = pattern.matcher(s1);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }


    }

}
