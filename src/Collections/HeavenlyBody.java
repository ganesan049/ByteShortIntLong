package Collections;

import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody {
    private final BodyTypes bodyType;
    public enum BodyTypes {
        STAR,PLANET,DWARF_PLANET,MOON,COMET,ASTEROID
    }
    private final String name;
    private final Set<HeavenlyBody> satellites;
    private final double orbitalPeriod;

    public HeavenlyBody(String name, double orbitalPeriod,BodyTypes bodyType) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.bodyType = bodyType;
    }

    public BodyTypes getBodyType() {
        return bodyType;
    }

    public boolean addSatellite(HeavenlyBody moon){
            return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(satellites);
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    @Override
    public final boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj instanceof HeavenlyBody){
            HeavenlyBody theObj = ((HeavenlyBody) obj);
            if(name.equals(theObj.getName())){
                return bodyType.equals(theObj.getBodyType());
            }
        }
        return false;
    }

    @Override
    public final int hashCode(){
        return this.name.hashCode() + this.bodyType.hashCode() + 57;
    }

    @Override
    public String toString() {
        return "HeavenlyBody{" +
                "bodyType=" + bodyType +
                ", name='" + name + '\'' +
                ", satellites=" + satellites +
                ", orbitalPeriod=" + orbitalPeriod +
                '}';
    }
}
