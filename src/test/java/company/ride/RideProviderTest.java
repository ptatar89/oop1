package company.ride;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.YearMonth;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RideProviderTest {

    List<Ride> rides = new LinkedList<>();

    @BeforeAll
    void setUp() {
        rides.clear();
        rides.add(Normal);

     }

    @Test
    @MethodSource("provideRides")
    void shouldReturnCorrectCountOfRidesByMonthYear(YearMonth yearMonth, int countOfRides) {

    }

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of(YearMonth.of(2024, 4), 2),
                Arguments.of(YearMonth.of(2024, 3), 4),
                Arguments.of(YearMonth.of(2024, 2), 0),
                Arguments.of(YearMonth.of(2024, 1), 6)
        );
    }



}