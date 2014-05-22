// This program finds the body mass index (BMI) for two
// individuals.

import java.util.*;

public class BMI2 {
    public static void main(String[] args) {
        System.out.println("This program reads data for two");
        System.out.println("people and computes their body");
        System.out.println("mass index and weight status.");
        System.out.println();

        Scanner console = new Scanner(System.in);

        System.out.println("Enter next person's information:");
        System.out.print("height (in inches)? ");
        double height1 = console.nextDouble();
        System.out.print("weight (in pounds)? ");
        double weight1 = console.nextDouble();
        double bmi1 = weight1 / (height1 * height1) * 703;
        System.out.println();

        System.out.println("Enter next person's information:");
        System.out.print("height (in inches)? ");
        double height2 = console.nextDouble();
        System.out.print("weight (in pounds)? ");
        double weight2 = console.nextDouble();
        double bmi2 = weight2 / (height2 * height2) * 703;
        System.out.println();

        System.out.println("Person #1 body mass index = " +
                           bmi1);
        if (bmi1 < 18.5) {
            System.out.println("underweight");
        } else if (bmi1 < 25) {
            System.out.println("normal");
        } else if (bmi1 < 30) {
            System.out.println("overweight");
        } else { // bmi1 >= 30
            System.out.println("obese");
        }

        System.out.println("Person #2 body mass index = " +
                           bmi2);
        if (bmi2 < 18.5) {
            System.out.println("underweight");
        } else if (bmi2 < 25) {
            System.out.println("normal");
        } else if (bmi2 < 30) {
            System.out.println("overweight");
        } else { // bmi2 >= 30
            System.out.println("obese");
        }
    }
}
