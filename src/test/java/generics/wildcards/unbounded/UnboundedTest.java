package generics.wildcards.unbounded;

import functional.lambdas.usingcollections.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnboundedTest {

    @Test
    public void classNameSetIsRetrieved() throws Exception{
        // Given
        Class<Person> personClass = Person.class;

        // When
        Unbounded unbounded = new Unbounded(personClass);

        // Then
        Assertions.assertEquals(personClass,unbounded.aClass);

    }

}
