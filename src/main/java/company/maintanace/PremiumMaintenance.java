package company.maintanace;

import company.repository.TestDB;

import static company.repository.TestDB.OFFICE_POSITION;

public class PremiumMaintenance {

    private static double RADIUS = 1000;
    private static Integer MINIMUM_BATTERY_LEVEL = 40;

    public static boolean shouldBeMaintenance(Position position, Battery battery) {
        TestDB testDB = new TestDB();

        Position officePosition = (Position) testDB.getOfficeData(1000L).get(OFFICE_POSITION);
        Position secondOfficePosition = (Position) testDB.getOfficeData(1100L).get(OFFICE_POSITION);

        if(PositionChecker.isWithinRadius(officePosition, position, RADIUS) && battery.level <= MINIMUM_BATTERY_LEVEL) {
            return true;
        }

        return PositionChecker.isWithinRadius(secondOfficePosition, position, RADIUS) && battery.level <= MINIMUM_BATTERY_LEVEL;
    }

}
