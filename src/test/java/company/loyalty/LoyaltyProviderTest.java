package company.loyalty;

import company.client.ClientLoyaltyPoints;
import org.junit.jupiter.api.Test;

import static company.client.ClientType.BUSINESS;
import static company.client.ClientType.INDIVIDUAL;
import static org.junit.jupiter.api.Assertions.*;

class LoyaltyProviderTest {

    @Test
    void shouldProvideBusinessLoyalty() {
        //expected
        assertInstanceOf(Business.class, LoyaltyProvider.byClientType(BUSINESS, new ClientLoyaltyPoints(0L)));
    }

    @Test
    void shouldProvideStandardLoyalty() {
        //expected
        assertInstanceOf(Standard.class, LoyaltyProvider.byClientType(INDIVIDUAL, new ClientLoyaltyPoints(0L)));
    }

}