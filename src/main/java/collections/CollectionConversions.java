package collections;

import collections.lists.MyClass;

import java.util.ArrayList;

public class CollectionConversions {

    public static void main(String[] args) {

        //Converting between Collections and Arrays

        //Retrieving an Array from a collection
        ArrayList<MyClass> list = new ArrayList<>();

        list.add(new MyClass("v1","abc"));
        list.add(new MyClass("v2","xyz"));
        list.add(new MyClass("v3","abc"));

        System.out.println("Retrieve an array from a list and loop through the array to find if they are converted properly:");
        System.out.println("Using Object array with plane toArray method-");
        Object[] objArray = list.toArray();
        for (Object o:
             objArray) {
            MyClass tmp = (MyClass) o;
            System.out.println(tmp.getName());
        }
        System.out.println("Using MyClass Array with type specified-");
        MyClass[] a1 = list.toArray(new MyClass[0]);
        for (MyClass o:
                a1) {
            System.out.println(o.getName());
        }
        //We can additionally add arrays to toArray method so that it is added to the collection if possible
        // and then retrieved as an array from the collection
        MyClass[] a2 = new MyClass[3];
        MyClass[] a3 = list.toArray(a2);
        if(a2 == a3)
            System.out.println("a2 & a3 reference the same array");



    }

}

