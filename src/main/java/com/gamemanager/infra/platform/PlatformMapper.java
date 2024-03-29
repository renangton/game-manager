package com.gamemanager.infra.platform;

import com.gamemanager.domain.platform.Platform;
import com.gamemanager.domain.platform.PlatformId;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PlatformMapper {
    List<Platform> selectAll();

    Optional<Platform> selectById(PlatformId platformId);

    void insert(Platform platform);

    void update(Platform platform);

    void delete(PlatformId platformId);
}
