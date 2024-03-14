package com.gamemanager.domain.platform;

import com.github.f4b6a3.ulid.UlidCreator;
import java.util.Objects;

public class PlatformId {
    private final String value;

    public PlatformId() {
        this.value = UlidCreator.getUlid().toString();
    }

    public String getValue() {
        return value;
    }
}
