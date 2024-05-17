package company.loyalty;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoyaltyPointsTest {

    @Test
    void shouldReturnLoyaltyPoints() {
        //given
        long points = 10L;
        //when
        LoyaltyPoints loyaltyPoints = new LoyaltyPoints(points);
        //expected
        assertEquals(points, loyaltyPoints.points());
    }

    @Test
    void shouldThrowExceptionOnMinusLoyaltyPoints() {
        //given
        long points = -10L;
        //expected
        assertThrows(IllegalArgumentException.class, () -> new LoyaltyPoints(points));
    }
}