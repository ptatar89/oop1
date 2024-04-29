package company.ride;

import company.maintanace.Position;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;

public class Normal implements Ride {

    RideDetails start;
    RideDetails end;

//    public static Ride create(RideDetails start, RideDetails end) {
//        this.start = start;
//        this.end = end;
//
//        return this;
//    }

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
