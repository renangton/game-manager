package com.gamemanager.infra.platform;

import com.gamemanager.domain.platform.PlatformRepository;
import com.gamemanager.domain.platform.Platform;
import com.gamemanager.domain.platform.PlatformId;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class PlatformRdbRepository implements PlatformRepository {
    private final PlatformMapper platformMapper;

    public PlatformRdbRepository(PlatformMapper platformMapper) {
        this.platformMapper = platformMapper;
    }

    @Override
    public List<Platform> findAll() {
        return platformMapper.selectAll();
    }

    @Override
    public Optional<Platform> findById(PlatformId platformId) {
        return platformMapper.selectById(platformId);
    }

    @Override
    public void save(Platform platform) {
        platformMapper.insert(platform);
    }

    @Override
    public void update(Platform platform) {
        platformMapper.update(platform);
    }

    @Override
    public void delete(PlatformId platformId) {
        platformMapper.delete(platformId);
    }
}
