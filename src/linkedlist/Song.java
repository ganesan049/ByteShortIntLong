package linkedlist;

public class Song {
    private final String title;
    private final double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public double getDuration() {
        return duration;
    }

    @Override
    public String toString(){
        return title+" "+duration;
    }
}
