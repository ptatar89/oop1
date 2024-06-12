package company.ride;

import company.maintanace.Position;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.YearMonth;

public class ExtraTime implements Ride {

    public static Long EXTRA_TIME = 15L;

    Long extraTime;

    RideId id;
    RideDetails start;
    RideDetails end;

    public ExtraTime(Long extraTime) {
        this.extraTime = extraTime;
    }

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
        if (Duration.between(start.time().plusMinutes(EXTRA_TIME), end.time()).toMinutes() < 0L) {
            return 0L;
        }

        return Duration.between(start.time().plusMinutes(EXTRA_TIME), end.time()).toMinutes();
    }

    public boolean matchByYearMonth(YearMonth yearMonth) {
        return end.time().getMonth() == yearMonth.getMonth() && end.time().getYear() == yearMonth.getYear();
    }
}
