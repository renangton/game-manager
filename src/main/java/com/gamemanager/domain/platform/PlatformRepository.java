package com.gamemanager.domain.platform;

import java.util.List;
import java.util.Optional;

public interface PlatformRepository {
    List<Platform> findAll();

    Optional<Platform> findById(PlatformId platformId);

    void save(Platform platform);

    void update(Platform platform);

    void delete(PlatformId platformId);
}
