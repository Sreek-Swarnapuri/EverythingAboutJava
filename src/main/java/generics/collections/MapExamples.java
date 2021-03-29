package generics.collections;

import java.util.HashMap;
import java.util.Map;

public class MapExamples {

    public static void main(String[] args) {

        Person p1 = new Person("Hay Ward", 65);
        Person p2 = new Person("Tom Mitch", 59);
        Person p3 = new Person("Web Colt", 45);

        // using Maps with generics, with two of them one is String which is the key and Other Person - the value
        Map<String, Person> people = new HashMap<>();

        people.put("Hay Ward", p1);
        people.put("Tom Mitch", p2);
        people.put("Web Colt", p3);

        System.out.println(people);

        System.out.println("--------Looping with foreach loop--------");
        for (Person person :
                people.values()) {
            System.out.println(person);
        }
        System.out.println("--------Looping with foreach loop--------");
        // An Map.Entry is a generic type and is one entry in a map
        for (Map.Entry<String, Person> entry :
                people.entrySet()) {
            System.out.println(entry.getValue());
            System.out.println(entry.getValue());
        }

    }

}
