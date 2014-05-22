/**
 * This class creates an array of random integers then
 * uses the Insertion Sort algorithm to sort the array.
 * It sorts in descending order.
 * 
 * @author CSC 142
 * @version Fall 2011
 */
public class InsertionSortDemo
{
    /**
     * Test the insertionSort method.
     */
    public static void main(String[] args) {
        // create the array object
        int[] array = new int[10];

        // initialise the array with random values
        for(int i = 0; i < array.length; i++)
            array[i] = (int) (100 * Math.random());
        
        display(array);
        insertionSort(array);  // changes the order of the elements
        display(array);     
    }

    /**
     * Sorts the provided array in DESCENDING order using the INSERTION SORT algorithm.
     * @param arr the array to sort
     */
    public static void insertionSort(int[] arr) {
        int temp;
        // make n-1 passes, numbered 1 to n-1
        for ( int j = 1; j < arr.length; j++){
            // repeatedly insert the element at index j into the 
            // already-sorted portion of the array
            insert(arr, j);       
        }
    }

    /**
     * Insert the value at index j, into the array x
     * Precondition: x is sorted from [0...j-1]
     * @param x the partially-sorted array
     * @param j the index of the next element to be "inserted"
     */
    public static void insert(int[] x, int j) {
        int i, temp = x[j];
        for(i = j ; i > 0 && temp > x[i - 1]; i--) 
            x[i] = x[i - 1];      // shift
        x[i] = temp;              // insert
    }
    
    /**
     * Displays the contents of an int array on the console.
     * @param arr the array to display
     */
    public static void display(int[] arr){
      for(int i = 0; i < arr.length; i++)
        System.out.print (" " + arr[i]);
      System.out.println();
    }    
}
