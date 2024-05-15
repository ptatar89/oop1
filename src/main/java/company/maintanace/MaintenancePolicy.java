package company.maintanace;

import company.repository.TestDB;

import static company.maintanace.PositionChecker.isWithinRadius;
import static company.repository.TestDB.OFFICE_POSITION;

public class MaintenancePolicy {

    private static final double RADIUS = 1000;

    public static boolean shouldBeMaintenance(Position position, Battery battery) {
        if(isCloseToTheOffices(position)) {
            return new PremiumMaintenance().shouldBeMaintenance(battery);
        }

        return new StandardMaintenance().shouldBeMaintenance(battery);
    }

    private static boolean isCloseToTheOffices(Position position) {
        TestDB testDB = new TestDB();

        Position officePosition = (Position) testDB.getOfficeData(1000L).get(OFFICE_POSITION);
        Position secondOfficePosition = (Position) testDB.getOfficeData(1100L).get(OFFICE_POSITION);

        if (isWithinRadius(officePosition, position, RADIUS)) {
            return true;
        }

        return isWithinRadius(secondOfficePosition, position, RADIUS);
    }

}
