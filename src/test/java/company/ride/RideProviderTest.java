package company.ride;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static test.java.company.BaseTest.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RideProviderTest {

    List<Ride> rides = new LinkedList<>();

    @BeforeAll
    void setUp() {
        rides.clear();
        rides.addAll(getListOfRidesForTest());
    }

    @ParameterizedTest
    @MethodSource("provideRides")
    void shouldReturnCorrectCountOfRidesByMonthYear(YearMonth yearMonth, int countOfRides) {
        //given
        var listOfAllRides = rides;

        //expected
        RideProvider rideProvider = new RideProvider();
        Assertions.assertEquals(countOfRides, rideProvider.getRideByMonth(yearMonth, listOfAllRides).size());
    }

    private static Stream<Arguments> provideRides() {
        return Stream.of(
                Arguments.of(YearMonth.of(2024, 4), 2),
                Arguments.of(YearMonth.of(2024, 3), 4),
                Arguments.of(YearMonth.of(2024, 2), 0),
                Arguments.of(YearMonth.of(2024, 1), 6)
        );
    }



}