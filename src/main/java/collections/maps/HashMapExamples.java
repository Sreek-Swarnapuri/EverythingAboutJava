package collections.maps;

import java.util.HashMap;
import java.util.Map;

public class HashMapExamples {

    public static void main(String[] args) {
        Map<String, String> devDictionary = new HashMap<>();

        devDictionary.put("SEO", "Search engine optimization");
        devDictionary.put("SaaS", "Software as a service");
        devDictionary.put("UX", "User experience");


        String input = "UX";

        System.out.printf("%s: %s%n", input, devDictionary.get(input));

    }

}
