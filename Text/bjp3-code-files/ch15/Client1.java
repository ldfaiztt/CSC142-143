public class Client1 {
    public static void main(String[] args) {
        // construct two lists
        ArrayIntList list1 = new ArrayIntList();
        ArrayIntList list2 = new ArrayIntList();

        // add 1, 82, 97 to list1
        list1.add(1);
        list1.add(82);
        list1.add(97);

        // add 7, -8 to list2
        list2.add(7);
        list2.add(-8);

        // report results
        list1.print();
        list2.print();
    }
}
