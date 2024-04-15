package main.java.company.rental;

import main.java.company.maintanace.Battery;
import main.java.company.repository.Database;

import java.util.HashMap;

public class Scooter {

    ScooterId scooterId;

    Object[] scooterData;

    float batteryLevel;

    public Scooter(ScooterId scooterId) {
        HashMap<String, Object> database = new Database().getData();

        this.scooterId = scooterId;
        this.scooterData = (Object[]) database.get("scooterData");
        this.batteryLevel = (float) database.get("batteryLevel");
    }

    public boolean needsToChargeBattery() {
        return new Battery(batteryLevel).isNeedsToChargeBattery();
    }

    public ScooterId getScooterId() {
        return scooterId;
    }

    public Object[] getScooterData() {
        return scooterData;
    }

    public float getBatteryLevel() {
        return batteryLevel;
    }
}
