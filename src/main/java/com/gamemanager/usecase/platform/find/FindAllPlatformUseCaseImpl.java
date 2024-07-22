package com.gamemanager.usecase.platform.find;

import com.gamemanager.domain.platform.Platform;
import com.gamemanager.domain.platform.PlatformDto;
import com.gamemanager.domain.platform.PlatformId;
import com.gamemanager.domain.shared.lock.Version;
import com.gamemanager.infra.platform.PlatformRdbRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class FindAllPlatformUseCaseImpl implements FindAllPlatformUseCase {
    private final PlatformRdbRepository platformRdbRepository;

    public FindAllPlatformUseCaseImpl(PlatformRdbRepository platformRdbRepository) {
        this.platformRdbRepository = platformRdbRepository;
    }

    /**
     * プラットフォームを全件取得する
     *
     * @return プラットフォームのリスト
     */
    @Override
    public List<Platform> findAllPlatform() {
        List<PlatformDto> platformDtoList = platformRdbRepository.findAll();

        return platformDtoList.stream()
                .map(dto -> new Platform(
                        new PlatformId(dto.getPlatformId()),
                        dto.getName(),
                        dto.getCreatedAt(),
                        dto.getCreatedBy(),
                        dto.getUpdatedAt(),
                        dto.getUpdatedBy(),
                        new Version(dto.getVersion())
                ))
                .collect(Collectors.toList());
    }
}
