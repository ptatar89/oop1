package company.settlement;

import company.client.Client;
import company.client.ClientId;
import company.client.ClientProvider;
import company.repository.TestDB;
import company.ride.RideProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.YearMonth;

import static test.java.company.BaseTest.CLIENT_ID;
import static test.java.company.BaseTest.getListOfRidesForTest;

class SettlementServiceITTest {

    @Test
    void shouldReturnPriceToPay() {
        //given
        TestDB testDB = new TestDB();
        var clientData = testDB.getClientData(CLIENT_ID);
        ClientProvider clientProvider = new ClientProvider(clientData);
        Client client = clientProvider.getClientById(new ClientId(CLIENT_ID));

        var allRides = getListOfRidesForTest();
        RideProvider rideProvider = new RideProvider();

        YearMonth yearMonthToSettle = YearMonth.parse("2024-04");

        //when
        SettlementService settlementService = new SettlementService(client);
        var settleValue = settlementService.settle(rideProvider.getRideByMonth(yearMonthToSettle, allRides));

        //expected
        Assertions.assertEquals(5L, settleValue);
    }

}