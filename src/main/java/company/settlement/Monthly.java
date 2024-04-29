package company.settlement;

import company.ride.Ride;

import java.util.List;

import static java.lang.Long.sum;

public class Monthly implements Settlement {

    Long duration = 0L;

    @Override
    public Long settle(List<Ride> ridesToSettle) {
        ridesToSettle.forEach(ride -> duration = sum(duration, ride.durationToBeSettled()));

        return duration;
    }
}
