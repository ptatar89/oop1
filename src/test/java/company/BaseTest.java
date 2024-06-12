package test.java.company;

import company.maintanace.Position;
import company.ride.ExtraTime;
import company.ride.Ride;
import company.repository.TestDB;
import company.ride.RideId;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import static company.ride.ExtraTime.EXTRA_TIME;

public abstract class BaseTest {

    protected TestDB testDB;

    public final static Position TEST_START_POSITION = Position.from(50.071184F,19.939664F);
    public final static Position TEST_END_POSITION = Position.from(50.063928F, 19.960947F);

    public final static Long CLIENT_ID = 1L;

    @BeforeEach
    public void setUp() {
        testDB = new TestDB();
    }

    public static List<Ride> getListOfRidesForTest() {
        List<Ride> rides = new LinkedList<>();

        rides.add(createRide(new ExtraTime(EXTRA_TIME), 1L, LocalDateTime.parse("2024-04-28T10:00:00"), LocalDateTime.parse("2024-04-28T10:20:00")));
        rides.add(createRide(new ExtraTime(EXTRA_TIME), 2L, LocalDateTime.parse("2024-04-27T11:30:00"), LocalDateTime.parse("2024-04-27T11:35:00")));

        rides.add(createRide(new ExtraTime(EXTRA_TIME), 3L, LocalDateTime.parse("2024-03-28T10:00:00"), LocalDateTime.parse("2024-03-28T10:20:00")));
        rides.add(createRide(new ExtraTime(EXTRA_TIME), 4L, LocalDateTime.parse("2024-03-27T11:30:00"), LocalDateTime.parse("2024-03-27T11:35:00")));
        rides.add(createRide(new ExtraTime(EXTRA_TIME), 5L, LocalDateTime.parse("2024-03-26T10:00:00"), LocalDateTime.parse("2024-03-26T10:20:00")));
        rides.add(createRide(new ExtraTime(EXTRA_TIME), 6L, LocalDateTime.parse("2024-03-25T11:30:00"), LocalDateTime.parse("2024-03-25T11:35:00")));

        rides.add(createRide(new ExtraTime(EXTRA_TIME), 7L, LocalDateTime.parse("2024-01-28T10:00:00"), LocalDateTime.parse("2024-01-28T10:20:00")));
        rides.add(createRide(new ExtraTime(EXTRA_TIME), 8L, LocalDateTime.parse("2024-01-27T11:30:00"), LocalDateTime.parse("2024-01-27T11:35:00")));
        rides.add(createRide(new ExtraTime(EXTRA_TIME), 9L, LocalDateTime.parse("2024-01-26T10:00:00"), LocalDateTime.parse("2024-01-26T10:20:00")));
        rides.add(createRide(new ExtraTime(EXTRA_TIME), 10L, LocalDateTime.parse("2024-01-25T11:30:00"), LocalDateTime.parse("2024-01-25T11:35:00")));
        rides.add(createRide(new ExtraTime(EXTRA_TIME), 11L, LocalDateTime.parse("2024-01-26T14:00:00"), LocalDateTime.parse("2024-01-26T14:20:00")));
        rides.add(createRide(new ExtraTime(EXTRA_TIME), 12L, LocalDateTime.parse("2024-01-25T15:30:00"), LocalDateTime.parse("2024-01-25T15:35:00")));

        return rides;
    }

    private static Ride createRide(Ride ride, Long id, LocalDateTime start, LocalDateTime end) {
        ride.start(new RideId(id), TEST_START_POSITION, start);
        ride.end(TEST_END_POSITION, end);

        return ride;
    }

}
