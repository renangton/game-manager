package com.gamemanager.usecase.platform.find;

import com.gamemanager.domain.platform.Platform;
import com.gamemanager.domain.platform.PlatformDto;
import com.gamemanager.domain.platform.PlatformId;
import com.gamemanager.domain.shared.lock.Version;
import com.gamemanager.infra.platform.PlatformRdbRepository;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FindAllPlatformUseCaseImplTest {
    @Mock
    private PlatformRdbRepository platformRdbRepository;

    @InjectMocks
    private FindAllPlatformUseCaseImpl findAllPlatformUseCase;

    @Test
    void プラットフォームを全件取得できること() {
        // given
        PlatformDto platformDto1 = new PlatformDto(
                "01F9SNHD3GY8E0RNHDY1T5PMTV",
                "PS4",
                LocalDateTime.of(2024, 3, 8, 12, 30, 30),
                "API",
                LocalDateTime.of(2024, 3, 8, 12, 30, 30),
                "API",
                0
        );
        PlatformDto platformDto2 = new PlatformDto(
                "01F9SNHD3H63J5NW9KYK56QZ0Y",
                "PS5",
                LocalDateTime.of(2024, 5, 8, 12, 30, 30),
                "API2",
                LocalDateTime.of(2024, 5, 8, 12, 30, 30),
                "API2",
                1
        );
        List<PlatformDto> platformDtoList = Arrays.asList(platformDto1, platformDto2);
        when(platformRdbRepository.findAll()).thenReturn(platformDtoList);

        // when
        List<Platform> actualPlatformList = findAllPlatformUseCase.findAllPlatform();

        // then
        Platform expectedPlatform1 = new Platform(
                new PlatformId("01F9SNHD3GY8E0RNHDY1T5PMTV"),
                "PS4",
                LocalDateTime.of(2024, 3, 8, 12, 30, 30),
                "API",
                LocalDateTime.of(2024, 3, 8, 12, 30, 30),
                "API",
                new Version(0)
        );
        Platform expectedPlatform2 = new Platform(
                new PlatformId("01F9SNHD3H63J5NW9KYK56QZ0Y"),
                "PS5",
                LocalDateTime.of(2024, 5, 8, 12, 30, 30),
                "API2",
                LocalDateTime.of(2024, 5, 8, 12, 30, 30),
                "API2",
                new Version(1)
        );
        List<Platform> expectedPlatformList = Arrays.asList(expectedPlatform1, expectedPlatform2);
        assertEquals(expectedPlatformList, actualPlatformList);
        verify(platformRdbRepository, times(1)).findAll();
    }

    @Test
    void 空のプラットフォームリストを取得できること() {
        // given
        when(platformRdbRepository.findAll()).thenReturn(Arrays.asList());

        // when
        List<Platform> actualPlatformList = findAllPlatformUseCase.findAllPlatform();

        // then
        assertEquals(Arrays.asList(), actualPlatformList);
        verify(platformRdbRepository, times(1)).findAll();
    }
}
