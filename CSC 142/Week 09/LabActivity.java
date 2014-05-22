import java.util.*;
/**
 * Practice working with ArrayList and HashMap objects.
 * @author Chun-Wei Chen
 * @version 12/01/11
 */
public class LabActivity {
  public static void main(String[] args) {
    // create and show an ArrayList filled with Integers
    ArrayList<Integer> t2 = new ArrayList<Integer>(Arrays.asList(3,3,4,3,6,4,7,4,4,3,2,4,4,4,4,3,2,2));
    System.out.println(t2);
    // remove the duplicates and show the result
    removeDuplicates(t2);
    System.out.println(t2);
    
    // create and populate a HashMap with some duplicate values
    HashMap<Integer, String> t3 = new HashMap<Integer, String>();
    String[] words = {"test", "free", "ready", "never", "test", "yo", "test", "test"};
    int num = 1;
    for (String word : words) {
      t3.put(num, word);
      num++;
    }
    // show the complete map
    System.out.println(t3);
    // remove the duplicates and show the result
    showMappingsByValue(t3, "test");
    showMappingsByValue(t3, "yo");
    showMappingsByValue(t3, "not");
  }
  
  /**
   * Remove any duplicate values from the list
   * @param list the name of the ArrayList
   */
  public static void removeDuplicates(ArrayList<Integer> list) {
    for (int i = 0; i < list.size() - 1; i++) {
      for (int j = i + 1; j < list.size(); j++) {
        if (list.get(i) == list.get(j)) {
          list.remove(j);
          j--;
        }
      }
    }
  }
  
  /**
   * Find out if the target is in the Hashmap.
   * @param map the name of the HashMap
   * @param target the value that the user wants to find
   */
  public static void showMappingsByValue(HashMap<Integer, String> map, String target) {
    Set<Integer> nums = map.keySet();
    if (map.containsValue(target)) {
      for (Integer num : nums) {
        if (map.get(num).equals(target))
            System.out.println("Target \"" + target + "\" is assoconated with key " + num);
      }
    }
    else
      System.out.println("Target \"" + target + "\" not found in the map.");
  }
}
    