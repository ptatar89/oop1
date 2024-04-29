package company.ride;

import company.maintanace.Position;

import java.time.LocalDateTime;
import java.time.YearMonth;

public interface Ride {
    void start(Position position, LocalDateTime time);

    void end(Position position, LocalDateTime time);

    Long duration();

    Long durationToBeSettled();

    boolean matchByYearMonth(YearMonth yearMonth);
}
