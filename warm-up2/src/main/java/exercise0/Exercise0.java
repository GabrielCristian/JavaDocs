package exercise0;
import java.util.*;
import java.lang.*;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 *
 * Exercise 0: Iterate over the keys of a Map using keySet method (this method returns a Set of all the map keys) and
 *          print all its elements.
 */
public class Exercise0 {

    public Exercise0(){

    }

    public void iterateThroughMap(){

        // TODO Exercise #0 a) Create a Map (HashMap) and add elements to it (using put() method)
        Map<Integer, String> map = new HashMap<Integer, String>();
        // TODO Exercise #0 a) Hint: Don't forget to specify the types of the key and value when creating the Map
        map.put(1,"first");
        map.put(2,"second");
        map.put(3,"third");
        // TODO Exercise #0 b) Iterate over the Map using keySet() method and print all its elements
        Iterator iterator = map.keySet().iterator();
        System.out.print("[");
        while(iterator.hasNext()) {
            Integer i = (Integer) iterator.next();
            System.out.print(i + "=" + map.get(i));
            if(iterator.hasNext()) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        // TODO Exercise #0 b) The elements could be printed like this: [key1=value1, key2=value2, ...]


    }

    public static void main(String[] args) {
        Exercise0 exercise0 = new Exercise0();
        exercise0.iterateThroughMap();
    }
}
