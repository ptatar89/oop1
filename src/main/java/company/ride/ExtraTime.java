package company.ride;

import company.maintanace.Position;

import java.time.Duration;
import java.time.LocalDateTime;

public class ExtraTime implements Ride {

    static Long EXTRA_TIME = 15L;

    Long extraTime;

    RideDetails start;
    RideDetails end;

    ExtraTime(Long extraTime) {
        this.extraTime = extraTime;
    }

    @Override
    public void start(Position position, LocalDateTime time) {
        start = new RideDetails(position, time);
    }

    @Override
    public void end(Position position, LocalDateTime time) {
        end = new RideDetails(position, time);
    }

    @Override
    public Long duration() {
        if (Duration.between(start.time().minusMinutes(EXTRA_TIME), end.time()).toMinutes() < 0L) {
            return 0L;
        }

        return Duration.between(start.time(), end.time()).toMinutes();
    }

}
