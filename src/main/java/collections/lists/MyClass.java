package collections.lists;

import lombok.Getter;

@Getter
public class MyClass {

    String name;
    String value;

    public MyClass(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public boolean equals(Object o) {
        MyClass other = (MyClass) o;

        return this.value.equalsIgnoreCase(other.value);
    }

}
