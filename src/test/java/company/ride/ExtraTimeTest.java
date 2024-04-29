package company.ride;

import company.maintanace.Position;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static company.ride.ExtraTime.EXTRA_TIME;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ExtraTimeTest {

    static Position TEST_START_POSITION = Position.from(50.071184F,19.939664F);
    static Position TEST_END_POSITION = Position.from(50.063928F, 19.960947F);

    @Test
    void shouldCalculateDuration() {
        //given
        LocalDateTime startTime = LocalDateTime.parse("2024-02-10T10:00:00");
        LocalDateTime endTime = LocalDateTime.parse("2024-02-10T10:30:00");

        Ride ride = new ExtraTime(EXTRA_TIME);
        ride.start(TEST_START_POSITION, startTime);
        ride.end(TEST_END_POSITION, endTime);

        //expected
        assertEquals(30L, ride.duration());
        assertEquals(15L, ride.durationToBeSettled());
    }

}