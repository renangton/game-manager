package com.gamemanager.infra.platform;

import com.gamemanager.domain.platform.Platform;
import com.gamemanager.domain.platform.PlatformDto;
import com.gamemanager.domain.platform.PlatformId;
import com.gamemanager.domain.platform.PlatformRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class PlatformRdbRepository implements PlatformRepository {
    private final PlatformMapper platformMapper;

    public PlatformRdbRepository(PlatformMapper platformMapper) {
        this.platformMapper = platformMapper;
    }

    /**
     * プラットフォームを全件取得する
     *
     * @return プラットフォームのリスト
     */
    @Override
    public List<PlatformDto> findAll() {
        return platformMapper.selectAll();
    }

    /**
     * プラットフォームを1件取得する
     *
     * @param platformId プラットフォームID
     * @return Optionalにラップされた1件のプラットフォーム、存在しない場合は空のOptional
     */
    @Override
    public Optional<PlatformDto> findById(PlatformId platformId) {
        return platformMapper.selectById(platformId.getValue());
    }

    /**
     * プラットフォームを保存する
     *
     * @param platform プラットフォーム
     * @return なし
     */
    @Override
    public void save(Platform platform) {
        platformMapper.insert(
                platform.getPlatformId().getValue(),
                platform.getName(),
                platform.getCreatedAt(),
                platform.getCreatedBy(),
                platform.getUpdatedAt(),
                platform.getUpdatedBy(),
                platform.getVersion().value()
        );
    }

    /**
     * プラットフォームを更新する
     *
     * @param platform プラットフォーム
     * @return なし
     */
    @Override
    public void update(Platform platform) {
        platformMapper.update(
                platform.getPlatformId().getValue(),
                platform.getName(),
                platform.getUpdatedAt(),
                platform.getUpdatedBy(),
                platform.getVersion().value()
        );
    }

    /**
     * プラットフォームを削除する
     *
     * @param platformId プラットフォームID
     * @return なし
     */
    @Override
    public void delete(PlatformId platformId) {
        platformMapper.delete(platformId.getValue());
    }
}
