package company.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClientIdTest {

    @Test
    void shouldCreateClientId() {
        //given
        Long id = 123L;

        //when
        ClientId clientId = new ClientId(id);

        //expected
        Assertions.assertEquals(clientId.id(), id);
    }

    @Test
    void shouldThrowExceptionOnWrongClientId() {
        //expected
        Assertions.assertThrows(RuntimeException.class, () -> new ClientId(null));
    }
}
