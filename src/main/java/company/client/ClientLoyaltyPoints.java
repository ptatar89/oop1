package company.client;

public record ClientLoyaltyPoints(long points) {

    public ClientLoyaltyPoints {
        if (points < 0L) {
            throw new IllegalArgumentException("Loyalty Points can not be lower then 0");
        }
    }

}
