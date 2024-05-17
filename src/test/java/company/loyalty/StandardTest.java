package company.loyalty;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StandardTest {

    @Test
    void shouldReturnCorrectCountOfPoints() {
        //given
        LoyaltyPoints loyaltyPoints = new LoyaltyPoints(10L);
        //when
        long minutesRide = 15L;
        Loyalty loyalty = new Standard(loyaltyPoints);
        //expected

        assertEquals(25L, loyalty.getLoyaltyPointsByRide(minutesRide).points());
    }

}