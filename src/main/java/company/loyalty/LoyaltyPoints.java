package company.loyalty;

import company.client.ClientLoyaltyPoints;
import company.ride.RideLoyaltyPoints;

public record LoyaltyPoints(long points) {

    public LoyaltyPoints {
        if (points < 0L) {
            throw new IllegalArgumentException("Loyalty Points can not be lower then 0");
        }
    }

    public static LoyaltyPoints fromClientLoyaltyPoints(ClientLoyaltyPoints loyaltyPoints) {
        return new LoyaltyPoints(loyaltyPoints.points());
    }

    public static LoyaltyPoints fromRideLoyaltyPoints(RideLoyaltyPoints loyaltyPoints) {
        return new LoyaltyPoints(loyaltyPoints.points());
    }

}
