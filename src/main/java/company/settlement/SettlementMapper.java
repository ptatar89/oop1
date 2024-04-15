package main.java.company.settlement;

import main.java.company.client.ClientType;

import static main.java.company.client.ClientType.BUSINESS;

public class SettlementMapper {

    static Settlement mapByClientType(ClientType clientType) {
        if (clientType.equals(BUSINESS)) {
            return new Monthly();
        }

        return new AfterRide();
    }
}
