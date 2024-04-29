package company.settlement;

import company.client.Client;
import company.ride.Ride;

import java.util.List;

import static company.settlement.SettlementMapper.mapByClientType;

public class SettlementService {

    Settlement settlement;

    public SettlementService(Client client) {
        settlement = mapByClientType(client.type());
    }

    public Long settle(List<Ride> rides) {
        return settlement.settle(rides);
    }
}
