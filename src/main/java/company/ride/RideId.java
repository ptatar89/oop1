package company.ride;

import java.util.Random;

public record RideId(Long id) {
    public RideId {
        if (id == null) {
            throw new RuntimeException("Id cant be null");
        }
    }

    public static RideId create() {
        return new RideId(new Random().nextLong());
    }
}
