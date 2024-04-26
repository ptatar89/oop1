package company.client;

import company.loyality.TransactionCounter;

import java.util.Map;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static company.repository.TestDB.CLIENT_CREDIT;
import static company.repository.TestDB.CLIENT_ID;
import static company.repository.TestDB.CLIENT_TYPE;
import static company.repository.TestDB.CLIENT_WITH_IMMEDIATE_PAYMENT;
import static company.repository.TestDB.IMMEDIATE_TRANSACTIONS_COUNTER;

public class ClientDTO {

    Long clientId;
    ClientCredit clientCredit;
    boolean clientWithImmediatePayment;
    TransactionCounter immediateTransactionsCounter;
    ClientType clientType;

    public static ClientDTO rawDataToObject(Map<String, Object> clientData) {
        ClientDTO dto = new ClientDTO();
        dto.clientId = (Long) clientData.get(CLIENT_ID);
        dto.clientCredit = new ClientCredit(parseFloat(clientData.get(CLIENT_CREDIT).toString()));
        dto.clientWithImmediatePayment = (boolean) clientData.get(CLIENT_WITH_IMMEDIATE_PAYMENT);
        dto.immediateTransactionsCounter = new TransactionCounter(parseInt(clientData.get(IMMEDIATE_TRANSACTIONS_COUNTER).toString()));
        dto.clientType = ClientType.fromName(clientData.get(CLIENT_TYPE).toString());

        return dto;
    }
}
