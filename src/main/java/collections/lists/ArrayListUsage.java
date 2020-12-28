package collections.lists;

import collections.utilclasses.Product;
import collections.utilclasses.Shipment;

import java.util.ArrayList;
import java.util.List;

public class ArrayListUsage {

    public static void main(String[] args) {

        //Basic usage of Lists using Array List
        List<Product> products = new ArrayList();

        //Adding a product at the end
        products.add(new Product("Window", 12) );
        products.add(new Product("chair", 5) );
        products.add(new Product("Window", 12) );
        System.out.println(products);

        //Adding a product at a particular index
        products.add(2,new Product("Bed", 40));
        System.out.println(products);
        products.add(1,new Product("Table", 50));
        System.out.println(products);


        // Creating and adding products to the shipment which implements Iterable.
        Product door = new Product("Wooden Door", 35);
        Product floorPanel = new Product("Floor Panel", 25);
        Product window = new Product("Glass Window", 10);

        Shipment shipment = new Shipment();

        // Adding products to shipment:
        System.out.println("Usage of adding elements onto a list:");
        shipment.add(door);
        shipment.add(window);

        System.out.println(shipment);

        // Replacing products in the Shipment:
        shipment = new Shipment();
        System.out.println("Usage of replacing elements in a list:");
        shipment.add(window);
        shipment.replace(door,floorPanel);
        shipment.replace(window,floorPanel);
        System.out.println(shipment);

        //Using sublists to divide the shipment to Heavy van products and Light van products
        System.out.println("Usage of sub lists from a list:");
        shipment = new Shipment();
        shipment.add(door);
        shipment.add(floorPanel);
        shipment.add(window);

        shipment.prepare();
        System.out.println("Light Van products: " +shipment.getLightVanProducts());
        System.out.println("Heavy Van products: " +shipment.getHeavyVanProducts());


        //ArrayList without any type associated
        System.out.println("-----------------");
        System.out.println("ArrayList without any type associated:");
        ArrayList list = new ArrayList();

        list.add(1);
        list.add("Test");
        list.add("Test1");

        for (Object o:
             list) {
            System.out.println(o);
        }

        String s = (String)list.get(1);
        System.out.println(s);

        //ArrayLIst with type association
        System.out.println("----------------------");
        System.out.println("ArrayLIst with type association:");
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("Foo");
        list1.add("Bar");
        for (String st:
             list1) {
            System.out.println(st);
        }

        System.out.println("----------------------");
        System.out.println("ArrayList uses the equals method built in the class to compare and remove elements");
        ArrayList<MyClass> classList = new ArrayList<>();

        MyClass v1 = new MyClass("v1","abc");
        MyClass v2 = new MyClass("v2","abc");
        MyClass v3 = new MyClass("v3","abc");

        classList.add(v2);
        classList.add(v3);
        classList.add(v1);

        classList.remove(v3);

        for (MyClass c:
             classList) {
            System.out.println(c.name);
        }

        System.out.println("Iterating through the list using foreach:");
        classList.forEach(ele -> System.out.println(ele.name));
        System.out.println("Iterating through the list using lamdbda and removing all elements using removeif that match the condition:");
        classList = new ArrayList<>();
        v1 = new MyClass("v1","abc");
        v2 = new MyClass("v2","xyz");
        v3 = new MyClass("v3","abc");
        classList.add(v1);
        classList.add(v2);
        classList.add(v3);
        classList.removeIf(ele -> ele.value.equals("abc"));
        classList.forEach(ele -> System.out.println(ele.name));

    }

}