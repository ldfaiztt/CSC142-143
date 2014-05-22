public class BMICalculator {
    public static void main(String[] args) {
        // declare variables
        double height;
        double weight;
        double bmi;

        // compute BMI
        height = 70;
        weight = 195;
        bmi = weight / (height * height) * 703;

        // print results
        System.out.println("Current BMI:");
        System.out.println(bmi);
    }
}
