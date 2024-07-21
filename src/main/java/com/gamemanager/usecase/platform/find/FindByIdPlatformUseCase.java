package com.gamemanager.usecase.platform.find;

import com.gamemanager.domain.platform.Platform;

public interface FindByIdPlatformUseCase {
    Platform findByIdPlatform(String platformId);
}
