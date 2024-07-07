package com.gamemanager.infra.platform;

import com.gamemanager.domain.platform.PlatformDto;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PlatformMapper {
    List<PlatformDto> selectAll();

    Optional<PlatformDto> selectById(String platformIdStr);

    void insert(
            @Param("platformId") String platformId,
            @Param("name") String name,
            @Param("createdAt") LocalDateTime createdAt,
            @Param("createdBy") String createdBy,
            @Param("updatedAt") LocalDateTime updatedAt,
            @Param("updatedBy") String updatedBy,
            @Param("version") int version
    );

    void update(
            @Param("platformId") String platformId,
            @Param("name") String name,
            @Param("updatedAt") LocalDateTime updatedAt,
            @Param("updatedBy") String updatedBy,
            @Param("version") int version
    );

    void delete(String platformId);
}
