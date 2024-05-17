package company.discount;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static company.discount.DiscountLevel.*;
import static org.junit.jupiter.api.Assertions.*;

class RideDiscountPolicyTest {

    @ParameterizedTest
    @MethodSource("provideDataForTest")
    void shouldReturnCorrectDiscountLevel(int rideCount, double expectedDiscount) {
        //when
        Discount discountPolicy = new RideDiscountPolicy(rideCount);
        //expected
        assertEquals(expectedDiscount, discountPolicy.discount());
    }

    private static Stream<Arguments> provideDataForTest() {
        return Stream.of(
                Arguments.of(201, LEVEL_4.discount),
                Arguments.of(200, LEVEL_3.discount),
                Arguments.of(199, LEVEL_3.discount),
                Arguments.of(151, LEVEL_3.discount),
                Arguments.of(150, LEVEL_2.discount),
                Arguments.of(149, LEVEL_2.discount),
                Arguments.of(101, LEVEL_2.discount),
                Arguments.of(100, LEVEL_1.discount),
                Arguments.of(99, LEVEL_1.discount),
                Arguments.of(51, LEVEL_1.discount),
                Arguments.of(50, LEVEL_0.discount),
                Arguments.of(49, LEVEL_0.discount),
                Arguments.of(1, LEVEL_0.discount),
                Arguments.of(0, LEVEL_0.discount)
        );
    }


}