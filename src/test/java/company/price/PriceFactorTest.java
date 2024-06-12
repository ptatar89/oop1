package company.price;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceFactorTest {

    @Test
    void shouldReturnCorrectBasePriceByUsageTime() {
        //given
        var duration = 10l;

        //expected
        assertEquals(10l, PriceFactor.calculatePriceByDuration(duration));
    }

}