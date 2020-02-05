package collections;

import collections.utilclasses.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionConcepts {

    public static void main(String[] args){

        Product door = new Product("Wooden Door", 35);
        Product chair = new Product("Plastic Chair", 3);
        Product window = new Product("Glass Window", 20);

        Collection<Product> products = new ArrayList<>();

        products.add(door);
        products.add(chair);
        products.add(window);

        System.out.println("Printing the list of products at once:");
        System.out.println("--------------------------------------");
        System.out.println(products);

        System.out.println();

        System.out.println("Printing the list of products one at a time using Iterator:");
        System.out.println("-----------------------------------------------------------");
        final Iterator<Product> productIterator = products.iterator();
        //Common coding pattern to iterate all collections is to use .hasNext()
        while(productIterator.hasNext()){
            Product product = productIterator.next();
            System.out.println(product);
            if(product.getWeight() < 25)
                productIterator.remove();
        }

        System.out.println();

        System.out.println("Printing the list of products one at a time using foreach loop introduced in Java 5:");
        System.out.println("------------------------------------------------------------------------------------");
        for (Product product:
             products) {
            System.out.println(product);
        }

    }

}
