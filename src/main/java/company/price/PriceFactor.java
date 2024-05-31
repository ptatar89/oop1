package company.price;

public class PriceFactor {

    private static final float PRICE_BY_TIME_UNIT = 1f;

    public static float calculatePriceByDuration(Long duration) {
        return duration * PRICE_BY_TIME_UNIT;
    }

}
