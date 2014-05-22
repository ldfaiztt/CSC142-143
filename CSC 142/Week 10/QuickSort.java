/**
 * Class to illustrate the Quick Sort algorithm.  Run the test method
 */
public class QuickSort{
  
  /** test method to sort some data */
  public static void test() {
    int[] values = {32, 4, 7, 17, -9, 8, 0, 100, 14, 22, 3, -99};
    quickSort(values, 0, values.length -1);
    
    // print the first element w/o a commma
    System.out.print(values[0]);
    
    //Now the rest of the data, separated by commas
    for (int i = 1; i < values.length; i++)
      System.out.print(", " + values[i]);
    System.out.println();
  }

  
  /**
   * Sorts data in the array from index lo to index hi using the Quick Sort algorithm
   * @param stuff contains the data to be sorted
   * @param lo the lower index of the data to be sorted
   * @param hi the upper index of the data to be sorted.
   */
  public static void quickSort(int[ ] stuff, int lo, int hi) {
    // quit if empty partition or there's only 1 value. This is the base case
    if (lo >= hi) 
      return;
    
    // partition array and return pivot loc
    int pivotLocation = partition(stuff, lo, hi);
    
    // 2 recursive calls to sort the lower half and the upper half
    quickSort(stuff, lo, pivotLocation-1);
    quickSort(stuff, pivotLocation+1, hi);
  }
  
  /** partitions, or moves the data in the array around a pivot value. All values lower than the
    * pivot value will be in lower indices than the pivot value. All values higher than the pivot
    * value will be in higher indices than the pivot value.
    * @param data contains the values to be partitioned
    * @param lo the lower index of the data to be partitioned
    * @param hi the upper index of the data to be partitioned
    * @return the index of where the pivot value finally ended up.
    */
  private static int partition(int[ ] data, int lo, int hi){
    if(lo > hi) throw new IllegalArgumentException();
    
    // all indexes between L & R, inclusive, haven't been partitioned yet
    int L = lo+1, R = hi;
    int pivot = data[lo];  // choose the first value as the pivot value
    while (L <= R) {
      if (pivot > data[L])   L++;
      else if (pivot < data[R])   R--;
      else { 
        swap(data, L, R); 
        L++; R--;
      }
    }
    // put pivot element in middle & return its index 
    swap(data, lo,L-1);
    return L-1;
  }
  
  // swaps two values in an array, at indexes idx1 and idx2
  private static void swap (int[] arr, int idx1, int idx2){
    int temp = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = temp;
  }

}