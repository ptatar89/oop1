package company.settlement;

import company.client.ClientType;

import static company.client.ClientType.BUSINESS;

public class SettlementMapper {

    static Settlement mapByClientType(ClientType clientType) {
        if (clientType.equals(BUSINESS)) {
            return new Monthly();
        }

        return new AfterRide();
    }
}
