package TimeZone;

import General.Location;

public class TimeZone {
    Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "TimeZone{" +
                "location=" + location +
                '}';
    }
}
