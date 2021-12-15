package linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private ArrayList<Song> songs;
    private String name;
    private String artist;

    public Album(String name, String artist) {
        this.songs = new ArrayList<Song>();
        this.name = name;
        this.artist = artist;
    }

    public boolean addSong(String title, double duration){
        if(findSong(title) == null){
            this.songs.add(new Song(title,duration));
        }
        return false;
    }

    private Song findSong(String title){
        for(Song checkedSong : songs){
            if(checkedSong.getTitle().equals(title)){
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playList){
        int index = trackNumber - 1;
        if((index >= 0) && (index <= this.songs.size())){
            playList.add(this.songs.get(index));
            return true;
        }
        System.out.println("The album doesn't have "+trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playList){
        Song checkedSong = findSong(title);
        if(checkedSong != null){
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The album doesn't have "+title);
        return false;
    }
}
