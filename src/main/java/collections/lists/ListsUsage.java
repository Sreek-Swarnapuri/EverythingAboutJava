package collections.lists;

import collections.utilclasses.Product;
import collections.utilclasses.Shipment;

import java.util.ArrayList;
import java.util.List;

public class ListsUsage {

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

    }


}
