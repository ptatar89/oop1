package company.discount;

import company.client.ClientLoyaltyPoints;

public class LoyaltyDiscountPolicy implements Discount {

    private static final int LOYALTY_POINTS_LEVEL = 500;
    static final double LOYALTY_DISCOUNT = 0.5;
    static final double LOYALTY_NO_DISCOUNT = 0;

    ClientLoyaltyPoints loyaltyPoints;

    LoyaltyDiscountPolicy(ClientLoyaltyPoints clientLoyaltyPoints) {
        loyaltyPoints = clientLoyaltyPoints;
    }

    @Override
    public double discount() {
        if (loyaltyPoints.points() > LOYALTY_POINTS_LEVEL) {
            return LOYALTY_DISCOUNT;
        }

        return LOYALTY_NO_DISCOUNT;
    }
}
