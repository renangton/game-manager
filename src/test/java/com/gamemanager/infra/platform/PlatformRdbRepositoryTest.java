package com.gamemanager.infra.platform;

import com.gamemanager.domain.platform.Platform;
import com.gamemanager.domain.platform.PlatformDto;
import com.gamemanager.domain.platform.PlatformId;
import com.gamemanager.domain.shared.lock.Version;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PlatformRdbRepositoryTest {
    @Mock
    private PlatformMapper platformMapper;

    @InjectMocks
    private PlatformRdbRepository platformRdbRepository;

    @AfterEach
    void resetMock() {
        reset(platformMapper);
    }

    @Test
    void プラットフォームを全件取得できること() {
        // given
        PlatformDto platform1 = new PlatformDto(
                "01F9SNHD3GY8E0RNHDY1T5PMTV",
                "PS4",
                LocalDateTime.of(2024, 3, 8, 12, 30, 30),
                "API",
                LocalDateTime.of(2024, 3, 8, 12, 30, 30),
                "API",
                0
        );
        PlatformDto platform2 = new PlatformDto(
                "01F9SNHD3H63J5NW9KYK56QZ0Y", "PS5",
                LocalDateTime.of(2024, 3, 8, 12, 30, 30),
                "API",
                LocalDateTime.of(2024, 3, 8, 12, 30, 30),
                "API",
                0
        );
        List<PlatformDto> platformList = Arrays.asList(platform1, platform2);
        when(platformMapper.selectAll()).thenReturn(platformList);

        // when
        List<PlatformDto> actualPlatformList = platformRdbRepository.findAll();

        // then
        assertEquals(platformList, actualPlatformList);
        verify(platformMapper, times(1)).selectAll();
    }

    @Test
    void プラットフォームを1件取得できること() {
        // given
        String platformId = "01F9SNHD3GY8E0RNHDY1T5PMTV";
        PlatformDto expectedPlatform = new PlatformDto(platformId, "PS4",
                LocalDateTime.of(2024, 3, 8, 12, 30, 30),
                "API",
                LocalDateTime.of(2024, 3, 8, 12, 30, 30),
                "API",
                0
        );
        when(platformMapper.selectById(platformId)).thenReturn(Optional.of(expectedPlatform));

        // when
        Optional<PlatformDto> actualPlatform = platformRdbRepository.findById(platformId);

        // then
        assertEquals(Optional.of(expectedPlatform), actualPlatform);
        verify(platformMapper, times(1)).selectById(platformId);
    }

    @Test
    void 指定したIDのプラットフォームが存在しない場合空のOptionalを取得すること() {
        // given
        String platformId = "01F9SNHD3GY8E0RNHDY1T5PMTV";
        when(platformMapper.selectById(platformId)).thenReturn(Optional.empty());

        // when
        Optional<PlatformDto> actualPlatform = platformRdbRepository.findById(platformId);

        // then
        assertEquals(Optional.empty(), actualPlatform);
        verify(platformMapper, times(1)).selectById(platformId);
    }

    @Test
    void プラットフォームを保存できること() {
        // given
        PlatformId platformId = new PlatformId("01J1FM6SP9D5GG003QR0N5WD0K");
        Platform platform = new Platform(
                platformId,
                "3DS",
                LocalDateTime.of(2024, 6, 8, 12, 30, 30),
                "API",
                LocalDateTime.of(2024, 6, 8, 12, 30, 30),
                "API",
                new Version(0)
        );
        doNothing().when(platformMapper).insert(
                platformId.getValue(),
                "3DS",
                LocalDateTime.of(2024, 6, 8, 12, 30, 30),
                "API",
                LocalDateTime.of(2024, 6, 8, 12, 30, 30),
                "API",
                0
        );

        // when
        platformRdbRepository.save(platform);

        // then
        verify(platformMapper, times(1)).insert(
                platformId.getValue(),
                "3DS",
                LocalDateTime.of(2024, 6, 8, 12, 30, 30),
                "API",
                LocalDateTime.of(2024, 6, 8, 12, 30, 30),
                "API",
                0
        );
    }

    @Test
    void プラットフォームを更新できること() {
        // given
        PlatformId platformId = new PlatformId("01F9SNHD3GY8E0RNHDY1T5PMTV");
        Platform platform = new Platform(
                platformId,
                "NEOGEO",
                LocalDateTime.of(2024, 6, 8, 12, 30, 30),
                "API",
                LocalDateTime.of(2024, 6, 8, 12, 30, 30),
                "API2",
                new Version(0)
        );
        doNothing().when(platformMapper).update(
                platformId.getValue(),
                "NEOGEO",
                LocalDateTime.of(2024, 6, 8, 12, 30, 30),
                "API2",
                0
        );

        // when
        platformRdbRepository.update(platform);

        // then
        verify(platformMapper, times(1)).update(
                platformId.getValue(),
                "NEOGEO",
                LocalDateTime.of(2024, 6, 8, 12, 30, 30),
                "API2",
                0
        );
    }

    @Test
    void プラットフォームを削除できること() {
        // given
        PlatformId platformId = new PlatformId("01F9SNHD3GY8E0RNHDY1T5PMTV");
        doNothing().when(platformMapper).delete(platformId.getValue());

        // when
        platformRdbRepository.delete(platformId);

        // then
        verify(platformMapper, times(1)).delete(platformId.getValue());
    }
}
