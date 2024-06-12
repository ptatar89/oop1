package company.ride;

import org.junit.jupiter.api.Test;

import static company.client.ClientType.BUSINESS;
import static company.client.ClientType.INDIVIDUAL;
import static company.ride.RideStrategy.getRideByClientType;
import static org.junit.jupiter.api.Assertions.*;

class RideStrategyTest {

    @Test
    void shouldReturnExtraRideStrategy() {
        //expected
        assertInstanceOf(ExtraTime.class, getRideByClientType(BUSINESS));
    }

    @Test
    void shouldReturnNormalRideStrategyByDefault() {
        //expected
        assertInstanceOf(Normal.class, getRideByClientType(INDIVIDUAL));
    }
}