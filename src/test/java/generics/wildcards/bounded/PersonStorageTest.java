package generics.wildcards.bounded;

import generics.collections.Person;
import generics.wildcards.util.PersonLoader;
import generics.wildcards.util.PersonSaver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PersonStorageTest {

    Person p1;
    Person p2;
    Person p3;

    Employee e1;
    Employee e2;

    Partner pt1;
    Partner pt2;

    private File file;
    private PersonSaver saver;
    private PersonLoader loader;


    @BeforeEach
    public void setup() throws Exception {
        file = File.createTempFile("tmp", "people");
        saver = new PersonSaver(file);
        loader = new PersonLoader(file);

        // persons
        p2 = new Person("Tom Mitch", 59);
        p1 = new Person("Hay Ward", 65);
        p3 = new Person("Web Colt", 45);

        // Employees
        e1 = new Employee("Mash Potato", 20);
        e2 = new Employee("Chip Mayo", 20);

        // Partners
        pt1 = new Partner("Mint Chip", 33);
        pt2 = new Partner("Cheese Dip", 24);
    }

    @AfterEach
    public void breakDown() {
        if (file.exists())
            file.delete();
    }

    @Test
    public void savesAndLoadsPerson() throws Exception {
        Person person = new Person("Bob", 20);

        saver.save(person);

        Assertions.assertEquals(person, loader.load());
    }

    @Test
    public void savesAndLoadsTwoPersons() throws Exception {
        saver.save(p1);
        saver.save(p2);

        Assertions.assertEquals(p1, loader.load());
        Assertions.assertEquals(p2, loader.load());
    }

    @Test
    public void savingPartnerToEmployeeArrayThrowsError() {
        Person[] people = new Partner[2];

        Assertions.assertThrows(ArrayStoreException.class, () -> {
            people[0] = e1;
            people[1] = e2;
        });

    }

    /*
        Testing lower bounded wild cards
     */
    @Test
    public void savesAndLoadsListOfPersons() throws Exception {

        // Given
        List<Partner> people = new ArrayList<>();
        people.add(pt1);
        people.add(pt2);

        // When
        saver.saveAll(people);

        // Then
        Assertions.assertEquals(pt1, loader.load());
        Assertions.assertEquals(pt1, loader.load());

    }

    /*
        Testing upper bounded wild cards
     */
    @Test
    public void saveAndLoadAllLIstOfPersons() throws Exception {
        // Given
        saver.save(p1);
        saver.save(p2);

        // When
        List<Object> persons = new ArrayList<>();
        loader.loadAll(persons);

        // Then
        Assertions.assertEquals(p1, persons.get(0));
        Assertions.assertEquals(p2, persons.get(1));
    }

}
