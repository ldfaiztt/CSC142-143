public class Equal {
    public static void main(String[] args) {
        int[] a1 = {1, 4, 9, 16, 25};
        int[] a2 = {-1, 2, -3, 4, -5};
        int[] a3 = {1, 4, 9, 16, 25};
        int[] a4 = {0, 0, 0};
        
        System.out.println("a1 equals a2? " + equal(a1, a2));
        System.out.println("a1 equals a3? " + equal(a1, a3));
        System.out.println("a2 equals a3? " + equal(a2, a3));
        System.out.println("a2 equals a2? " + equal(a2, a2));
        System.out.println("a1 equals a4? " + equal(a1, a4));
        System.out.println("a4 equals a1? " + equal(a4, a1));
    }
    
    public static boolean equal(int[] array1, int[] array2) {
        if (array1.length != array2.length)
            return false;
        
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i])
                return false;
        }
        return true;
    }
}