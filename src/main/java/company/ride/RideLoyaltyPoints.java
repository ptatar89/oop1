package company.ride;

public record RideLoyaltyPoints(long points) {

    public RideLoyaltyPoints {
        if (points < 0L) {
            throw new IllegalArgumentException("Ride Loyalty Points can not be lower then 0");
        }
    }

    public static RideLoyaltyPoints empty() {
        return  new RideLoyaltyPoints(0L);
    }

}
