package com.gamemanager.domain.shared.lock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class VersionTest {
    @Test
    public void 初期バージョンが正しく生成されること() {
        // when
        Version version = Version.initial();

        // then
        assertEquals(0, version.value());
    }

    @Test
    public void バージョンの等価性が正しく比較されること() {
        // when
        Version version1 = new Version(1);
        Version version2 = new Version(1);
        Version version3 = new Version(2);

        // then
        assertEquals(version1, version2);
        assertNotEquals(version1, version3);
        assertNotEquals(version2, version3);
    }
}
