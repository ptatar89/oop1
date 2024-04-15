package main.java.company.settlement;

import main.java.company.client.Client;
import main.java.company.rental.Ride;

import java.util.List;

public class SettlementService {
    Settlement settlement;
    public SettlementService(Client client) {
        settlement = SettlementMapper.mapByClientType(client.type());
    }

    public void settle() {
        settlement.settle(List.of(new Ride()));
    }
}
