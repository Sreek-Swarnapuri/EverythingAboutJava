package collections.maps;

import java.util.HashMap;
import java.util.Map;

public class HashMapUsage {

    public static void main(String[] args){

        /*
        Java HashMap is a hash table(a DS that implements Associative arrays abstract data type) based implementation of Java's Map interface.
        A Map is a collection of key-value pairs. It maps keys to values.
        Key points
        ----------
        - HashMap cannot contain duplicate keys.
        - Java HashMap allows null values and null key.
        - HashMap is an unordered collection. It does not guarantee any specific order of the elements.
        - Java HashMap is not thread-safe. You must explicitly synchronize concurrent modifications to the HashMap.
         */

        //CREATING HM AND ADDING K-V PAIRS TO IT
        //--------------------------------------
        System.out.println("CREATING HM AND ADDING PAIRS TO IT");
        System.out.println("----------------------------------");


        //creating HM
        Map<String, Integer> numberMapping = new HashMap<>();

        //Adding key-value pairs to a HashMap
        numberMapping.put("One", 1);
        numberMapping.put("Two", 2);
        numberMapping.put("Three",3);
        numberMapping.put("Four",null);
        numberMapping.put(null,5);
        System.out.println(numberMapping);

        //Updates
        //Adds a key-value pair only if
        numberMapping.putIfAbsent("Four",4);
        numberMapping.putIfAbsent("Five",5);
        System.out.println(numberMapping);

        //ACCESSING KEYS AND MODIFYING ASSOCIATED VALUES
        /*----------------------------------------------
        - isEmpty() - check if a HashMap is empty
        - size() - get the size of the HashMap
        - containsKey() - check if a given key exists in HM
        - containsValue() - check if a give value exists in HM
        - get() - get the value associated with a given key in HM
        - put() - insert new pair or modify the value of an existing pair for a given key in HM
         */
        System.out.println("ACCESSING KEYS AND MODIFYING ASSOCIATED VALUES");
        System.out.println("----------------------------------------------");


        Map<String, String> userCityMapping = new HashMap<>();

        //Check if the HM is empty
        System.out.println("is usercityMapping HashMap Empty? " + userCityMapping.isEmpty());

        userCityMapping.put("Vinay","New York");
        userCityMapping.put("Satya","Canada");
        userCityMapping.put("Venky","Sweden");

        System.out.println("UserCityMapping HashMap: " + userCityMapping);
        //Find the size of the hashmap
        System.out.println("Size of the HashMap: " + userCityMapping.size());

        String userName = "Satya";
        //Check if a key exists in the HM
        if( userCityMapping.containsKey(userName) ){
            //get the value assigned to the given key
            String userCity = userCityMapping.get(userName);
            System.out.println(userName + " lives in " + userCity);
        }
        else{
            System.out.print("City detail not found for user - " + userName);
        }

        //Check if a value exists in a HashMap
        if(userCityMapping.containsValue("New York"))
            System.out.println("There is a user in New York");
        else
            System.out.println("There is no user in New York");

        //Modify the value assigned to an existing key
        userCityMapping.put(userName,"Las Vegas");
        System.out.println(userName + " has moved to a new city - " + userCityMapping.get(userName) + ", new user city mapping - " + userCityMapping);

        //get() returns null if the key is not present in the HM
        System.out.println("Lisa's city: " +userCityMapping.get("Lisa"));


        //REMOVING KEYS FROM HM
        /*---------------------
         * - remove(Object key) - Removes a key from HM
         * - remove(Object key, Object value) - Removes a key only if it is associated with a give value
         * */
        System.out.println("REMOVING KEYS FROM HM");
        System.out.println("---------------------");


        Map<String,String> husbandWifeMapping = new HashMap<>();

        husbandWifeMapping.put("Tom","Jill");
        husbandWifeMapping.put("Chris","Lisa");
        husbandWifeMapping.put("Patrick","Nino");
        husbandWifeMapping.put("Josh","Linda");
        husbandWifeMapping.put("Sreekar","Vandana");

        System.out.println("Husband Wife mapping: " + husbandWifeMapping);

        //Remove key from HM
        //Unfortunately Chris got divorced. Let's remove him from HM
        String husband = "Chris";
        String wife =  husbandWifeMapping.remove(husband);

        System.out.println("Couple (" + husband+ ", " + wife + ") got divorced.");
        System.out.println("New Mapping: " + husbandWifeMapping);

        //Remove a key only if it is mapped to a given value
        //Ex - Divorce Josh only if he is married to Linda
        boolean isRemoved = husbandWifeMapping.remove("Josh","Linda");

        System.out.println("Did Josh get removed from Mapping? " + isRemoved);

        //remove returns null if the mapping was not found for the supplied key
        wife = husbandWifeMapping.remove("David");
        if(wife == null)
            System.out.println("Looks like David is not married to anyone.");
        else
            System.out.println("Removed David and his wife from the mapping");

        //Looping through each couple:
        System.out.println("Looping through each couple:");
        husbandWifeMapping.forEach( (h,w) -> System.out.println(h + " is married to " + w ));

        System.out.println("Upper casing names of wives:");
        husbandWifeMapping.replaceAll((h,w) -> (w.toUpperCase()) );
        husbandWifeMapping.forEach( (h,w) -> System.out.println(h + " is married to " + w ));

    }

}