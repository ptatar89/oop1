package company.loyalty;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BusinessTest {

    @Test
    void shouldReturnCorrectCountOfPoints() {
        //given
        LoyaltyPoints loyaltyPoints = new LoyaltyPoints(10L);
        //when
        long minutesRide = 10L;
        Loyalty loyalty = new Business(loyaltyPoints);
        //expected

        assertEquals(22L, loyalty.getLoyaltyPointsByRide(minutesRide).points());
    }

}