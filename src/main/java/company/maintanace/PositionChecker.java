package company.maintanace;

public class PositionChecker {

    public static boolean isWithinRadius(Position position, Position referencePosition, double radius) {
        double distance = calculateDistance(position, referencePosition);
        return distance <= radius;
    }

    private static double calculateDistance(Position position, Position referencePosition) {
        final int R = 6371;

        double latDistance = Math.toRadians(referencePosition.latitude().latitude() - position.latitude().latitude());
        double lonDistance = Math.toRadians(referencePosition.longitude().longitude() - position.longitude().longitude());
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(position.longitude().longitude())) * Math.cos(Math.toRadians(referencePosition.latitude().latitude()))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c * 1000;
    }


}
