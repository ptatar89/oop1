package company.loyalty;

public class Standard implements Loyalty{

    LoyaltyPoints loyaltyPoints;

    Standard(LoyaltyPoints loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    @Override
    public LoyaltyPoints getLoyaltyPointsByRide(long minutes) {
        return new LoyaltyPoints(loyaltyPoints.points() + minutes);
    }
}
