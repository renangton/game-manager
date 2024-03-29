package com.gamemanager.infra.platform;

import com.gamemanager.domain.platform.Platform;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

@DBRider
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PlatformMapperTest {
    @Autowired
    PlatformMapper platformMapper;

    @Test
    @DataSet(value = "common/platformOnly.yaml")
    void プラットフォームを全件取得できること() {
        // when
        List<Platform> platformList = platformMapper.selectAll();
        System.out.println(platformList);

        // then
//        assertEquals(platformList, "hoge");
    }
}
