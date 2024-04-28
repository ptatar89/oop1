package company.ride;

import company.client.ClientType;

import static company.ride.ExtraTime.EXTRA_TIME;

public class RideStrategy {

    public Ride getRideByClientType(ClientType clientType) {
        switch (clientType) {
            case BUSINESS:
                return new ExtraTime(EXTRA_TIME);
            case INDIVIDUAL:
                return new Normal();
            default:
                throw new RuntimeException("not supported");
        }
    }


}
