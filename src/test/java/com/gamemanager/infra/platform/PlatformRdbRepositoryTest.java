package com.gamemanager.infra.platform;

import com.gamemanager.domain.platform.PlatformId;
import com.gamemanager.domain.platform.PlatformRepository;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.gamemanager.domain.platform.Platform;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DBRider
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(SpringExtension.class)
@SpringBootTest
class PlatformRdbRepositoryTest {
    private final PlatformRepository platformRepository;

    @Autowired
    PlatformRdbRepositoryTest(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
    }

    @Test
    @DataSet(value = "common/platformOnly.yaml")
    void プラットフォームを全件取得できること() {
        // when
        List<Platform> platformList = platformRepository.findAll();
        System.out.println(platformList);

        // then
//        assertEquals(platformList, "hoge");
    }

//    @Test
//    @DataSet(value = "common/platformOnly.yaml")
//    void 指定のプラットフォームを1件取得できること() {
//        // when
//        Optional<Platform> platformList = platformRepository.findById(new PlatformId("01F9SNHD3GY8E0RNHDY1T5PMTV"));
//        System.out.println(platformList);
//
//        // then
////        assertEquals(platformList, "hoge");
//    }
}
