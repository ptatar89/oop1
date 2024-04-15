package main.java.company.client;

import main.java.company.loyality.TransactionCounter;
import main.java.company.repository.TestDB;

import static main.java.company.client.ClientType.ClientTypeMapper.map;

public class ClientProvider {
    private final TestDB testDB = new TestDB();

    public Client getClientById(ClientId clientId) {
        return clientFactory(ClientDTO.rawDataToObject(testDB.getClientData(clientId.id())));
    }

    private Client clientFactory(ClientDTO clientData) {
        switch (clientData.clientType) {
            case BUSINESS -> {
                return new Business(
                        new ClientId(clientData.clientId),
                        clientData.clientCredit,
                        clientData.clientWithImmediatePayment,
                        clientData.immediateTransactionsCounter
                );
            }
            case INDIVIDUAL -> {
                return new Individual(
                        new ClientId(clientData.clientId),
                        clientData.clientCredit,
                        clientData.clientWithImmediatePayment,
                        clientData.immediateTransactionsCounter
                );
            }
            default -> throw new RuntimeException("not supported client type");
        }
    }

}
