package company.settlement;

import company.client.Client;
import company.rental.Ride;

import java.util.List;

public class SettlementService {
    Settlement settlement;
    public SettlementService(Client client) {
        settlement = SettlementMapper.mapByClientType(client.type());
    }

    public void settle(List<Ride> rides) {
        settlement.settle(rides);
    }
}
