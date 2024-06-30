package com.gamemanager.infra.platform;

import com.gamemanager.domain.platform.PlatformDto;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PlatformMapper {
    List<PlatformDto> selectAll();

    Optional<PlatformDto> selectById(String platformIdStr);

    void insert(String platformId, String name, Timestamp createdAt, String createdBy, Timestamp updatedAt, String updatedBy, int version);

    void update(String platformId, String name, Timestamp updatedAt, String updatedBy, int version);

    void delete(String platformId);
}
