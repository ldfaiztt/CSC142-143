// This program finds the body mass index (BMI) for two
// individuals.  This variation includes several methods
// other than method main.

import java.util.*;

public class BMI3 {
    public static void main(String[] args) {
        giveIntro();
        Scanner console = new Scanner(System.in);
        double bmi1 = getBMI(console);
        double bmi2 = getBMI(console);
        reportResults(bmi1, bmi2);
    }

    // introduces the program to the user
    public static void giveIntro() {
        System.out.println("This program reads data for two");
        System.out.println("people and computes their body");
        System.out.println("mass index and weight status.");
        System.out.println();
    }

    // prompts for one person's statistics, returning the BMI
    public static double getBMI(Scanner console) {
        System.out.println("Enter next person's information:");
        System.out.print("height (in inches)? ");
        double height = console.nextDouble();
        System.out.print("weight (in pounds)? ");
        double weight = console.nextDouble();
        double bmi = BMIFor(height, weight);
        System.out.println();
        return bmi;
    }

    // this method contains the body mass index formula for
    // converting the given height (in inches) and weight
    // (in pounds) into a BMI
    public static double BMIFor(double height, double weight) {
        return weight / (height * height) * 703;
    }

    // reports the overall bmi values and weight status
    public static void reportResults(double bmi1,
                                     double bmi2) {
        System.out.println("Person #1 body mass index = " +
                           bmi1);
        reportStatus(bmi1);
        System.out.println("Person #2 body mass index = " +
                           bmi2);
        reportStatus(bmi2);
    }

    // reports the weight status for the given bmi value
    public static void reportStatus(double bmi) {
        if (bmi < 18.5) {
            System.out.println("underweight");
        } else if (bmi < 25) {
            System.out.println("normal");
        } else if (bmi < 30) {
            System.out.println("overweight");
        } else { // bmi >= 30
            System.out.println("obese");
        }
    }
}
