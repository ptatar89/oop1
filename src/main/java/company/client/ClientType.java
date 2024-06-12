package company.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

@AllArgsConstructor
public enum ClientType {
    INDIVIDUAL,
    BUSINESS;

    public static ClientType fromName(@Nullable String name) {
        return valueOf(name);
    }

}
