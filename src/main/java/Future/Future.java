package Future;

import General.Location;
import General.Forecast;

public class Future {
    Location location;
    Forecast forecast;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    @Override
    public String toString() {
        return "Future{" +
                "location=" + location +
                ", forecast=" + forecast +
                '}';
    }
}
