import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int[] dataPoints = new int[100];
        int sum = 0;
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);
        int numCorrectGuess = 0;

        for (int i = 0; i < 100; i++) {
            dataPoints[i] = rnd.nextInt(100) + 1;
        }

        int min = dataPoints[0];
        int max = dataPoints[0];

        int userInt = SafeInput.getRangedInt(in, "Enter a number between 1-100", 1, 100);

        for (int i = 0; i < 100; i++) {
            System.out.print(dataPoints[i] + " | " );
            sum += dataPoints[i];
            if (userInt == dataPoints[i]){
                numCorrectGuess += 1;
            }
            if (dataPoints[i]<min){
                min = dataPoints[i];
            } else if (dataPoints[i]>max) {
                max = dataPoints[i];
            }
        }


        int average = sum/100;
        System.out.print("\nSum of data points using inline code = " +sum+". \nAverage of data points using inline code= " +average+".");
        System.out.print("\nSum of data points using method = " +sum(dataPoints)+". \nAverage of data points using method= " +getAverage(dataPoints)+".");
        System.out.print("\nNumber of correct guesses using inline code = " +numCorrectGuess+".");
        System.out.print("\nNumber of correct guesses using method = " +occuranceScan(dataPoints,userInt));

        int userInt2 = SafeInput.getRangedInt(in, "Enter a number between 1-100", 1, 100);

        for (int i = 0; i < 100; i++) {
            if (userInt2 == dataPoints[i]){
                System.out.print("\nThe value " +userInt2+ " was found at array index " + i + " using inline code");
                break;
            } else if (i == 99) {
                System.out.print("\nThe value you chose isn't in the data points using inline code.");
            }
        }
        if (contains(dataPoints, userInt2)){
            System.out.print("\nThe value you chose is in the data points using method.");
        } else {
            System.out.print("\nThe value you chose isn't in the data points using method.");
        }

        System.out.print("\nMin number using inline code = "+ min+ ". Max number using inline code = " +max);
        System.out.print("\nMin number using method = "+ min(dataPoints)+ ". Max number using method = " +max(dataPoints));

    }
    public static double getAverage(int values[]) {
        double total = 0;
        for (double value : values) {
            total += value;
        }
        return total/values.length;
    }
    public static int min(int values[]) {
        int min = values[0];
        for (int i = 0; i < 100; i++) {
            if (values[i] < min) {
                min = values[i];
            }
        }
        return min;
    }
    public static int max(int values[]) {
        int max = values[0];
        for (int i = 0; i < 100; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }
        return max;
    }

    public static int occuranceScan(int values[], int target){
        int numCorrectGuess = 0;
        for (int i = 0; i < 100; i++) {
            if (target == values[i]){
                numCorrectGuess += 1;
            }
        }
        return numCorrectGuess;
    }
    public static int sum(int values[]) {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += values[i];
        }
        return sum;
    }
    public static boolean contains(int values[], int target) {
        boolean contains = false;
        for (int i = 0; i < 100; i++) {
            if (target == values[i]) {
                contains = true;
                break;
            }
        }
        return contains;
    }

}