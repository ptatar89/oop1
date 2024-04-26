package company.settlement;

import company.rental.Ride;

import java.util.List;

public interface Settlement {
    void settle(List<Ride> ridesToSettle);
}
