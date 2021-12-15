package linkedlist;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
//        linkedList();
        Album album = new Album("Stormbringer","Deep purple");
        album.addSong("Stormbringer",4.6);
        album.addSong("Holy man",5.6);
        albums.add(album);
        album = new Album("Rock","Ac/Dc");
        album.addSong("Lets go",4.6);
        album.addSong("COD",5.6);
        album.addSong("Breaking the rules",5.32);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlaylist("Holy man",playList);
        albums.get(0).addToPlaylist(1,playList);
//        albums.get(0).addToPlaylist(3,playList);

        playList(playList);
    }

    private static void playList(LinkedList<Song> playList) {
        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0){
            System.out.println("No songs in playlist");
        }else {
            System.out.println("Now playing "+listIterator.next().toString());
//            System.out.println("Now playing "+listIterator.next().toString());
        }
    }

    private static void linkedList() {
        LinkedList<String> placesToVisit = new LinkedList<>();
        placesToVisit.add("Chennai");
        placesToVisit.add("Banglore");
        placesToVisit.add("Humpi");
        placesToVisit.add("Goa");
        placesToVisit.add("Jaipur");

        printList(placesToVisit);
        placesToVisit.add(1,"Tirupati");
        printList(placesToVisit);
        placesToVisit.remove(5);
        printList(placesToVisit);
        boolean result = insertPlace(placesToVisit,"Chenz");
        if (result){

            printList(placesToVisit);
        }
    }

    private static boolean insertPlace(LinkedList<String> placesToVisit, String place) {
        ListIterator<String> listIterator = placesToVisit.listIterator();
        while (listIterator.hasNext()){
            String data = listIterator.next();
            int result = data.toLowerCase(Locale.ROOT).compareTo(place.toLowerCase(Locale.ROOT));
            System.out.println(result+" "+data);
            if (result == 0) {
                System.out.println("Already available");
                return false;
            }else if(result > 0){
                listIterator.previous();
                listIterator.add(place);
                return true;
            }
        }
        listIterator.add(place);
        return true;
    }

    private static void printList(LinkedList<String> placesToVisit) {
        Iterator<String> iterator = placesToVisit.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(" ");
    }
}
