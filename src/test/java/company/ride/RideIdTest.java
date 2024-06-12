package company.ride;

import company.client.ClientId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RideIdTest {

    @Test
    void shouldCreateRideId() {
        //given
        Long id = 123L;

        //when
        RideId rideId = new RideId(id);

        //expected
        Assertions.assertEquals(rideId.id(), id);
    }

    @Test
    void shouldThrowExceptionOnWrongRideId() {
        //expected
        Assertions.assertThrows(RuntimeException.class, () -> new RideId(null));
    }
}
