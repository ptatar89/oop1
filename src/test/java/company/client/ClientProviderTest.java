package company.client;

import company.repository.TestDB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static company.repository.TestDB.CLIENT_CREDIT;
import static company.repository.TestDB.CLIENT_ID;
import static company.repository.TestDB.CLIENT_TYPE;
import static company.repository.TestDB.IMMEDIATE_TRANSACTIONS_COUNTER;

class ClientProviderTest {

    TestDB testDB = new TestDB();

    Long testClientId = 1L;


    @Test
    void shouldReturnClientById() {
        //given
        ClientId clientId = new ClientId(testClientId);

        ClientProvider clientProvider = new ClientProvider(testDB.getClientData(clientId.id()));

        //when
        Client client = clientProvider.getClientById(clientId);

        //expected
        HashMap<String, Object> clientTestData = testDB.getClientData(testClientId);
        Assertions.assertEquals(clientTestData.get(CLIENT_ID), client.getClientId().id());
        Assertions.assertEquals(clientTestData.get(CLIENT_CREDIT), client.getClientCredit().clientCredit());
        Assertions.assertEquals(clientTestData.get(IMMEDIATE_TRANSACTIONS_COUNTER), client.getImmediateTransactionsCounter());
    }

    @Test
    void shouldThrowExceptionOnWrongClientType() {
        //setup
        HashMap<String, Object> clientData = testDB.getClientData(testClientId);
        clientData.put(CLIENT_TYPE, "wrong");
        testDB.storeClientData(testClientId, clientData);

        //given
        ClientId clientId = new ClientId(testClientId);
        ClientProvider clientProvider = new ClientProvider(testDB.getClientData(clientId.id()));

        //when
        Assertions.assertThrows(IllegalArgumentException.class, () -> clientProvider.getClientById(clientId));
    }

}
