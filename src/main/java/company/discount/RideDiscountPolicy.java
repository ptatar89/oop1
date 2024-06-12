package company.discount;

import static company.discount.DiscountLevel.*;

public class RideDiscountPolicy implements Discount{

    int rideCount;

    RideDiscountPolicy(int rideCount) {
        this.rideCount = rideCount;
    }

    @Override
    public double discount() {
        if (rideCount > LEVEL_4.level) {
            return LEVEL_4.discount;
        }

        if (rideCount > LEVEL_3.level) {
            return LEVEL_3.discount;
        }

        if (rideCount > LEVEL_2.level) {
            return LEVEL_2.discount;
        }

        if (rideCount > LEVEL_1.level) {
            return LEVEL_1.discount;
        }

        return LEVEL_0.discount;
    }
}
