package collections.lists;

import collections.utilclasses.Product;

import java.util.HashSet;
import java.util.Set;

public class HashSetUsage {

    public static void main(String[] args) {
        Set<Product> products = new HashSet<>();

        products.add(new Product("Door", 45));
        products.add(new Product("Door", 45));
        products.add(new Product("Door", 45));
        products.add(new Product("Door", 45));
        products.add(new Product("Window", 25));
        products.add(new Product("Window", 25));
        products.add(new Product("Window", 25));

        System.out.println(products);

    }

}
