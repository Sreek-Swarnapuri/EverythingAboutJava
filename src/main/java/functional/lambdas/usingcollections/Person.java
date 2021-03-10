package functional.lambdas.usingcollections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Data
public class Person {

    String firstName;
    String lastName;
    int age;
}
