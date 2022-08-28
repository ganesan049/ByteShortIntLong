package composition;

public class Bedroom {
    private final Wall wall1;
    private final Wall wall2;
    private final Wall wall3;
    private final Wall wall4;
    private final String name;
    private final Ceiling ceiling;
    private final Bed bed;
    private final Lamp lamp;

    public Lamp getLamp() {
        return lamp;
    }

    public void makeBed(){
        System.out.println("Bedroom -> Making bed | ");
        bed.make();
    }

    public Bedroom(String name,Wall wall1, Wall wall2, Wall wall3, Wall wall4,  Ceiling ceiling, Bed bed, Lamp lamp) {
        this.wall1 = wall1;
        this.wall2 = wall2;
        this.wall3 = wall3;
        this.wall4 = wall4;
        this.name = name;
        this.ceiling = ceiling;
        this.bed = bed;
        this.lamp = lamp;
    }
}
