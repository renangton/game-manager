package com.gamemanager.domain.platform;

import com.github.f4b6a3.ulid.UlidCreator;
import java.util.Objects;

public class PlatformId {
    private final String value;

    public PlatformId() {
        this.value = UlidCreator.getUlid().toString();
    }

    public PlatformId(String value) {
        if (!isValidUlid(value)) {
            throw new IllegalArgumentException("Invalid ULID format");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private boolean isValidUlid(String ulid) {
        return ulid != null && ulid.matches("^[0123456789ABCDEFGHJKMNPQRSTVWXYZ]{26}$");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlatformId that = (PlatformId) o;
        return Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
