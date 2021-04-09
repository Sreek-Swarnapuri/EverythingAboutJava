package generics.wildcards.bounded;

import generics.collections.Person;
import lombok.ToString;

@ToString
public class Partner extends Person {

    public Partner(String name, int age) {
        super(name, age);
    }
}
