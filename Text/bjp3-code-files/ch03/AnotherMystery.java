public class AnotherMystery {
    public static void printRange(char start, char end) {
        for (char letter = start; letter <= end; letter++) {
            System.out.print(letter);
        }
    }
    
    public static void main(String[] args) {
        printRange('e', 'g');
        printRange('n', 's');
        System.out.println();

        printRange('z', 'a');
        System.out.println();

        printRange('q', 'r');
        System.out.println();
    }
}
