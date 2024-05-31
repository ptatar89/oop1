package company.settlement;

import company.client.Client;
import company.client.ClientLoyaltyPoints;
import company.discount.DiscountDecorator;
import company.price.PriceFactor;
import company.ride.Ride;

import java.util.List;

import static company.settlement.SettlementMapper.mapByClientType;

public class SettlementService {

    Settlement settlement;

    ClientLoyaltyPoints clientLoyaltyPoints;

    public SettlementService(Client client) {
        settlement = mapByClientType(client.type());
        clientLoyaltyPoints = client.getClientLoyaltyPoints();
    }

    public float settle(List<Ride> rides) {
        var duration = settlement.settle(rides);

        // base price
        var price = PriceFactor.calculatePriceByDuration(duration);

        return new DiscountDecorator(price, rides.size(), clientLoyaltyPoints).decorate();
    }
}
