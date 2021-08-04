package nulls.null_object_pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class NullObjectPatternImplementation {


    public static void main(String[] args) {

        Book b1 = new Book("book 1", new LexicleReadingLevel());
        System.out.println("reading level of book 1 is " + b1.getReadingLevel());
        Book b2 = new Book("book 2", new DRAReadingLevel());
        System.out.println("reading level of book 2 is " + b2.getReadingLevel());
        Book b3 = new Book("book 3", null);
        System.out.println("reading level of book 3 is " + b3.getReadingLevel());
    }

}

@AllArgsConstructor
class Book {

    @Getter
    @Setter
    private String name;

    @Setter
    private ReadingLevel readingLevel;

    public ReadingLevel getReadingLevel() {
        return readingLevel != null
                ? readingLevel
                : NullReadingLevel.getInstance();
    }

}


@Getter
@Setter
abstract class ReadingLevel {

    private String level;

}

class LexicleReadingLevel extends ReadingLevel {

    public LexicleReadingLevel() {
        setLevel("Lexile Reading Level");
    }

    @Override
    public String toString() {
        return getLevel();
    }

}

class DRAReadingLevel extends ReadingLevel {

    public DRAReadingLevel() {
        setLevel("DRA Reading Level");
    }

    @Override
    public String toString() {
        return getLevel();
    }

}

class NullReadingLevel extends ReadingLevel {

    private static  NullReadingLevel instance = new NullReadingLevel();

    private NullReadingLevel() {
        setLevel("No reading level set");
    }


    public static NullReadingLevel getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return getLevel();
    }
}