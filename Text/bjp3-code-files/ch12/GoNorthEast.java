// Sample backtracking program.  The user is prompted for an (x, y) position
// and the program uses backtracking to find all possible paths to that
// location using moves of N, NE, and E.

import java.util.*;

public class GoNorthEast {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Target x and y location? ");
        int x = console.nextInt();
        int y = console.nextInt();
        System.out.println();
        travel(x, y);
    }

    public static void travel(int targetX, int targetY) {
        travel(targetX, targetY, 0, 0, "moves:");
    }

    private static void travel(int targetX, int targetY,
                               int currX, int currY, String path) {
        if (currX == targetX && currY == targetY) {
            System.out.println(path);
        } else if (currX <= targetX && currY <= targetY) {
            travel(targetX, targetY, currX, currY + 1, path + " N");
            travel(targetX, targetY, currX + 1, currY, path + " E");
            travel(targetX, targetY, currX + 1, currY + 1, path + " NE");
        }
    }
}