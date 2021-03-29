package functional.lambdas.usingcollections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsWithLambda {

    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("Charles", "Dickens", 45),
                new Person("Chad", "Milk", 36),
                new Person("Math", "Hue", 45),
                new Person("Manny", "Bar", 60),
                new Person("Pen", "Worth", 40),
                new Person("Seth", "Rutherford", 40)
        );

        //Step 1: Sort list by first name
        //Collections.sort(personList, (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()));
        Collections.sort(personList, Comparator.comparing(Person::getFirstName));

        //Step 2: Create a method that prints all the persons in the list
        System.out.println("---------Printing all the persons in order---------");
        printConditionally(personList,p -> true);

        //Step 3: Print all persons that have first name starting "C"
        System.out.println("---------Printing all the persons in order starting with 'C'---------");
        printConditionally(personList, p -> p.getFirstName().startsWith("C"));

        //Step 4: Print all persons that have first name starting "M"
        System.out.println("---------Printing all the persons in order starting with 'M'---------");
        printConditionally(personList, p -> p.getFirstName().startsWith("M"));
    }

    public static void printConditionally(List<Person> personList, Condition condition) {
        personList.forEach(p ->{
            if(condition.test(p))
                System.out.println(p);
        });
    }

}

interface Condition {
    boolean test(Person p);
}
