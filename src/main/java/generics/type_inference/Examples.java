package generics.type_inference;

import generics.collections.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Examples {

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();

        people.add(new Person("Tom Mitch", 59));
        people.add(new Person("Hay Ward", 65));
        people.add(new Person("Web Colt", 45));
        people.add(new Person("Mash Potato", 20));
        people.add(new Person("Cheese Dip", 24));

        // The execution part on the right side infers the types declared on the left side and
        //  throws any errors if the resulting data does not match the type on the left
        Map<Boolean, List<Person>> oldAndYoungPeople
                = people.stream().collect(Collectors.partitioningBy(p -> p.getAge() > 50));

        System.out.println(oldAndYoungPeople);

        // If we want to further get only the count of old and end, we have to change the target type on the left before
        //   changing the expression on the right
        Map<Boolean, Long> oldAndYoungPeopleCounts
                = people.stream().collect(Collectors.partitioningBy(p -> p.getAge() > 50, Collectors.counting()));

        System.out.println(oldAndYoungPeopleCounts);

    }

}
