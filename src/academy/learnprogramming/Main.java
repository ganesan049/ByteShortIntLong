package academy.learnprogramming;

import problems.*;

import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
//        calcFeetAndInchesToCM(157);
        System.out.println(SecondsMinutes.getDurationString(-20, 10));
        System.out.println(SecondsMinutes.getDurationString(3600));
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
