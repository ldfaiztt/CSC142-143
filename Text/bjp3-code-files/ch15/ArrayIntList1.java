public class ArrayIntList {
    private int[] elementData;
    private int size;

    public ArrayIntList() {
        elementData = new int[100];
        size = 0;
    }

    public void add(int value) {
        elementData[size] = value;
        size++;
    }

    public void print() {
        if (size == 0) {
            System.out.println("[]");
        } else {
            System.out.print("[" + elementData[0]);
            for (int i = 1; i < size; i++)
                System.out.print(", " + elementData[i]);
            System.out.println("]");
        }
    }
}
