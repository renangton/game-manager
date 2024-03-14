package com.gamemanager.domain.platform;

import com.gamemanager.domain.shared.lock.Version;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class PlatformTest {
    @Test
    public void 新しいプラットフォームを作成するとバージョン0のインスタンスが作成されること() {
        // given
        LocalDateTime localDateTime = LocalDateTime.of(2024, 3, 14, 12, 0, 0);
        MockedStatic<LocalDateTime> mockedLocalDateTime = Mockito.mockStatic(LocalDateTime.class);
        mockedLocalDateTime.when(LocalDateTime::now).thenReturn(localDateTime);
        Version version = new Version(0);
        MockedStatic<Version> mockedVersion = Mockito.mockStatic(Version.class);
        mockedVersion.when(Version::initial).thenReturn(version);

        // when
        String name = "PS5";
        String createdBy = "API";
        Platform platform = Platform.create("PS5", "API");

        // then
        assertEquals(name, platform.getName());
        assertEquals(localDateTime, platform.getCreatedAt());
        assertEquals(createdBy, platform.getCreatedBy());
        assertEquals(localDateTime, platform.getUpdatedAt());
        assertEquals(createdBy, platform.getUpdatedBy());
        assertEquals(new Version(0), platform.getVersion());
    }

    @Test
    public void プラットフォームを再構築すると正しい属性のインスタンスが作成されること() {
        // when
        PlatformId platformId = new PlatformId();
        String name = "PS5";
        String createdBy = "API";
        LocalDateTime createdAt = LocalDateTime.of(2024, 3, 14, 12, 0, 0);
        LocalDateTime updatedAt = LocalDateTime.of(2024, 3, 14, 12, 0, 0);
        String updatedBy = "User";
        Version version = new Version(1);
        Platform reconstructedPlatform = Platform.reconstruct(platformId, name, createdAt, createdBy, updatedAt, updatedBy, version);

        // then
        assertEquals(platformId, reconstructedPlatform.getPlatformId());
        assertEquals(name, reconstructedPlatform.getName());
        assertEquals(createdAt, reconstructedPlatform.getCreatedAt());
        assertEquals(createdBy, reconstructedPlatform.getCreatedBy());
        assertEquals(updatedAt, reconstructedPlatform.getUpdatedAt());
        assertEquals(updatedBy, reconstructedPlatform.getUpdatedBy());
        assertEquals(version, reconstructedPlatform.getVersion());
    }

    @Test
    public void プラットフォームが指定の属性に更新されること() {
        // when
        String name = "PS5";
        LocalDateTime createdAt = LocalDateTime.of(2024, 3, 14, 12, 0, 0);
        String createdBy = "API";
        Platform platform = new Platform(new PlatformId(), name, createdAt, createdBy, createdAt, createdBy, new Version(0));
        String updatedName = "Steam";
        LocalDateTime updatedAt = LocalDateTime.of(2024, 4, 14, 12, 0, 0);
        String updatedBy = "User";
        platform.updatePlatform(updatedName, updatedAt, updatedBy);

        // then
        assertEquals(updatedName, platform.getName());
        assertEquals(updatedAt, platform.getUpdatedAt());
        assertEquals(updatedBy, platform.getUpdatedBy());
    }
}
