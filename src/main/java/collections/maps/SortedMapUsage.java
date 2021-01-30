package collections.maps;

import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapUsage {

    public static void main(String[] args) {

        SortedMap<String, String> map = new TreeMap<>();

        map.put("7777","abc");
        map.put("8888","def");
        map.put("3333","mno");
        map.put("6666","jkl");
        map.put("1111","ghi");
        map.put("4444","pqr");
        map.put("2222","stu");
        map.put("5555","vwx");

        System.out.println("Printing the Sorted map by using foreach loop:");
        map.forEach((k,v) -> System.out.println(k+"<->"+v));

        //Creating a Sorted Map with the headMap function with the key "3333"
        //This creates the sorted map with key value pairs that are LESS than the key "3333" EXCLUSIVE of it
        SortedMap<String, String> hMap = map.headMap("3333");
        System.out.println("Printing out SortedMap created from headMap method of the main SortedMap:");
        hMap.forEach((k,v) -> System.out.println(k+"<->"+v));

        //Creating a Sorted Map with the tailMap function with the key "3333"
        //This creates the sorted map with key value pairs that are MORE than the key "3333" INCLUSIVE of it
        SortedMap<String, String> tMap = map.tailMap("3333");
        System.out.println("Printing out SortedMap created from tailMap method of the main SortedMap:");
        tMap.forEach((k,v) -> System.out.println(k+"<->"+v));

    }

}