package company.discount;

import company.client.ClientLoyaltyPoints;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DiscountDecoratorTest {

    @ParameterizedTest
    @MethodSource("provideDiscountData")
    void shouldApplyCorrectDiscountsOnBasePrice(float basePrice, int rideCount, ClientLoyaltyPoints clientLoyaltyPoints, float expectedPrice) {
        //when
        var decorator = new DiscountDecorator(basePrice, rideCount, clientLoyaltyPoints);

        //expected
        assertEquals(expectedPrice, decorator.decorate());
    }

    private static Stream<Arguments> provideDiscountData() {
        return Stream.of(
                // brak rabatu
                Arguments.of(100f, 10, new ClientLoyaltyPoints(10), 100f),
                // rabat 5% za 500 pkt lojalnosciowych
                Arguments.of(100f, 10, new ClientLoyaltyPoints(501), 95f),
                // rabat 5% powyżej 50 przejazdów, brak rabatu lojalnosciowego
                Arguments.of(100f, 51, new ClientLoyaltyPoints(10), 95f),
                // rabat 10% powyżej 100 przejazdów, brak rabatu lojalnosciowego
                Arguments.of(100f, 101, new ClientLoyaltyPoints(10), 90f),
                // rabat 15% powyżej 150 przejazdów, brak rabatu lojalnosciowego
                Arguments.of(100f, 151, new ClientLoyaltyPoints(10), 85f),
                // rabat 20% powyżej 200 przejazdów, brak rabatu lojalnosciowego
                Arguments.of(100f, 201, new ClientLoyaltyPoints(10), 80f),
                // rabat 5% powyżej 50 przejazdów, dodatkowy rabat 5% za 500 pkt lojalnosciowych
                Arguments.of(100f, 51, new ClientLoyaltyPoints(501), 90.25f),
                // rabat 10% powyżej 100 przejazdów, dodatkowy rabat 5% za 500 pkt lojalnosciowych
                Arguments.of(100f, 101, new ClientLoyaltyPoints(501), 85.5f),
                // rabat 15% powyżej 150 przejazdów, dodatkowy rabat 5% za 500 pkt lojalnosciowych
                Arguments.of(100f, 151, new ClientLoyaltyPoints(501), 80.75f),
                // rabat 20% powyżej 200 przejazdów, dodatkowy rabat 5% za 500 pkt lojalnosciowych
                Arguments.of(100f, 201, new ClientLoyaltyPoints(501), 76.0f)
        );
    }

}