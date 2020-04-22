package collections.sets;

import collections.utilclasses.Product;

import java.util.HashSet;
import java.util.Set;

public class HashSetUsage {

    public static void main(String[] args) {
        Set<Product> products = new HashSet<>();

        Product door = new Product("Door", 45);
        Product window = new Product("Window", 25);

        products.add(door);
        products.add(door);
        products.add(door);
        products.add(door);
        products.add(window);
        products.add(window);
        products.add(window);

        System.out.println(products);
        System.out.println(products.size());

    }

}
