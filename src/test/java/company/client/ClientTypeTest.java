package company.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static company.client.ClientType.fromName;
import static java.util.stream.Stream.*;
import static company.client.ClientType.BUSINESS;
import static company.client.ClientType.INDIVIDUAL;

public class ClientTypeTest {

    @ParameterizedTest
    @MethodSource("provideStringsToBeMappedAsClientType")
    void shouldMapStringToCorrectClientType(String stringToByMap, ClientType clientType) {
        //expected
        Assertions.assertEquals(clientType, fromName(stringToByMap));
    }

    @Test
    void shouldThrowExceptionOnNoExistType() {
        //given
        String clientType = "nonExistingClientType";

        //expected
        Assertions.assertThrows(IllegalArgumentException.class, () -> fromName(clientType));
    }

    private static Stream<Arguments> provideStringsToBeMappedAsClientType() {
        return of(
                Arguments.of("INDIVIDUAL", INDIVIDUAL),
                Arguments.of("BUSINESS", BUSINESS)
        );
    }


}
