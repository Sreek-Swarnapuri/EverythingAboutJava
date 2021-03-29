package generics.collections;

import java.util.Arrays;

public class TheArrayProblem {

    /*
        We can see now that using arrays has a problem or resizing
            and is not a recommended approach to use for a collection of objects.
        Using arrays can be error prone as well.
     */
    public static void main(String[] args) {
        Person p1 = new Person("Hay Ward", 65);
        Person p2 = new Person("Tom Mitch", 59);

        Person[] people = {p1, p2};

        Person p3 = new Person("Web Colt", 45);

        people = add(p3, people);

        System.out.println(Arrays.toString(people));

    }

    private static Person[] add(Person person, Person[] people) {

        int len = people.length;
        people = Arrays.copyOf(people, len + 1);
        people[len] = person;
        return people;
    }

}
