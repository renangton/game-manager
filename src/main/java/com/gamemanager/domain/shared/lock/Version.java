package com.gamemanager.domain.shared.lock;

import java.util.Objects;

public record Version(int value) {

    public static Version initial() {
        return new Version(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Version version = (Version) o;
        return value() == version.value();
    }
}
