package company.ride;

public record RideId(Long id) {
    public RideId {
        if (id == null) {
            throw new RuntimeException("Id cant be null");
        }
    }
}
