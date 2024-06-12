package company.client;

import company.repository.TestDB;

import java.util.HashMap;


public class ClientProvider {
    private final HashMap<String, Object> clientData;

    public ClientProvider(HashMap<String, Object> clientData) {
        this.clientData = clientData;
    }

    public Client getClientById(ClientId clientId) {
        return clientFactory(ClientDTO.rawDataToObject(clientData));
    }

    private Client clientFactory(ClientDTO clientData) {
        switch (clientData.clientType) {
            case BUSINESS -> {
                return new Business(
                        new ClientId(clientData.clientId),
                        clientData.clientCredit,
                        clientData.clientWithImmediatePayment,
                        clientData.immediateTransactionsCounter,
                        clientData.clientLoyaltyPoints
                );
            }
            case INDIVIDUAL -> {
                return new Individual(
                        new ClientId(clientData.clientId),
                        clientData.clientCredit,
                        clientData.clientWithImmediatePayment,
                        clientData.immediateTransactionsCounter,
                        clientData.clientLoyaltyPoints
                );
            }
            default -> throw new RuntimeException("not supported client type");
        }
    }

}
