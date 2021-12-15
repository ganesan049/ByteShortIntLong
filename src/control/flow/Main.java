package control.flow;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
//        System.out.println("Hello world");
//        switchFlow();
//        printNumberInWord(7);
//        System.out.println(getDaysInMonth(12,2021));
//        for (int i=8;i>=2;i--){
//            System.out.println(calculateInterest(10000,i));
//        }
//        printThreePrimeNumbers();
//        sum3And5();
//        System.out.println(sumOdd(14,14));
//        System.out.println(isOdd(-2));
//        whileFlow();
//        System.out.println(digitSum(10));
//        System.out.println(isPalindrome(-121));
//        System.out.println(sumFirstAndLastDigit(2));
//        System.out.println(getEvenDigitSum(-22));
//        System.out.println(hasSharedDigit(15,55));
//        System.out.println(hasSameLastDigit(19,99,999));
//        System.out.println(getGreatestCommonDivisior(25,15));
//    printFactors(6);
//        System.out.println(isPerfectNumber(5));
//        System.out.println(reverse(-1212));
//        numberToWords(-12);
//        System.out.println(canPack(1,0,5));
//        System.out.println(getLargestPrime(14));
//        printSquareStar(2);
//        readingUserInput();
//    minMaxChallenge();
        System.out.println(
                getBucketCount(3.26,0.75)
        );
    }
    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets){
        if(width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBuckets < 0){
            return -1;
        }
        double wallArea = width * height;
        wallArea -= (areaPerBucket*extraBuckets);
        double count = wallArea/areaPerBucket;
        return (int)Math.ceil(count);
    }
    public static int getBucketCount(double width, double height, double areaPerBucket){
        if(width <= 0 || height <= 0 || areaPerBucket <= 0){
            return -1;
        }
        double wallArea = width * height;
        double count = wallArea/areaPerBucket;
        return (int)Math.ceil(count);
    }
    public static int getBucketCount(double area, double areaPerBucket){
        if(area <= 0 || areaPerBucket <= 0){
            return -1;
        }
        double count = area/areaPerBucket;
        return (int)Math.ceil(count);
    }
    public static void minMaxChallenge(){
        Scanner scanner = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while(true){
            System.out.println("Enter Number");
            boolean hasNextInt = scanner.hasNextInt();
            if(!hasNextInt){
                break;
            }
            int enteredNumber = scanner.nextInt();
            if(enteredNumber > max){
                max = enteredNumber;
            }
            if (enteredNumber < min){
                min = enteredNumber;
            }
        }
        System.out.println("min value is "+min+" & max value is "+max);
    }
    public static void readingUserInput(){
        Scanner scanner = new Scanner(System.in);
        int count = 1;
        int sum = 1;
        while (count<=5){
            System.out.println("Enter Number #"+count);
            boolean hasNextInt = scanner.hasNextInt();
            if(hasNextInt){
                sum+=scanner.nextInt();
                count++;
            }else {
                System.out.println("Please enter valid Number");
            }
            scanner.nextLine();
        }
        System.out.println("The sum is "+sum);
        scanner.close();
    }
    public static void printSquareStar(int number){
        if(number < 5){
            System.out.println("Invalid Value");
        }else {
            for (int i = 1; i <= number; i++) {
                for (int j = 1; j <= number; j++) {
                    if (j == 1 || j == number || i == 1 || i == number || i == j || ((i + j - 1) == number)) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println("");
            }
        }
    }
    public static int getLargestPrime(int number){
        if(number<=0){
            return -1;
        }
        if(number==1){
            return 1;
        }
        int div = 2;
        while(div<number){
            if(number%div != 0){
                div++;
            }else {
                number/=div;
                div=2;
            }
        }
        return number;
    }
    public static boolean canPack(int bigCount, int smallCount, int goal){
        if(bigCount < 0 || smallCount < 0 || goal <= 0){
            return false;
        }
        int count = 0;
        while (bigCount>0){
            if(count+5 <= goal){
                count+=5;
            }else {
                break;
            }
            bigCount--;
        }
        while (smallCount>0){
            if(count < goal){
                count+=1;
            }else {
                break;
            }
            smallCount--;
        }
        if(count == goal){
            return true;
        }
        return false;
    }
    public static void numberToWords(int number){
        if(number<0){
            System.out.println("Invalid Value");
        }else {
            int digitCount = getDigitCount(number);
            int count = 0;
            int reverseNumber = reverse(number);
            while (reverseNumber>0){
                count++;
                int lastDigit = reverseNumber%10;
                switch(lastDigit){
                    case 0:
                        System.out.println("Zero");
                        break;
                    case 1:
                        System.out.println("One");
                        break;
                    case 2:
                        System.out.println("Two");
                        break;
                    case 3:
                        System.out.println("Three");
                        break;
                    case 4:
                        System.out.println("Four");
                        break;
                    case 5:
                        System.out.println("Five");
                        break;
                    case 6:
                        System.out.println("Six");
                        break;
                    case 7:
                        System.out.println("Seven");
                        break;
                    case 8:
                        System.out.println("Eight");
                        break;
                    case 9:
                        System.out.println("Nine");
                        break;
                }
                reverseNumber/=10;
            }
            if(count != digitCount){
                for (;count<digitCount;count++){
                    System.out.println("Zero");
                }
            }
        }
    }
    public static int getDigitCount(int number){
        if(number < 0) {
            return -1;
        }
        if(number < 10){
            return 1;
        }
        int count = 0;
        while (number > 0){
            number/=10;
            count++;
        }
        return count;
    }
    public static int reverse(int number){
        int reverseNumber = 0;
        boolean isNegative = number >= 0 ? false:true;
        number = Math.abs(number);
        while (number > 0){
            reverseNumber*=10;
            int lastDigit = number%10;
            reverseNumber += lastDigit;
            number/=10;
        }
        if(isNegative){
            return -(reverseNumber);
        }
        return reverseNumber;
    }
    public static boolean isPerfectNumber(int n){
        if(n<1){
            return false;
        }
        int sum=1;
        for (int i=2;i<n;i++){
            if(n%i == 0){
                sum+=i;
            }
        }
        if(sum == n){
            return true;
        }
        return false;
    }
    public static void printFactors(int n){
        if(n<1){
            System.out.println("Invalid Value");
        }else {
            System.out.println("1");
            for (int i=2;i<=n;i++){
                if(n%i == 0){
                    System.out.println(i);
                }
            }
        }
    }
    public static int getGreatestCommonDivisior(int n1, int n2){
        if(n1 < 10 || n2 < 10){
            return -1;
        }
        int minValue = n1 > n2 ? n2 : n1;
        int gcd = 1;
        for (int i=2;i<=minValue;i++){
            if(n1%i == 0 && n2%i == 0){
                gcd = i;
            }
        }
        return gcd;
    }
    public static boolean isValid(int n){
        if(n >= 10 && n<=1000){
            return true;
        }
        return false;
    }
    public static boolean hasSameLastDigit(int n1,int n2,int n3){
        if(!isValid(n1) || !isValid(n2) || !isValid(n3)){
            return false;
        }
        int lD1 = n1%10;
        int lD2 = n2%10;
        int lD3 = n3%10;

        if((lD1 == lD2) || (lD2 == lD3) || (lD1 == lD3)){
            return true;
        }
        return false;
    }
    public static boolean hasSharedDigit(int n1, int n2){
        if(!(n1 >= 10 && n1<=99) || !(n2 >= 10 && n2<=99)){
            return false;
        }
        int number = n2;
        while (n1 > 0){
            int digit1 = n1%10;
            n1/=10;
            n2 = number;
            while(n2 > 0){
                int digit2 = n2%10;
                if(digit1 == digit2){
                    return true;
                }
                n2/=10;
            }
        }
        return false;
    }
    public static int getEvenDigitSum(int number){
        if(number < 0){
            return -1;
        }
        int sum = 0;
        while(number > 0){
            int digit = number%10;
            if(digit%2 == 0){
                sum+=digit;
            }
            number/=10;
        }
        return sum;
    }
    public static int sumFirstAndLastDigit(int number){
        if(number < 0){
            return -1;
        }
        int lastDigit = number%10;
        while (number>9){
            number/=10;
        }
        return number+lastDigit;
    }
    public static boolean isPalindrome(int number){
        int reverseNumber = 0;
        number = Math.abs(number);
        int checkNumber = number;
        while (number > 0){
            reverseNumber*=10;
            int lastDigit = number%10;
            reverseNumber += lastDigit;
            number/=10;
        }
        if(reverseNumber == checkNumber){
            return true;
        }
        return false;
    }

    public static int digitSum(int number) {
        if(number < 10){
            return -1;
        }
        int sum = 0;
        while(number > 0){
            int leastDigit = (int)number%10;
            sum+=leastDigit;
            number/=10;
        }
        return sum;
    }

    public static void whileFlow(){
//        int i =1;
//        while (i != 5){
//            System.out.println(i);
//            i++;
//        }
//        do {
//            System.out.println(i);
//            i++;
//        }while (i != 5);
        int startNumber = 0;
        int endNumber = 10;
        while (startNumber <= endNumber){
//            System.out.println(startNumber);
            startNumber++;
            if(startNumber%2 != 0){
                continue;
            }
            System.out.println("Even Number is "+startNumber);
        }
    }

    public static void switchFlow(){
        int value = 3;
        switch (value){
            case 1:
                System.out.println("It's 1");
                break;
            case 2:
                System.out.println("It's 2");
                break;
            case 3:
                System.out.println("It's 3");
                break;
            default:
                System.out.println("Default value");
        }
    }

    public static void switchChallenge(){
        String value = "january";
        switch (value.toUpperCase()){
            case "A":
                System.out.println("The value is A");
                break;
            case "B":
                System.out.println("The value is B");
                break;
            case "C":
                System.out.println("The value is C");
                break;
            case "D": case "E":
                System.out.println("The value is D or E");
                break;
            case "JANUARY":
                System.out.println("The month is 1");
                break;
            default:
                System.out.println("No Value found");
        }
    }

    public static void printNumberInWord(int value){
        switch (value){
            case 0:
                System.out.println("ZERO");
                break;
            case 1:
                System.out.println("ONE");
                break;
            case 2:
                System.out.println("TWO");
                break;
            case 3:
                System.out.println("THREE");
                break;
            case 4:
                System.out.println("FOUR");
                break;
            case 5:
                System.out.println("FIVE");
                break;
            case 6:
                System.out.println("SIX");
                break;
            case 7:
                System.out.println("SEVEN");
                break;
            case 8:
                System.out.println("EIGHT");
                break;
            case 9:
                System.out.println("NINE");
                break;
            default:
                System.out.println("OTHER");
        }
    }

    public static boolean isLeapYear(int year) {
        if (year < 1 || year > 9999) {
            return false;
        }
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public static int getDaysInMonth(int month, int year){
        if((month < 1 || month > 12) || (year < 1 || year > 9999)){
            return -1;
        }
        boolean isLeapYear = isLeapYear(year);
        switch (month){
            case 2:
                if(isLeapYear){
                    return 29;
                }else {
                    return 28;
                }
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            default:
                return 30;
        }
    }

    public static double calculateInterest(double amount, double interestRate){
        return (amount*(interestRate/100));
    }

    public static void printThreePrimeNumbers(){
        int count = 0;
        for(int i=100;count <3;i++){
            if(isPrime(i)){
                System.out.println(i+" is prime number");
                count++;
            }
        }
    }

    public static boolean isPrime(int n){
        if(n == 1){
            return false;
        }
        for(int i=2; i<n/2; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }

    public static void sum3And5(){
        int sum = 0;
        int count = 0;
        for (int i=1;(i<=1000 && count < 5);i++){
            if((i%3 == 0) && (i%5 == 0)){
                sum+=i;
                System.out.println("The sum3And5 is "+i);
                count++;
            }
        }
        System.out.println("the sum result is "+sum);
    }

    public static boolean isOdd(int number){
        if(number%2 == 0 || number <= 0){
            return false;
        }
        return true;
    }
    public static int sumOdd(int start, int end){
        if(!(end >= start) || !(start > 0 && end > 0)){
            return -1;
        }
        int sum = 0;
        for (int i = start;i<=end;i++){
            if(isOdd(i)){
                sum+=i;
            }
        }
        return sum;
    }
}
