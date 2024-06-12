package company.maintanace;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import test.java.company.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BatteryTest extends BaseTest {

    @Test
    void shouldReturnBatteryLevelValue() {
        Battery battery = new Battery(1);

        Assertions.assertEquals(1, battery.level);
    }

    @ParameterizedTest
    @ValueSource(ints = {-3, 115, Integer.MIN_VALUE, Integer.MAX_VALUE})
    void shouldThrowExceptionOnWrongBatteryLevelValue(Integer level) {
        Assertions.assertThrows(RuntimeException.class, () -> {
            new Battery(level);
        });
    }
}