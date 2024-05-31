package company.discount;

import company.client.ClientLoyaltyPoints;

public class DiscountDecorator {

    private float price;
    private final RideDiscountPolicy rideDiscountPolicy;
    private final LoyaltyDiscountPolicy loyaltyDiscountPolicy;

    public DiscountDecorator(float price, int rideCount, ClientLoyaltyPoints clientLoyaltyPoints) {
        this.price = price;

        this.rideDiscountPolicy = new RideDiscountPolicy(rideCount);
        this.loyaltyDiscountPolicy = new LoyaltyDiscountPolicy(clientLoyaltyPoints);
    }

    public float decorate() {
        applyRideDiscountPolicy();
        applyLoyaltyDiscountPolicy();

        return price;
    }

    private void applyRideDiscountPolicy() {
        price = price * (float) (1 - rideDiscountPolicy.discount());
    }

    private void applyLoyaltyDiscountPolicy() {
        price = price * (float) (1 - loyaltyDiscountPolicy.discount());
    }

}
