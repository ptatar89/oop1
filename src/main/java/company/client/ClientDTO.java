package main.java.company.client;

import java.util.Map;

import static main.java.company.repository.TestDB.CLIENT_CREDIT;
import static main.java.company.repository.TestDB.CLIENT_ID;
import static main.java.company.repository.TestDB.CLIENT_TYPE;
import static main.java.company.repository.TestDB.CLIENT_WITH_IMMEDIATE_PAYMENT;
import static main.java.company.repository.TestDB.IMMEDIATE_TRANSACTIONS_COUNTER;

public class ClientDTO {

    Long clientId;
    float clientCredit;
    boolean clientWithImmediatePayment;
    int immediateTransactionsCounter;
    String clientType;

    public static ClientDTO rawDataToObject(Map<String, Object> clientData) {
        ClientDTO dto = new ClientDTO();
        dto.clientId = (Long) clientData.get(CLIENT_ID);
        dto.clientCredit = (float) clientData.get(CLIENT_CREDIT);
        dto.clientWithImmediatePayment = (boolean) clientData.get(CLIENT_WITH_IMMEDIATE_PAYMENT);
        dto.immediateTransactionsCounter = (int) clientData.get(IMMEDIATE_TRANSACTIONS_COUNTER);
        dto.clientType = clientData.get(CLIENT_TYPE).toString();

        return dto;
    }
}
