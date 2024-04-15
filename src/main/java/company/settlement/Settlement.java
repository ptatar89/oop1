package main.java.company.settlement;

import main.java.company.rental.Ride;

import java.util.List;

public interface Settlement {
    void settle(List<Ride> ridesToSettle);
}
