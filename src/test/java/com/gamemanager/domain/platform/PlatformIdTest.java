package com.gamemanager.domain.platform;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlatformIdTest {

  @Test
  public void デフォルトコンストラクタはnullおよび空文字以外を生成すること() {
    
      PlatformId platformId = new PlatformId();
      assertNotNull(platformId.getValue());
      assertFalse(platformId.getValue().isEmpty());
  }

  @Test
  public void パラメータ付きコンストラクタは初期化された値を正しく返すこと() {
      String testValue = "test-value";
      PlatformId platformId = new PlatformId(testValue);
      assertEquals(testValue, platformId.getValue());
  }
}
