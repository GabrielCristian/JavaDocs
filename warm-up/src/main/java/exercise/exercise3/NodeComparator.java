package exercise.exercise3;
import java.util.*;
/**
 * Created by user on 7/1/2016.
 */
 public class NodeComparator implements Comparator<String> {
    public int compare(String o1, String o2) {
        return (o1.length()-o2.length());
    }
}