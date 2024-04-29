package company.ride;

import company.maintanace.Position;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.YearMonth;

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
        return start.time().getMonth() == yearMonth.getMonth() && start.time().getYear() == yearMonth.getYear();
    }
}
