package company.ride;

import company.maintanace.Position;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static company.ride.ExtraTime.EXTRA_TIME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static test.java.company.BaseTest.TEST_END_POSITION;
import static test.java.company.BaseTest.TEST_START_POSITION;

class ExtraTimeTest {

    @Test
    void shouldCalculateDuration() {
        //given
        LocalDateTime startTime = LocalDateTime.parse("2024-02-10T10:00:00");
        LocalDateTime endTime = LocalDateTime.parse("2024-02-10T10:30:00");

        Ride ride = new ExtraTime(EXTRA_TIME);
        ride.start(new RideId(1L), TEST_START_POSITION, startTime);
        ride.end(TEST_END_POSITION, endTime);

        //expected
        assertEquals(30L, ride.duration());
        assertEquals(15L, ride.durationToBeSettled());
    }

}