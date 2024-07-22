package com.gamemanager.domain.platform;

import com.gamemanager.domain.shared.lock.OptimisticLockable;
import com.gamemanager.domain.shared.lock.Version;
import java.time.LocalDateTime;
import java.util.Objects;

public class Platform implements OptimisticLockable {
    private final PlatformId platformId;
    private String name;
    private final LocalDateTime createdAt;
    private final String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
    private final Version version;

    public Platform(PlatformId platformId, String name, LocalDateTime createdAt, String createdBy,
                    LocalDateTime updatedAt, String updatedBy, Version version) {
        this.platformId = platformId;
        this.name = name;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
        this.version = version;
    }

    /**
     * プラットフォームを作成する
     *
     * @param name      プラットフォーム名
     * @param createdBy プラットフォーム作成者
     * @return 新規作成されたプラットフォームオブジェクト
     */
    public static Platform create(String name, String createdBy) {
        PlatformId platformId = new PlatformId();
        LocalDateTime localDateTime = LocalDateTime.now();
        return new Platform(
                platformId,
                name,
                localDateTime,
                createdBy,
                localDateTime,
                createdBy,
                Version.initial());
    }

    /**
     * プラットフォームを再構築する
     *
     * @param platformId プラットフォームID
     * @param name       プラットフォーム名
     * @param createdAt  プラットフォーム作成日
     * @param createdBy  プラットフォーム作成者
     * @param updatedAt  プラットフォーム更新日
     * @param updatedBy  プラットフォーム更新者
     * @param version    プラットフォームバージョン
     * @return 再構築されたプラットフォームオブジェクト
     */
    public static Platform reconstruct(PlatformId platformId, String name, LocalDateTime createdAt, String createdBy,
                                       LocalDateTime updatedAt, String updatedBy, Version version) {
        return new Platform(platformId, name, createdAt, createdBy, updatedAt, updatedBy, version);
    }

    /**
     * プラットフォームを更新する
     *
     * @param name      プラットフォーム名
     * @param updatedAt プラットフォーム更新日
     * @param updatedBy プラットフォーム更新者
     */
    public void updatePlatform(String name, LocalDateTime updatedAt, String updatedBy) {
        this.name = name;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }

    public PlatformId getPlatformId() {
        return platformId;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    @Override
    public Version getVersion() {
        return version;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Platform platform = (Platform) o;
        return Objects.equals(
                getPlatformId(), platform.getPlatformId())
                && Objects.equals(getName(), platform.getName())
                && Objects.equals(getCreatedAt(), platform.getCreatedAt())
                && Objects.equals(getCreatedBy(), platform.getCreatedBy())
                && Objects.equals(getUpdatedAt(), platform.getUpdatedAt())
                && Objects.equals(getUpdatedBy(), platform.getUpdatedBy())
                && Objects.equals(getVersion(), platform.getVersion()
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlatformId(), getName(), getCreatedAt(), getCreatedBy(), getUpdatedAt(), getUpdatedBy(), getVersion());
    }
}
