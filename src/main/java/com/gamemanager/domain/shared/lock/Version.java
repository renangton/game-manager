package com.gamemanager.domain.shared.lock;

public record Version(int value) {
    public static Version initial() {
        return new Version(0);
    }
}
