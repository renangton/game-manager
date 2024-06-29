package com.gamemanager.domain.platform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PlatformIdTest {

    @Test
    public void デフォルトコンストラクタはnullおよび空文字以外を生成すること() {
        // when
        PlatformId platformId = new PlatformId();

        // then
        assertNotNull(platformId.getValue());
        assertFalse(platformId.getValue().isEmpty());
    }

    @Test
    public void パラメータ付きコンストラクタは初期化された値を正しく返すこと() {
        // when
        String testValue = "01F9SNHD3GY8E0RNHDY1T5PMTV";

        // then
        PlatformId platformId = new PlatformId(testValue);
        assertEquals(testValue, platformId.getValue());
    }

    @ParameterizedTest
    @CsvSource({
            "null, Invalid ULID format",
            "'', Invalid ULID format",
            "invalid-ulid, Invalid ULID format",
            "123, Invalid ULID format",
            "01F9SNHD3GY8E0RNHDY1T5PMT@, Invalid ULID format"
    })
    public void パラメータ付きコンストラクタは無効なULIDを渡されたとき例外をスローすること(String testValue, String expectedMessage) {
        // when
        String actualValue = testValue.equals("null") ? null : testValue;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new PlatformId(actualValue);
        });

        // then
        assertEquals(expectedMessage, exception.getMessage());
    }
}
