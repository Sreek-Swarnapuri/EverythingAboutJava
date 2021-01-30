package collections;

import collections.lists.MyClass;

import java.util.ArrayList;

public class LambdaExpressions {

    public static void main(String[] args) {

        //Using forEach method

        ArrayList<MyClass> list = new ArrayList<>();

        MyClass v1 = new MyClass("v1","abc");
        MyClass v2 = new MyClass("v2","xyz");
        MyClass v3 = new MyClass("v3","abc");

        list.add(v1);
        list.add(v2);
        list.add(v3);
        System.out.println("Listing out all the names of the objects in the list:");
        list.forEach(m -> System.out.println(m.getName()));


        //Using removeIf method
        // - Iterates through each object in the collection and removes if the predicate is true

        //Remove list object with value "abc"
        System.out.println("Removing any object with value \"abc\"");
        list.removeIf(m -> m.getValue().equals("abc"));

        list.forEach(m -> System.out.println(m.getName()));

    }

}
