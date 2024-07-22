package com.gamemanager.domain.platform;

import java.util.List;
import java.util.Optional;

public interface PlatformRepository {
    List<PlatformDto> findAll();

    Optional<PlatformDto> findById(String platformId);

    void save(Platform platform);

    void update(Platform platform);

    void delete(String platformId);
}
