package company.loyalty;

import company.client.ClientLoyaltyPoints;
import company.client.ClientType;
import company.ride.RideLoyaltyPoints;

import static company.client.ClientType.BUSINESS;
import static company.loyalty.LoyaltyPoints.fromClientLoyaltyPoints;
import static company.loyalty.LoyaltyPoints.fromRideLoyaltyPoints;

public class LoyaltyProvider {

    public static Loyalty byClientType(ClientType clientType, ClientLoyaltyPoints clientLoyaltyPoints) {
        if (clientType.equals(BUSINESS)) {
            return new Business(fromClientLoyaltyPoints(clientLoyaltyPoints));
        }

        return new Standard(fromClientLoyaltyPoints(clientLoyaltyPoints));
    }

    public static Loyalty byClientType(ClientType clientType, RideLoyaltyPoints rideLoyaltyPoints) {
        if (clientType.equals(BUSINESS)) {
            return new Business(fromRideLoyaltyPoints(rideLoyaltyPoints));
        }

        return new Standard(fromRideLoyaltyPoints(rideLoyaltyPoints));
    }

}
