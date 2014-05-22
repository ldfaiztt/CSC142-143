// This client program tests our hash set of integers
// by adding and removing several elements from it.

import java.util.Arrays;

public class HashMain {
    public static void main(String[] args) {
        HashIntSet set = new HashIntSet();
        set.add(7);
        set.add(5);
        set.add(1);
        set.add(9);
        
        // test adding duplicates
        set.add(7);
        set.add(7);
        set.add(5);
        
        // test collisions and linked lists
        set.add(45);
        set.add(91);
        set.add(71);
        
        // test rehashing
        set.add(810);   // re-hash should occur here (8/10, load = 0.8)
        set.add(62);
        set.add(1238);
        set.add(-99);
        set.add(-30);
        set.add(42);
        set.add(49857);
        set.add(1520);  // re-hash should occur here (15/20, load = 0.75)
        set.add(2);
        set.add(31);
        set.add(11);
        set.add(21);
        
        // test removal
        set.remove(7);
        set.remove(9);
        set.remove(1);
        set.remove(1);
        set.remove(21);
        set.remove(71);
        
        for (int n : new int[] {1520, 99, 2, 55, 42, 11, 45, 0, 5, -10, 810}) {
			System.out.println("contains " + n + "? " + set.contains(n));
		}
        
        System.out.println(set + ", size " + set.size());
    }
}
