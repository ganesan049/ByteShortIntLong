package academy.learnprogramming;

import problems.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
        }};
        int result = 1;
        for (int s=0;s<A.size();s++){
            result = result * A.get(s);
        }
        for(int i=0;i<A.size()-1;i++){
            for (int j=i;j<A.size();j++){
                if(A.get(i) != A.get(j)){
                    result = result * gcd(A.get(i),A.get(j));
                }
            }
        }
        System.out.println(result);
    }
    public static int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }
}
//        System.out.println("ab\raba\r");
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter your name: ");
//        String name = scanner.nextLine();
//        System.out.println("Enter Your year of birth:");
//        boolean hasNextInt = scanner.hasNextInt();
//        while (!hasNextInt){
//            System.out.println("please enter your year");
//            scanner.nextLine();
//            hasNextInt = scanner.hasNextInt();
//        }
//        int dob = scanner.nextInt();
//        scanner.close();
//        System.out.println("Your's name is "+name+" and age is "+(2021-dob));
//    }
//
//
//    public static double calcFeetAndInchesToCM(double feet, double inches) {
//        double ftToCM = 30.48;
//        double inToCM = 2.54;
//        if (feet < 0 || (inches < 0 || inches > 12)) {
//            return -1;
//        }
//        double cm = (feet * ftToCM) + (inches * inToCM);
//        System.out.println(feet + " feet + " + inches + " inches = " + cm + " CM");
//        return cm;
//    }
//
//    public static double calcFeetAndInchesToCM(double inches) {
//        if (inches < 0) {
//            return -1;
//        }
//        double feet = (int) inches / 12;
//        double remainingInches = inches % 12;
//        System.out.println(inches + " inches = " + feet + " feet and " + remainingInches + " inches.");
//        return calcFeetAndInchesToCM(feet, remainingInches);
//    }
//}
