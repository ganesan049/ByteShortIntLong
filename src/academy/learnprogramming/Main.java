package academy.learnprogramming;

import problems.*;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Your year of birth:");
        boolean hasNextInt = scanner.hasNextInt();
        while (!hasNextInt){
            System.out.println("please enter your year");
            scanner.nextLine();
            hasNextInt = scanner.hasNextInt();
        }
        int dob = scanner.nextInt();
        scanner.close();
        System.out.println("Your's name is "+name+" and age is "+(2021-dob));
    }


    public static double calcFeetAndInchesToCM(double feet, double inches) {
        double ftToCM = 30.48;
        double inToCM = 2.54;
        if (feet < 0 || (inches < 0 || inches > 12)) {
            return -1;
        }
        double cm = (feet * ftToCM) + (inches * inToCM);
        System.out.println(feet + " feet + " + inches + " inches = " + cm + " CM");
        return cm;
    }

    public static double calcFeetAndInchesToCM(double inches) {
        if (inches < 0) {
            return -1;
        }
        double feet = (int) inches / 12;
        double remainingInches = inches % 12;
        System.out.println(inches + " inches = " + feet + " feet and " + remainingInches + " inches.");
        return calcFeetAndInchesToCM(feet, remainingInches);
    }
}
