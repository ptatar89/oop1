package company.loyalty;

public class Business implements Loyalty{

    private static final double POINTS_MULTIPLIER = 0.20;

    LoyaltyPoints loyaltyPoints;

    Business(LoyaltyPoints loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    @Override
    public LoyaltyPoints getLoyaltyPointsByRide(long minutes) {
        double pointsToAdd = minutes + (minutes * POINTS_MULTIPLIER);

        return new LoyaltyPoints((long) (loyaltyPoints.points() + pointsToAdd));
    }
}
