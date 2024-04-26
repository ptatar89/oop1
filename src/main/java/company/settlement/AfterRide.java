package company.settlement;

import company.rental.Ride;

import java.util.List;

public class AfterRide implements Settlement {

    @Override
    public void settle(List<Ride> ridesToSettle) {
        throw new RuntimeException("not implemented yet");
    }
}
