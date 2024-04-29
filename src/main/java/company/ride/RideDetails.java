package company.ride;

import company.maintanace.Position;
import lombok.Getter;
import lombok.Value;

import java.time.LocalDateTime;

public record RideDetails(Position position, LocalDateTime time) {
}
