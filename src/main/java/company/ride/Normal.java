package company.ride;

import company.maintanace.Position;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.YearMonth;

public class Normal implements Ride {

    RideId id;
    RideDetails start;
    RideDetails end;


    @Override
    public void start(RideId id, Position position, LocalDateTime time) {
        this.id = id;
        start = new RideDetails(position, time);
    }

    @Override
    public void end(Position position, LocalDateTime time) {
        end = new RideDetails(position, time);
    }

    @Override
    public Long duration() {
        return Duration.between(start.time(), end.time()).toMinutes();
    }

    @Override
    public Long durationToBeSettled() {
        return duration();
    }

    public boolean matchByYearMonth(YearMonth yearMonth) {
        return start.time().getMonth() == yearMonth.getMonth() && start.time().getYear() == yearMonth.getYear();
    }
}
