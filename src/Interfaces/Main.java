package Interfaces;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player tim = new Player("Tim",10,15);
//        String value = "10";
//        System.out.println(Integer.valueOf(value));
        System.out.println(tim.toString());
        saveObject(tim);
        tim.setHitPoints(8);
        System.out.println(tim);
        tim.setWeapon("Stormbridger");
        saveObject(tim);
        loadObject(tim);
        System.out.println(tim);
    }
    public static void saveObject(ISaveable object){
        for (int i=0;i<object.write().size();i++){
            System.out.println("Saving "+object.write().get(i)+" to device");
        }
    }
    public static void loadObject(ISaveable object){
        ArrayList<String> values = readValues();
        object.read(values);
    }
    public static ArrayList<String> readValues(){
        ArrayList<String> values = new ArrayList<>();
        boolean quit = false;
        int index = 0;
        System.out.println("1 - add\n"+"0 - quit");
        while (!quit){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter choice ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter String ");
                    String input = scanner.nextLine();
                    values.add(index,input);
                    index++;
                    break;
            }
        }
        return values;
    }

}
