package Collections;

import java.util.*;

public class Main {
    private static final Map<Integer,Location> locations = new HashMap<Integer, Location>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        locations.put(0,new Location(0,"Start"));
        locations.put(1,new Location(1,"Road"));
        locations.put(2,new Location(2,"Hill"));
        locations.put(3,new Location(3,"Building"));
        locations.put(4,new Location(4,"Valley"));
        locations.put(5,new Location(5,"Forest"));

        locations.get(1).addExit("W",2);
        locations.get(1).addExit("E",3);
        locations.get(1).addExit("S",4);
        locations.get(1).addExit("N",5);

        locations.get(2).addExit("N",5);

        locations.get(3).addExit("W",1);

        locations.get(4).addExit("W",2);
        locations.get(4).addExit("N",1);

        locations.get(5).addExit("W",2);
        locations.get(5).addExit("S",1);

        int loc = 1;
//            System.out.println("Either String 1 or Char 2");
//            int choice = scanner.nextInt();
//            String choiceString;
//            List<String> choiceList = new ArrayList<>();
//            if(choice == 1){
//                choiceString = scanner.next();
//                choiceString.split(",")
//            }

        while (true){

            System.out.println(locations.get(loc).getDescription());
            if(loc == 0){
                break;
            }
            Map<String,Integer> exits = locations.get(loc).getExit();
            System.out.println("Available exits are :");
            for(String exit: exits.keySet()){
                System.out.print(exit+", ");
            }
            System.out.println();
            String direction = scanner.nextLine().toUpperCase(Locale.ROOT);
            System.out.println(direction);
            if(direction.length() > 1){
                if(direction.split(" ").length > 1){
                    direction = direction.split(" ")[1].split("")[0].toUpperCase();
                }
                direction = direction.split("")[0].toUpperCase();
            }
            if(exits.containsKey(direction)){
                loc = exits.get(direction);
            }else {
                System.out.println("You can't go there");
            }
        }
    }
}
