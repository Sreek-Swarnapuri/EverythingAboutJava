package collections.maps;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExamples {

    public static void main(String[] args) {
        Map<String, String> dictionary = new TreeMap<>();

        dictionary.put("SEO", "Search engine optimization");
        dictionary.put("SaaS", "Software as a service");
        dictionary.put("UX", "User experience");

        for (Map.Entry<String , String> entry:
             dictionary.entrySet()) {
            System.out.printf("%s: %s%n",entry.getKey(), entry.getValue());
        }

    }

}
