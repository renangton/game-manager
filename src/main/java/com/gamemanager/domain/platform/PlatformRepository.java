package com.gamemanager.domain.platform;

import java.util.List;
import java.util.Optional;

public interface PlatformRepository {
    List<PlatformDto> findAll();

    Optional<PlatformDto> findById(PlatformId platformId);

    void save(Platform platform);

    void update(Platform platform);

    void delete(PlatformId platformId);
}
