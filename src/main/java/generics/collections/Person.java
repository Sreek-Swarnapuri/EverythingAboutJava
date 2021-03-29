package generics.collections;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
public class Person {

    private final String name;
    private final int age;

    public Person(String name, int age) {
        Objects.requireNonNull(name);

        this.name = name;
        this.age = age;

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        return 31 * result + age;

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }

}
