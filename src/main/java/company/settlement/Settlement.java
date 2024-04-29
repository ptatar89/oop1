package company.settlement;

import company.ride.Ride;

import java.util.List;

public interface Settlement {
    Long settle(List<Ride> ridesToSettle);
}
