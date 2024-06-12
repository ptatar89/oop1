package company.maintanace;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static company.maintanace.MaintenancePolicy.shouldBeMaintenance;

class MaintenancePolicyTest {

    @ParameterizedTest
    @MethodSource("providePositionForTest")
    void shouldReturnBooleanIfWithinRadius(Position position, Battery battery, Boolean expected) {
        // expected
        Assertions.assertEquals(expected, shouldBeMaintenance(position, battery));
    }

    private static Stream<Arguments> providePositionForTest() {
        return Stream.of(
                Arguments.of(Position.from(50.071184F,19.939664F), new Battery(5) ,true),
                Arguments.of(Position.from(50.067217F,19.950479F), new Battery(45), false),
                Arguments.of(Position.from(50.072065F,19.944299F), new Battery(0), true),
                Arguments.of(Position.from(50.062148F,19.964727F), new Battery(40), true),
                Arguments.of(Position.from(50.075921F,19.888509F), new Battery(55), false),
                Arguments.of(Position.from(50.075921F,19.888509F), new Battery(35), false)
        );
    }
}