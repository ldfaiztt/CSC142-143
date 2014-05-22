import java.util.*;

/**
 * Selection Sort implemented on an ArrayList.
 * Sorts Integers in descending order.
 * 
 * @author CSC 142
 * @version Fall 2011
 */
public class ArrayListSort
{
    /**
     * Test the sort method.
     */
    public static void main(String[] args) {
        // create the ArrayList object
        ArrayList<Integer> list = new ArrayList<Integer>();

        // initialise the ArrayList with random values; random length 2-11
        int count = 2 + (int) (10 * Math.random());
        for(int i = 0; i < count; i++)
            list.add( (int)(100 * Math.random()) );
        
        display(list);
        sort(list);  // changes the order of the items
        display(list);     
    }
    
    /** 
     * Sorts the provided ArrayList in DESCENDING order using the SELECTION SORT algorithm.
     * @param list the ArrayList to sort
     */
    public static void sort(ArrayList<Integer> list){
        // make n-1 passes
        for( int top = 0; top < list.size() - 1; top++){
            // find largest starting from top
            int indexLargest = top;
            for( int i = top; i < list.size(); i++)
                if( list.get( i ) > list.get( indexLargest ) )   // thanks to auto-boxing feature!
                    indexLargest = i;
           
            // swap top and largest - notice the usage of the set() method!
            Integer temp = list.get( top );
            list.set( top, list.get( indexLargest ) );
            list.set( indexLargest, temp );
        }            
    }
   
    /**
     * Displays the contents of an ArrayList on the console.
     * @param list the ArrayList to display
     */
    public static void display(ArrayList<Integer> list)
    {
        Iterator<Integer>it = list.iterator();
        while(it.hasNext())
            System.out.print( " " + it.next() );
        System.out.println();
    }
}
