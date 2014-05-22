public class ArrayIntList1_static {
    private static int[] elementData;
    private static int size;

    public ArrayIntList1_static() {
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
    
public int min() {
    if (size == 0) {
        throw new IllegalStateException();
    }
    int minValue = elementData[0];
    for (int i = 1; i < size; i++) {
        minValue = Math.min(minValue, elementData[i]);
    }
    return minValue;
}

public int max() {
    if (size == 0) {
        throw new IllegalStateException();
    }
    int maxValue = elementData[0];
    for (int i = 1; i < size; i++) {
        maxValue = Math.max(maxValue, elementData[i]);
    }
    return maxValue;
}
}
