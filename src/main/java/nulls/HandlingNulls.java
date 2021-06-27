package nulls;

import java.util.Objects;

public class HandlingNulls {

    public static void main(String[] args) {

        // we cannot initialize null to var variables
        // var obj = null;

        Nullable nullable = new Nullable();

        nullable = null;

        // basic if else block check
        if( nullable != null ) {
            System.out.println("Object is not null");
        }
        else
            System.out.println("Object is null");

        // Introduced in Java 7 - java.util.Objects
        // requireNonNull throws nullpointer exception if the object is null
        try {
            Objects.requireNonNull(nullable);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


        // Introduced in Java 8
        if ( Objects.isNull(nullable) )
            System.out.println("Object is null");
        else
            System.out.println("Object is not null");

    }

}

class Nullable {

}
