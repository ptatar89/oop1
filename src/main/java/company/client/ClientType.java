package main.java.company.client;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ClientType {
    INDIVIDUAL("individual"),
    BUSINESS("business");

    @Getter
    private final String clientTypeName;

    static class ClientTypeMapper {
        static ClientType map(String clientType) {
            return ClientType.valueOf(clientType);
        }
    }

}
