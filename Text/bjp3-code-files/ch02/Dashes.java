public  class Dashes {
    public static void main(String[] args) {
        for (int row = 1; row <= 5; row++) {
            for (int column = 1; column <= 15; column++) {
                System.out.print("|");
                for (int dashes = 1; dashes <= 3; dashes++) {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }
}
