package collections.lists;

import collections.utilclasses.Product;

import java.util.ArrayList;
import java.util.List;

public class ListsUsage {

    public static void main(String[] args) {
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

    }


}
