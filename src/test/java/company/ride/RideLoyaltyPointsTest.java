package company.ride;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RideLoyaltyPointsTest {
    @Test
    void shouldReturnLoyaltyPoints() {
        //given
        long points = 10L;
        //when
        RideLoyaltyPoints loyaltyPoints = new RideLoyaltyPoints(points);
        //expected
        assertEquals(points, loyaltyPoints.points());
    }

    @Test
    void shouldThrowExceptionOnMinusLoyaltyPoints() {
        //given
        long points = -10L;
        //expected
        assertThrows(IllegalArgumentException.class, () -> new RideLoyaltyPoints(points));
    }
}