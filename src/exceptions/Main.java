package exceptions;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.println(devideLBYL(5,0));
//        System.out.println(devideEAFP(5,0));
        int x;
//        x = getInt();
//        x = getLBYL();
        x = getEAFP();
        System.out.println("x value is "+x);

    }

    private static void removeList(List<String> listA) {
      listA.remove("A");
    }

    private static int getEAFP() {
        try {
            Scanner s = new Scanner(System.in);
            return s.nextInt();
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    private static int getLBYL() {
        Scanner s = new Scanner(System.in);
        String value = s.next();
        boolean isInt = true;
        for(int i=0;i<value.length();i++){
            if(!Character.isDigit(value.charAt(i))){
                isInt = false;
            }
        }
        if(!isInt){
            return 0;
        }
        return Integer.parseInt(value);
    }

    private static int getInt() {
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }

    public static int devideLBYL(int x, int y){
        if(y!=0){
            return x/y;
        }
        return 0;
    }

    public static int devideEAFP(int x, int y) {
        try {
            return x / y;
        } catch (Exception e) {
            return 0;
        }
    }
}
