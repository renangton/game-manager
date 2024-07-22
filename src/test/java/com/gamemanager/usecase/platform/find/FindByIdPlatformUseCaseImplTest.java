package com.gamemanager.usecase.platform.find;

import com.gamemanager.domain.platform.Platform;
import com.gamemanager.domain.platform.PlatformDto;
import com.gamemanager.domain.platform.PlatformId;
import com.gamemanager.domain.shared.lock.Version;
import com.gamemanager.exception.ResourceNotFoundException;
import com.gamemanager.infra.platform.PlatformRdbRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FindByIdPlatformUseCaseImplTest {
    @Mock
    private PlatformRdbRepository platformRdbRepository;

    @InjectMocks
    private FindByIdPlatformUseCaseImpl findByIdPlatformUseCase;

    @Test
    void プラットフォームを1件取得できること() {
        // given
        String platformId = "01F9SNHD3GY8E0RNHDY1T5PMTV";
        PlatformDto platformDto = new PlatformDto(
                platformId,
                "PS4",
                LocalDateTime.of(2024, 3, 8, 12, 30, 30),
                "API",
                LocalDateTime.of(2024, 3, 8, 12, 30, 30),
                "API",
                0
        );
        when(platformRdbRepository.findById(platformId)).thenReturn(Optional.of(platformDto));

        // when
        Platform actualPlatform = findByIdPlatformUseCase.findByIdPlatform(platformId);

        // then
        Platform expectedPlatform = new Platform(
                new PlatformId(platformDto.getPlatformId()),
                platformDto.getName(),
                platformDto.getCreatedAt(),
                platformDto.getCreatedBy(),
                platformDto.getUpdatedAt(),
                platformDto.getUpdatedBy(),
                new Version(platformDto.getVersion())
        );
        assertEquals(expectedPlatform, actualPlatform);
        verify(platformRdbRepository, times(1)).findById(platformId);
    }

    @Test
    void プラットフォームが存在しない場合例外がスローされること() {
        // given
        String platformId = "01F9SNHD3GY8E0RNHDY1T5PMTV";
        when(platformRdbRepository.findById(platformId)).thenReturn(Optional.empty());

        // when・then
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            findByIdPlatformUseCase.findByIdPlatform(platformId);
        });
        assertEquals("Platform with ID " + platformId + " not found", exception.getMessage());
        verify(platformRdbRepository, times(1)).findById(platformId);
    }
}
