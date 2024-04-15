package main.java.company.rental;

import main.java.company.maintanace.Position;

import java.time.LocalDateTime;

public class Ride {
    RideUUID rideId;
    Position startPosition;
    Position endPosition;
    LocalDateTime startTime;
    LocalDateTime endTime;

    public Ride() {
        rideId = RideUUID.generate();
        throw new RuntimeException("not implemented yet");
    }

    public void start(Position position, LocalDateTime time) {
        startPosition = position;
        startTime = time;
    }

    public void end(Position position, LocalDateTime time) {
        endPosition = position;
        endTime = time;
    }
}
