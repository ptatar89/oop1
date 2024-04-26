package company.ride;

import company.maintanace.Position;

import java.time.LocalDateTime;

public interface Ride {
    void start(Position position, LocalDateTime time);

    void end(Position position, LocalDateTime time);
}
