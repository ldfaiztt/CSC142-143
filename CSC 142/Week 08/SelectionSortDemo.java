
/**
 * This class creates an array of random integers then
 * uses the Selection Sort algorithm to sort the array.
 * It sorts in descending order.
 * 
 * @author CSC 142
 * @version Fall 2011
 */
public class SelectionSortDemo
{
    /**
     * Test the selectionSort method.
     */
    public static void main(String[] args) {
        // create the array object
        int[] array = new int[10];

        // initialise the array with random values
        for(int i = 0; i < array.length; i++)
            array[i] = (int) (100 * Math.random());
        
        display(array);
        selectionSort(array);  // changes the order of the elements
        display(array);     
    }

    /** 
     * Sorts the provided array in DESCENDING order using the SELECTION SORT algorithm.
     * @param arr the array to sort
     */
    public static void selectionSort(int[] arr) {
      // make n-1 passes
      for (int top = 0; top < arr.length-1; top++){
        // find the largest in the remaining list (list starts at index top)
        int largeIndex = top;
        for (int i = top + 1; i < arr.length; i++){
          if(arr[i] > arr[largeIndex])
            largeIndex = i;
        }
        
        // swap largest with top
        int temp = arr[top];
        arr[top] = arr[largeIndex];
        arr[largeIndex] = temp;
      }
    }

    /**
     * Displays the contents of an int array on the console.
     * @param arr the array to display
     */
    public static void display(int[] arr) {
      for(int i = 0; i < arr.length; i++)
        System.out.print (" " + arr[i]);
      System.out.println();
    }
}
