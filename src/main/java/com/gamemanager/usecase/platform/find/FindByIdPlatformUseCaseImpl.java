package com.gamemanager.usecase.platform.find;

import com.gamemanager.domain.platform.Platform;
import com.gamemanager.domain.platform.PlatformDto;
import com.gamemanager.domain.platform.PlatformId;
import com.gamemanager.domain.shared.lock.Version;
import com.gamemanager.exception.ResourceNotFoundException;
import com.gamemanager.infra.platform.PlatformRdbRepository;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class FindByIdPlatformUseCaseImpl implements FindByIdPlatformUseCase {
    private final PlatformRdbRepository platformRdbRepository;

    public FindByIdPlatformUseCaseImpl(PlatformRdbRepository platformRdbRepository) {
        this.platformRdbRepository = platformRdbRepository;
    }

    /**
     * プラットフォームを1件取得する
     *
     * @param platformId プラットフォームID
     * @return 指定されたIDに対応するプラットフォーム
     * @throws ResourceNotFoundException 指定されたIDに対応するプラットフォームが存在しない場合にスロー
     */
    @Override
    public Platform findByIdPlatform(String platformId) {
        Optional<PlatformDto> platformDtoOptional = platformRdbRepository.findById(platformId);
        if (platformDtoOptional.isEmpty()) {
            throw new ResourceNotFoundException("Platform with ID " + platformId + " not found");
        } else {
            PlatformDto platformDto = platformDtoOptional.get();
            Platform platform = new Platform(
                    new PlatformId(platformDto.getPlatformId()),
                    platformDto.getName(),
                    platformDto.getCreatedAt(),
                    platformDto.getCreatedBy(),
                    platformDto.getUpdatedAt(),
                    platformDto.getUpdatedBy(),
                    new Version(platformDto.getVersion())
            );
            return platform;
        }
    }
}
