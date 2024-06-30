package com.gamemanager.infra.platform;

import com.gamemanager.domain.platform.PlatformDto;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
        List<PlatformDto> actualPlatformList = platformMapper.selectAll();

        // then
        PlatformDto platformDto1 = new PlatformDto(
                "01F9SNHD3GY8E0RNHDY1T5PMTV",
                "PS4",
                LocalDateTime.of(2024, 3, 8, 12, 30, 30),
                "API",
                LocalDateTime.of(2024, 3, 8, 12, 30, 30),
                "API",
                0
        );
        PlatformDto platformDto2 = new PlatformDto(
                "01F9SNHD3H63J5NW9KYK56QZ0Y",
                "PS5",
                LocalDateTime.of(2024, 3, 8, 12, 30, 30),
                "API",
                LocalDateTime.of(2024, 3, 8, 12, 30, 30),
                "API",
                0
        );
        List<PlatformDto> expectedPlatformList = Arrays.asList(platformDto1, platformDto2);
        assertEquals(actualPlatformList, expectedPlatformList);
    }

    @Test
    @DataSet(value = "common/empty.yaml")
    void プラットフォームが1件も存在しない場合空のリストを取得すること() {
        // when
        List<PlatformDto> actualPlatformList = platformMapper.selectAll();

        // then
        List<PlatformDto> expectedPlatformList = Arrays.asList();
        assertEquals(actualPlatformList, expectedPlatformList);
    }


    @Test
    @DataSet(value = "common/platformOnly.yaml")
    void プラットフォームを1件取得できること() {
        // when
        Optional<PlatformDto> actualPlatform = platformMapper.selectById("01F9SNHD3GY8E0RNHDY1T5PMTV");

        // then
        Optional<PlatformDto> expectedPlatform = Optional.of(
                new PlatformDto(
                        "01F9SNHD3GY8E0RNHDY1T5PMTV",
                        "PS4",
                        LocalDateTime.of(2024, 3, 8, 12, 30, 30),
                        "API",
                        LocalDateTime.of(2024, 3, 8, 12, 30, 30),
                        "API",
                        0
                )
        );
        assertEquals(actualPlatform, expectedPlatform);
    }

    @Test
    @DataSet(value = "common/platformOnly.yaml")
    void 指定したIDのプラットフォームが存在しない場合空のOptionalを取得すること() {
        // when
        Optional<PlatformDto> actualPlatform = platformMapper.selectById("00000000000000000000000000");

        // then
        assertEquals(actualPlatform, Optional.empty());
    }

    @ParameterizedTest
    @CsvSource({"null", "''", "invalid-ulid", "123", "01F9SNHD3GY8E0RNHDY1T5PMT@"})
    @DataSet(value = "common/platformOnly.yaml")
    void IDに無効な形式のIDを指定した場合空のOptionalを取得すること(String testValue) {
        // when
        String actualValue = testValue.equals("null") ? null : testValue;
        Optional<PlatformDto> actualPlatform = platformMapper.selectById(actualValue);

        // then
        assertEquals(actualPlatform, Optional.empty());
    }

    @Test
    @DataSet
    void プラットフォームを登録できること() {
        // when
        platformMapper.insert(
                "01J1FM6SP9D5GG003QR0N5WD0K",
                "3DS",
                LocalDateTime.of(2024, 6, 8, 12, 30, 30),
                "API",
                LocalDateTime.of(2024, 6, 8, 12, 30, 30),
                "API",
                0
        );
        Optional<PlatformDto> actualPlatform = platformMapper.selectById("01J1FM6SP9D5GG003QR0N5WD0K");

        // then
        Optional<PlatformDto> expectedPlatform = Optional.of(
                new PlatformDto(
                        "01J1FM6SP9D5GG003QR0N5WD0K",
                        "3DS",
                        LocalDateTime.of(2024, 6, 8, 12, 30, 30),
                        "API",
                        LocalDateTime.of(2024, 6, 8, 12, 30, 30),
                        "API",
                        0
                )
        );
        assertEquals(actualPlatform, expectedPlatform);
    }

    @Test
    @DataSet(value = "common/platformOnly.yaml")
    void プラットフォームを更新できること() {
        // when
        platformMapper.update(
                "01F9SNHD3GY8E0RNHDY1T5PMTV",
                "NEOGEO",
                ZonedDateTime.of(2024, 6, 8, 12, 30, 30, 0, ZoneId.of("Asia/Tokyo")).toLocalDateTime(),
                "API2",
                0
        );
        Optional<PlatformDto> actualPlatform = platformMapper.selectById("01F9SNHD3GY8E0RNHDY1T5PMTV");

        // then
        Optional<PlatformDto> expectedPlatform = Optional.of(
                new PlatformDto(
                        "01F9SNHD3GY8E0RNHDY1T5PMTV",
                        "NEOGEO",
                        LocalDateTime.of(2024, 3, 8, 12, 30, 30),
                        "API",
                        LocalDateTime.of(2024, 6, 8, 12, 30, 30),
                        "API2",
                        1
                )
        );
        assertEquals(actualPlatform, expectedPlatform);
    }

    @Test
    @DataSet(value = "common/platformOnly.yaml")
    void プラットフォームを削除できること() {
        // when
        platformMapper.delete("01F9SNHD3GY8E0RNHDY1T5PMTV");
        List<PlatformDto> actualPlatformList = platformMapper.selectAll();

        // then
        PlatformDto platformDto = new PlatformDto(
                "01F9SNHD3H63J5NW9KYK56QZ0Y",
                "PS5",
                LocalDateTime.of(2024, 3, 8, 12, 30, 30),
                "API",
                LocalDateTime.of(2024, 3, 8, 12, 30, 30),
                "API",
                0
        );
        List<PlatformDto> expectedPlatformList = Arrays.asList(platformDto);
        assertEquals(actualPlatformList, expectedPlatformList);
    }
}
