package company.maintanace;

public class PremiumMaintenance implements Maintenance {
    private static final Integer MINIMUM_BATTERY_LEVEL = 40;

    public boolean shouldBeMaintenance(Battery battery) {
        return battery.level <= MINIMUM_BATTERY_LEVEL;
    }

}
