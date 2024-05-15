package company.maintanace;

import company.repository.TestDB;

import static company.repository.TestDB.OFFICE_POSITION;

public class StandardMaintenance implements Maintenance {
    private static final Integer MINIMUM_BATTERY_LEVEL = 15;

    public boolean shouldBeMaintenance(Battery battery) {
        return battery.level <= MINIMUM_BATTERY_LEVEL;
    }

}
