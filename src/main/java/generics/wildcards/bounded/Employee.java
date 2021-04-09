package generics.wildcards.bounded;

import generics.collections.Person;
import lombok.ToString;

@ToString
public class Employee extends Person {

    public Employee(String name, int age) {
        super(name, age);
    }

}
