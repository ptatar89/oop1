package main.java.company.rental;

import java.util.UUID;

public record RideUUID(UUID id) {

    public static RideUUID generate() {
        return new RideUUID(UUID.randomUUID());
    }
}
