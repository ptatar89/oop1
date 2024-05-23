package company.loyalty;

import company.maintanace.Position;
import company.ride.RideId;
import company.ride.RideStrategy;
import org.junit.jupiter.api.Test;

import static company.client.ClientType.BUSINESS;
import static java.time.LocalDateTime.now;
import static org.junit.jupiter.api.Assertions.*;

class LoyaltyServiceITTest {

    LoyaltyService loyaltyService = new LoyaltyService();

    @Test
    void shouldCalculateCorrectCountOfLoyaltyPoints() {
        //given
        var clientType = BUSINESS;
        var ride = RideStrategy.getRideByClientType(clientType);
        var startTime = now();
        ride.start(RideId.create(), Position.from(50.071184F,19.939664F), startTime);

        //when
        ride.end(Position.from(50.064192F,19.960776F), startTime.plusMinutes(10L));
        var points = loyaltyService.calculateLoyaltyPointsForRide(ride, clientType);

        //expected
        assertEquals(12L, points.points());
    }

}