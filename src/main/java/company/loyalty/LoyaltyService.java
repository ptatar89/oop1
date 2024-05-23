package company.loyalty;

import company.client.ClientType;
import company.ride.Ride;

import static company.ride.RideLoyaltyPoints.empty;

public class LoyaltyService {

    public LoyaltyPoints calculateLoyaltyPointsForRide(Ride ride, ClientType clientType) {
        return LoyaltyProvider.byClientType(clientType, empty()).getLoyaltyPointsByRide(ride.duration());
    }

}
