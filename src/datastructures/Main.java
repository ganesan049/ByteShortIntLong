package datastructures;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Integer integer = 45;
        System.out.println(integer.getClass().getSimpleName());
        int value = integer.intValue();
        System.out.println(value);

//        System.out.println("Enter length of numbers");
//        int length = scanner.nextInt();
//        int[] myIntArray = readInteger(length);
//        int[] myIntArray = {1,2,3,4,5};
//        int[] reverseArray = reverseArray(myIntArray);
//        System.out.println("Reversed array is "+Arrays.toString(reverseArray));
//        int minValue = getMin(myIntArray);
//        System.out.println("The min value is "+minValue);
//        int[] myIntArray = {1,2,3,4,5};
//        int[] myIntArray = readInteger(5);
//        sortArray(myIntArray);
//        printArray(myIntArray);
//        printAverage(myIntArray);
    }

    private static int[] reverseArray(int[] myIntArray) {
        int[] revArray = new int[myIntArray.length];
        for (int i=0;i<myIntArray.length;i++){
            revArray[i] = myIntArray[myIntArray.length-1-i];
        }
        return revArray;
    }

    private static int getMin(int[] myIntArray) {
        int minValue = Integer.MAX_VALUE;
        for (int i=0;i<myIntArray.length;i++){
            if(minValue > myIntArray[i]){
                minValue = myIntArray[i];
            }
        }
        return minValue;
    }

    public static int[] readInteger(int length){
        int[] myIntArray = new int[length];
        for (int i=0;i<length;i++){
            myIntArray[i] = scanner.nextInt();
        }
        return myIntArray;
    }

    public static void printArray(int[] array){
//        for(int i=0;i<array.length;i++){
//            System.out.println("Element in "+(i+1)+" is "+array[i]);
//        }
        System.out.println(Arrays.toString(array));
    }

    public static void printAverage(int[] array){
        int sum = 0;
        for (int i=0;i<array.length;i++){
            sum+=array[i];
        }
        System.out.println("Average is "+sum/array.length);
    }

    public static void sortArray(int[] array){
        int[] sortArray = new int[array.length];
//        for (int i=0;i<array.length;i++){
//            int currElem = array[i];
//            for (int j=(i+1);j<array.length;j++){
//                if(array[j] > currElem){
//                    int tmp = array[j];
//                    array[j] = array[i];
//                    array[i] = tmp;
//                }
//            }
//        }
        boolean flag = true;
        while (flag){
            flag = false;
            for (int i=0;i<array.length-1;i++){
                if(array[i+1] > array[i]){
                    int tmp = array[i+1];
                    array[i+1] = array[i];
                    array[i] = tmp;
                    flag = true;
                }
            }
        }
        printArray(array);
    }
}
