package company.loyalty;

import company.client.ClientLoyaltyPoints;
import company.client.ClientType;

import static company.client.ClientType.BUSINESS;
import static company.loyalty.LoyaltyPoints.fromClientLoyaltyPoints;

public class LoyaltyProvider {

    public static Loyalty byClientType(ClientType clientType, ClientLoyaltyPoints clientLoyaltyPoints) {
        if (clientType.equals(BUSINESS)) {
            return new Business(fromClientLoyaltyPoints(clientLoyaltyPoints));
        }

        return new Standard(fromClientLoyaltyPoints(clientLoyaltyPoints));
    }

}
