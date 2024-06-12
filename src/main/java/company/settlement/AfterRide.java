package company.settlement;

import company.ride.Ride;

import java.util.List;

public class AfterRide implements Settlement {

    @Override
    public Long settle(List<Ride> ridesToSettle) {
        throw new RuntimeException("not implemented yet");
    }
}
