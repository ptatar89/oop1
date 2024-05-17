package company.discount;

import company.client.ClientLoyaltyPoints;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static company.discount.LoyaltyDiscountPolicy.LOYALTY_DISCOUNT;
import static company.discount.LoyaltyDiscountPolicy.LOYALTY_NO_DISCOUNT;
import static org.junit.jupiter.api.Assertions.*;

class LoyaltyDiscountPolicyTest {

    @ParameterizedTest
    @MethodSource("provideDataForTest")
    void shouldReturnLoyaltyDiscount(ClientLoyaltyPoints clientLoyaltyPoints, double expectedDiscount) {
        //when
        Discount discountPolicy = new LoyaltyDiscountPolicy(clientLoyaltyPoints);
        //expected
        assertEquals(expectedDiscount, discountPolicy.discount());
    }

    private static Stream<Arguments> provideDataForTest() {
        return Stream.of(
                Arguments.of(new ClientLoyaltyPoints(501), LOYALTY_DISCOUNT),
                Arguments.of(new ClientLoyaltyPoints(500), LOYALTY_NO_DISCOUNT),
                Arguments.of(new ClientLoyaltyPoints(499), LOYALTY_NO_DISCOUNT),
                Arguments.of(new ClientLoyaltyPoints(1), LOYALTY_NO_DISCOUNT),
                Arguments.of(new ClientLoyaltyPoints(0), LOYALTY_NO_DISCOUNT)
        );
    }
}