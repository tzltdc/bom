package io.github.android.tang.tony.test.util;

import com.google.common.truth.Truth;
import org.junit.Test;

public class GsonTestUtilTest {

  @Test
  public void from() {

    Truth.assertThat(GsonTestUtil.from("key.json", KeyEntity.class))
        .isEqualTo(KeyEntity.create("1", "Tony"));
  }
}
