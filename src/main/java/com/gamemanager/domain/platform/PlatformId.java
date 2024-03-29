package com.gamemanager.domain.platform;

import com.github.f4b6a3.ulid.UlidCreator;

public class PlatformId {
    private final String value;

    public PlatformId() {
        this.value = UlidCreator.getUlid().toString();
    }

    public PlatformId(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
