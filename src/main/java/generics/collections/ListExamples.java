package generics.collections;

import java.util.ArrayList;
import java.util.List;

public class ListExamples {

    public static void main(String[] args) {

        Person p1 = new Person("Hay Ward", 65);
        Person p2 = new Person("Tom Mitch", 59);

        // Collections come with Generics and we can create a List of Type Person as below to state that only objects
        //  with type Person are allowed in the List.
        //      - if we observe we are not specifying the generic type in the new declaration and are just specifying diamond operator,
        //          as it implicitly takes the generic type for the declaration
        List<Person> people = new ArrayList<>();

        people.add(p1);
        people.add(p2);

        // We do not need to call an explicit ToString method as the list uses the overridden toString method in the type it has
        System.out.println(people);

        // Adding a new element to a list is as easy as using the .add() method
        //      - the ArrayList resizes itself and we do not need to explicitly re-size it as we did for Arrays
        people.add(new Person("Web Colt", 45));

        System.out.println(people);

        System.out.println(people.size());

        System.out.println("Lists have Order:");
        System.out.println(people.get(0));
        System.out.println(people.get(1));
        // Lists get method returns a generic type which is the one we specify when creating the list
        //      - in our case it is a Person type
        final Person p3 = people.get(2);
        System.out.println(p3);

        System.out.println("Looping over the list: ");
        /*
            We can use a normal for loop
        for (int i = 0; i < people.size(); i++) {
            final Person person = people.get(i);
            System.out.println(person);
        }
        */

        /*
            We can use an iterator to loop over the collection
                - Iterator also uses generics to bind to a particular type of the object i.e. Person in this case
        final Iterator<Person> iterator = people.iterator();
        while(iterator.hasNext()) {
            final Person person = iterator.next();
            System.out.println(person);
        }
        */

        // We can also use for each loop
        for (Person person :
                people) {
            System.out.println(person);
        }

        // Java 8 feature - Lamda expressions and Streams
        System.out.println(" Using lambda expression-");
        people.forEach(System.out::println);

    }

}
