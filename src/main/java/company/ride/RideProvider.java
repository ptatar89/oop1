package company.ride;

import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

public class RideProvider {

    public List<Ride> getRideByMonth(YearMonth month, List<Ride> allRides) {
        return allRides.stream()
                .filter(ride -> ride.matchByYearMonth(month)).
                collect(Collectors.toList());
    }

}
