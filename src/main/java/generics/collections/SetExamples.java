package generics.collections;

import java.util.HashSet;
import java.util.Set;

public class SetExamples {

    public static void main(String[] args) {
        Person p1 = new Person("Hay Ward", 65);
        Person p2 = new Person("Tom Mitch", 59);
        Person p3 = new Person("Web Colt", 45);

        /*
            Sets are unique where in it will not contain any duplicates even if we add the same object twice
                - Sets do not have an order
                - It uses generics to bind to a particular Object type
         */
        Set<Person> people = new HashSet<>();

        people.add(p1);
        people.add(p2);
        people.add(p1);

        // Just like other collections we do not need to call a to string method explicitly
        System.out.println(people);

        // Sets have a contains method that can be used to check if an object already exists
        System.out.println(people.contains(p1));
        System.out.println(people.contains(p3));

        System.out.println("We can loop through the set but order is not guaranteed:");
        for (Person person :
                people) {
            System.out.println(person);
        }

        System.out.println(" we can use lambda expressions:");
        people.forEach(System.out::println);

    }

}
