// Sample program with arrays passed as parameters

public class IncrementOdds {
    public static void main(String[] args) {
        int[] list = buildOddArray(5);
        incrementAll(list);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

    // returns array of given size composed of consecutive odds
    public static int[] buildOddArray(int size) {
        int[] data = new int[size];
        for (int i = 0; i < data.length; i++) {
            data[i] = 2 * i + 1;
        }
        return data;
    }

    // adds one to each array element
    public static void incrementAll(int[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i]++;
        }
    }
}