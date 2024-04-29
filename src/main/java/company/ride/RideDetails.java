package company.ride;

import company.maintanace.Position;

import java.time.LocalDateTime;

public record RideDetails(Position position, LocalDateTime time) {
}
