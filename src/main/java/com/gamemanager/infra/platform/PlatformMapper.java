package com.gamemanager.infra.platform;

import com.gamemanager.domain.platform.PlatformDto;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PlatformMapper {
    List<PlatformDto> selectAll();

    Optional<PlatformDto> selectById(String platformIdStr);

    void insert(String platformId, String name, String createdAt, String createdBy, String updatedAt, String updatedBy, int version);

    void update(String platformId, String name, String updatedAt, String updatedBy, int version);

    void delete(String platformId);
}
