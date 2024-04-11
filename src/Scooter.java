public class Scooter {

    private Long scooterId;
    private Object[] scooterData;
    private float batteryLevel;
    private boolean scheduleForMaintenance;

    Scooter(Long scooterId, Object[] scooterData, float batteryLevel) {
        this.scooterId = scooterId;
        this.scooterData = scooterData;
        this.batteryLevel = batteryLevel;
    }

    float price(int minutes, Client client) {
        float price;
        float unlocking;
        float pricePerMinute;
        if (scooterData[0].equals("not_fast")) {
            unlocking = (float) scooterData[1];
            pricePerMinute = (float) scooterData[2];
        } else {
            unlocking = (float) scooterData[3];
            pricePerMinute = (float) scooterData[4];
        }
        price = minutes * pricePerMinute + unlocking;
        if (client.isImmediate()) {
            price = price * 0.9f;
        }
        return price;
    }

    boolean scheduleForMaintenance(company.maintanace.Position where) {
        if (batteryLevel < 0.07) {
            scheduleForMaintenance = true;
        }
        return scheduleForMaintenance;
    }

    String description() {
        return scooterId + " " + (String) scooterData[0];
    }
}
