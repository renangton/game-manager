package com.gamemanager.infra.platform;

import com.gamemanager.domain.platform.PlatformRepository;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.extension.ExtendWith;
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

    // 実装予定
}
