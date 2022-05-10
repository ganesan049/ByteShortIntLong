package Collections;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String,Integer> exit;

    public Location(int locationID, String description) {
        this.locationID = locationID;
        this.description = description;
        this.exit = new HashMap<>();
        this.exit.put("Q",0);
    }

    public void addExit(String direction, int location){
        exit.put(direction,location);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExit() {
        return new HashMap<String ,Integer>(exit);
    }
}
